package com.example.business.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.business.entity.Datasets;
import com.example.business.entity.Project;
import com.example.business.service.IDatasetsService;
import com.example.business.service.IProjectService;
import com.example.business.vo.DatasetsVo;
import com.example.system.utils.common.ConstantUtils;
import com.example.system.utils.common.JSON.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/dataset")
@RestController
public class DatasetController {
    @Autowired
    IDatasetsService datasetsService;

    @Autowired
    IProjectService projectService;

    @RequestMapping("/loadAllDataset")
    public JSONResult loadAllDataset(DatasetsVo datasetsVo){
        System.out.println("+++++++++++++++++++++");
        IPage<Datasets> page=new Page<>(datasetsVo.getPage(), datasetsVo.getLimit());
        QueryWrapper<Datasets> queryWrapperDatasets=new QueryWrapper<>();

        queryWrapperDatasets.like(StringUtils.isNotBlank(datasetsVo.getName()),"name",datasetsVo.getName());
        queryWrapperDatasets.like(StringUtils.isNotBlank(datasetsVo.getPath()),"path", datasetsVo.getPath());

        QueryWrapper<Project> queryWrapperProject=new QueryWrapper<>();
        queryWrapperProject.like(StringUtils.isNotBlank(datasetsVo.getProjectName()),"name",datasetsVo.getProjectName());

        datasetsService.page(page, queryWrapperDatasets);
        List<Project> projectList = projectService.list(queryWrapperProject);
        List<Datasets> datasetsList = page.getRecords();
        List<DatasetsVo> datasetsVoList = new ArrayList<>();

        int datasetsSize = datasetsList.size();
        int projectsSize = projectList.size();
        for(int i = 0; i < datasetsSize ; i++){
            DatasetsVo temp = new DatasetsVo(datasetsList.get(i));
            int typeid = temp.getTypeid();
            for(int j = 0; j < projectsSize ; j++){
                if(typeid == projectList.get(j).getId()){
                    temp.setProjectName(projectList.get(j).getName());
                    datasetsVoList.add(temp);
                    break;
                }
            }
        }

//        queryWrapper.like(StringUtils.isNotBlank(ProjectVo.getLoginname()),"loginname", ProjectVo.getLoginname());
//        queryWrapper.like(StringUtils.isNotBlank(ProjectVo.getLoginip()), "loginip",ProjectVo.getLoginip());

        System.out.println(datasetsVoList);
        //return JSONResult.ok(page.getTotal(), LoginLogTOJSON(page.getRecords()));
        return JSONResult.ok(page.getTotal(), datasetsVoList);
    }

    @RequestMapping("/deleteDataset")
    public JSONResult deleteProject(Integer id){
        try {
            this.datasetsService.removeById(id);
            return ConstantUtils.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtils.DELETE_ERROR;
        }
    }


}
