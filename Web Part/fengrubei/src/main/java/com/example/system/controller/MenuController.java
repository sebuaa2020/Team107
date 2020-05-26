package com.example.system.controller;


import java.util.ArrayList;
import java.util.List;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.system.utils.common.JSON.JSONResult;
import com.example.system.utils.common.WebUtils;
import com.example.system.entity.Permission;
import com.example.system.entity.User;
import com.example.system.service.IPermissionService;

import com.example.system.utils.common.MENU.TreeNode;
import com.example.system.utils.common.MENU.TreeNodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.system.utils.common.ConstantUtils.*;


/**
 * <p>
 *  菜单管理前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/menu")
public class MenuController {


	@Autowired
	private IPermissionService permissionService;
	
	
	@RequestMapping("loadIndexLeftMenuJson")
	public JSONResult loadIndexLeftMenuJson() {
		User user = (User) WebUtils.getSession().getAttribute(USER_SESSION_KEY);
		QueryWrapper<Permission> wrapper = new QueryWrapper<>();
		wrapper.eq(PERMISSION_TABLE_TYPE,TYPE_MENU);
		List<Permission> list=null;
		if(user.getType()==USER_TYPE_SUPER) {
			list = permissionService.list(wrapper);
		}else {
			//根据用户ID+角色+权限去查询
			list = permissionService.list(wrapper);
		}
		//查询所有菜单

		//设置只能查询菜单




		List<TreeNode> treeNodes=new ArrayList<>();
		for (Permission p : list) {
			Integer id=p.getId();
			Integer pid=p.getPid();
			String title=p.getTitle();
			String icon=p.getIcon();
			String href=p.getHref();
			Boolean spread=p.getOpen()==OPEN_TRUE?true:false;
			treeNodes.add(new TreeNode(id, pid, title, icon, href, spread));
		}
		//构造层级关系
		List<TreeNode> list2 = TreeNodeBuilder.build(treeNodes, 1);

		return JSONResult.ok(list2);

	}
	
}

