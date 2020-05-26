package com.example.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.system.entity.Loginlog;
import com.example.system.mapper.LoginlogMapper;
import com.example.system.service.ILoginlogService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buyu
 * @since 2020-02-16
 */
@Service
public class LoginlogServiceImpl extends ServiceImpl<LoginlogMapper, Loginlog> implements ILoginlogService {

}
