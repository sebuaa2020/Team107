package com.example.business.controller;


import com.example.business.entity.Project;
import com.example.business.service.IProjectService;
import com.example.system.utils.common.ConstantUtils;
import com.example.system.utils.common.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bus")
public class BussinessController {

    @Autowired
    IProjectService projectService;

    /**
     * 跳转到项目管理
     */
    @RequestMapping("toProjectManager")
    public String toCustomerManager() {
        return "business/project/projectManager";
    }

    /**
     * 跳转到项目面板
     */
    @RequestMapping("toProjectManagerPanel")
    public String toProjectManagerPanel(){
        List<Project> lists = projectService.list();
        WebUtils.getSession().setAttribute(ConstantUtils.PROJECTS_SESSION_KEY,lists);
        return "business/project/projectManagerPanel";
    }


    /**
     * 跳转到数据集面板
     */
    @RequestMapping("toDatasetManager")
    public String toDatasetManager(){
        return "business/dataset/datasetManager";
    }
}
