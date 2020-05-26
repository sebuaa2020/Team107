package com.example.business.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.business.entity.Project;
import com.example.business.service.IProjectService;
import com.example.business.vo.ProjectVo;
import com.example.system.entity.Loginlog;
import com.example.system.entity.User;
import com.example.system.utils.common.ConstantUtils;
import com.example.system.utils.common.JSON.JSONResult;
import com.example.system.utils.common.WebUtils;
import com.example.system.vo.LoginlogVo;
import com.example.system.vo.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.example.system.utils.common.ConstantUtils.*;

@RequestMapping("/project")
@RestController
public class ProjectController {

    @Autowired
    IProjectService projectService;

    @RequestMapping("/loadAllProject")
    public JSONResult loadAllProject(ProjectVo projectVo){
        IPage<Project> page=new Page<>(projectVo.getPage(), projectVo.getLimit());
        QueryWrapper<Project> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(projectVo.getName()),"name",projectVo.getName());
        queryWrapper.like(StringUtils.isNotBlank(projectVo.getRemark()),"remark", projectVo.getRemark());
        queryWrapper.like(projectVo.getOpen()!=null && projectVo.getOpen()!=2,"open",projectVo.getOpen());
        queryWrapper.ge(projectVo.getStartTime()!=null, "createtime", projectVo.getStartTime());
        queryWrapper.le(projectVo.getEndTime()!=null, "createtime", projectVo.getEndTime());

//        queryWrapper.like(StringUtils.isNotBlank(ProjectVo.getLoginname()),"loginname", ProjectVo.getLoginname());
//        queryWrapper.like(StringUtils.isNotBlank(ProjectVo.getLoginip()), "loginip",ProjectVo.getLoginip());

        queryWrapper.orderByDesc("createtime");
        projectService.page(page, queryWrapper);

        System.out.println(page.getRecords());
        //return JSONResult.ok(page.getTotal(), LoginLogTOJSON(page.getRecords()));
        return JSONResult.ok(page.getTotal(), page.getRecords());
    }

    /**
     * 添加
     */
    @RequestMapping("addProject")
    public JSONResult addProject(ProjectVo projectVo) {
        try {
            projectVo.setCreatetime(new Date());
            User user = (User) WebUtils.getSession().getAttribute(USER_SESSION_KEY);
            this.projectService.save(projectVo);
            return ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ADD_ERROR;
        }
    }

    /**
     * 修改
     */
    @RequestMapping("updateProject")
    public JSONResult updateProject(ProjectVo projectVo) {
        try {
            this.projectService.updateById(projectVo);
            return UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return UPDATE_ERROR;
        }
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteProject")
    public JSONResult deleteProject(Integer id){
        try {
            this.projectService.removeById(id);
            return ConstantUtils.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtils.DELETE_ERROR;
        }
    }


    /**
     * 项目开启按钮
     */
    @RequestMapping("/updateOpen")
    public JSONResult updateOpen(ProjectVo projectVo){
//        System.out.println(projectVo.getId() + "    " + projectVo.getOpen());
        try {
            UpdateWrapper<Project> updateWrapper =new UpdateWrapper <>();
            updateWrapper.eq("id",projectVo.getId());
            updateWrapper.set("open",projectVo.getOpen());
            this.projectService.update(updateWrapper);
            return UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return UPDATE_ERROR;
        }
//        return UPDATE_SUCCESS;
    }

}
