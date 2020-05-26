package com.example.business.service.impl;

import com.example.business.entity.Project;
import com.example.business.mapper.ProjectMapper;
import com.example.business.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buyu
 * @since 2020-02-22
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

}
