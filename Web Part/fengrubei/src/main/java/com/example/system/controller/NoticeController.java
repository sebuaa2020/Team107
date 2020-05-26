package com.example.system.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.example.system.entity.Notice;
import com.example.system.service.INoticeService;
import com.example.system.utils.common.JSON.JSONResult;
import com.example.system.utils.common.WebUtils;
import com.example.system.entity.User;
import com.example.system.vo.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import static com.example.system.utils.common.ConstantUtils.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 老雷
 * @since 2019-09-21
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private INoticeService noticeService;
	
	
	/**
	 * 查询
	 */
	@RequestMapping("loadAllNotice")
	public JSONResult loadAllNotice(NoticeVo noticeVo) {
		IPage<Notice> page=new Page<>(noticeVo.getPage(), noticeVo.getLimit());
		QueryWrapper<Notice> queryWrapper=new QueryWrapper<>();
		queryWrapper.like(StringUtils.isNotBlank(noticeVo.getTitle()), "title", noticeVo.getTitle());
		queryWrapper.like(StringUtils.isNotBlank(noticeVo.getOpername()), "opername", noticeVo.getOpername());
		queryWrapper.ge(noticeVo.getStartTime()!=null, "createtime", noticeVo.getStartTime());
		queryWrapper.le(noticeVo.getEndTime()!=null, "createtime", noticeVo.getEndTime());
		queryWrapper.orderByDesc("createtime");
		this.noticeService.page(page, queryWrapper);
		System.out.println(page.getRecords());
		return JSONResult.ok(page.getTotal(), page.getRecords());
	}
	
	
	/**
	 * 添加
	 */
	@RequestMapping("addNotice")
	public JSONResult addNotice(NoticeVo noticeVo) {
		try {
			noticeVo.setCreatetime(new Date());
			User user = (User) WebUtils.getSession().getAttribute(USER_SESSION_KEY);
			noticeVo.setOpername(user.getName());
			this.noticeService.save(noticeVo);
			return ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ADD_ERROR;
		}
	}
	/**
	 * 修改
	 */
	@RequestMapping("updateNotice")
	public JSONResult updateNotice(NoticeVo noticeVo) {
		try {
			this.noticeService.updateById(noticeVo);
			return UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return UPDATE_ERROR;
		}
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteNotice")
	public JSONResult deleteNotice(Integer id) {
		try {
			this.noticeService.removeById(id);
			return DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return DELETE_ERROR;
		}
	}
	
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteNotice")
	public JSONResult batchDeleteNotice(NoticeVo noticeVo) {
		try {
			Collection<Serializable> idList=new ArrayList<Serializable>();
			for (Integer id : noticeVo.getIds()) {
				idList.add(id);
			}
			this.noticeService.removeByIds(idList);
			return DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return DELETE_ERROR;
		}
	}
}

