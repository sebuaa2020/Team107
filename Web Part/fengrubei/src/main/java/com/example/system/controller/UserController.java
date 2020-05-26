package com.example.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.business.vo.ProjectVo;
import com.example.system.entity.Loginlog;
import com.example.system.entity.User;
import com.example.system.service.IUserService;
import com.example.system.utils.common.JSON.JSONResult;
import com.example.system.vo.LoginlogVo;
import com.example.system.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.system.utils.common.ConstantUtils.UPDATE_ERROR;
import static com.example.system.utils.common.ConstantUtils.UPDATE_SUCCESS;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 全查询
     */
    @RequestMapping("loadAllUser")
    public JSONResult loadAllUser(UserVo userVo) {
        IPage<User> page=new Page<>(userVo.getPage(), userVo.getLimit());
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();

        queryWrapper.notLike("id",1);

        queryWrapper.like(StringUtils.isNotBlank(userVo.getName()),"name", userVo.getName());

        queryWrapper.like(StringUtils.isNotBlank(userVo.getRemark()), "remark",userVo.getRemark());
        queryWrapper.like(userVo.getAvailable()!=null && userVo.getAvailable()!=0, "available", userVo.getAvailable());
        queryWrapper.like(userVo.getType()!=null && userVo.getType()!=0, "type", userVo.getType());
        queryWrapper.orderByAsc("id");
        userService.page(page, queryWrapper);


        System.out.println(page.getRecords());
        //return JSONResult.ok(page.getTotal(), LoginLogTOJSON(page.getRecords()));
        return JSONResult.ok(page.getTotal(), page.getRecords());
//		return new DataGridView(page.getTotal(), page.getRecords());
    }

    /**
     * 修改
     */
    @RequestMapping("updateUser")
    public JSONResult updateUser(UserVo userVo) {
        try {
            this.userService.updateById(userVo);
            return UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return UPDATE_ERROR;
        }
    }

}
