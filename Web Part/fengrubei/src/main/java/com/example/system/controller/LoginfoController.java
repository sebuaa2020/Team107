package com.example.system.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import com.example.system.entity.Loginlog;
import com.example.system.service.ILoginlogService;
import com.example.system.utils.common.ConstantUtils;
import com.example.system.utils.common.JSON.JSONResult;
import com.example.system.vo.LoginlogVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 老雷
 * @since 2019-09-21
 */
@RestController
@RequestMapping("/loginlog")
public class LoginfoController {
	
	@Autowired
	private ILoginlogService loginlogService;
	
	/**
	 * 全查询
	 */
	@RequestMapping("loadAllLoginfo")
	public JSONResult loadAllLoginfo(LoginlogVo loginlogvo) {
		IPage<Loginlog> page=new Page<>(loginlogvo.getPage(), loginlogvo.getLimit());
		QueryWrapper<Loginlog> queryWrapper=new QueryWrapper<>();
		queryWrapper.like(StringUtils.isNotBlank(loginlogvo.getLoginname()),"loginname", loginlogvo.getLoginname());
		queryWrapper.like(StringUtils.isNotBlank(loginlogvo.getLoginip()), "loginip",loginlogvo.getLoginip());
		queryWrapper.ge(loginlogvo.getStartTime()!=null, "logintime", loginlogvo.getStartTime());
		queryWrapper.le(loginlogvo.getEndTime()!=null, "logintime", loginlogvo.getEndTime());
		queryWrapper.orderByDesc("logintime");
		this.loginlogService.page(page, queryWrapper);


		System.out.println(page.getRecords());
		//return JSONResult.ok(page.getTotal(), LoginLogTOJSON(page.getRecords()));
		return JSONResult.ok(page.getTotal(), page.getRecords());
//		return new DataGridView(page.getTotal(), page.getRecords());
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteLoginfo")
	public JSONResult deleteLoginfo(Integer id) {
		try {
			this.loginlogService.removeById(id);
			return ConstantUtils.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ConstantUtils.DELETE_ERROR;
		}
	}


	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteLoginfo")
	public JSONResult batchDeleteLoginfo(LoginlogVo loginlogvo) {
		try {
			Collection<Serializable> idList=new ArrayList<Serializable>();
			for (Integer id : loginlogvo.getIds()) {
				idList.add(id);
			}
			this.loginlogService.removeByIds(idList);
			return ConstantUtils.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ConstantUtils.DELETE_ERROR;
		}
	}

}

