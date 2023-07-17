package com.qf.service.impl;

import java.util.List;

import com.qf.dao.AchievementDao;

import com.qf.dao.impl.AchievementDaoImpl;

import com.qf.domain.Achievement;

import com.qf.domain.PageBean;
import com.qf.service.AchievementService;

public class AchievementServiceImpl implements AchievementService {
	
	private AchievementDao achievementDao=new AchievementDaoImpl();

	@Override
	public List<Achievement> findAll() {
		// TODO Auto-generated method stub
		return achievementDao.findAll();
	}

	@Override
	public List<Achievement> findBySearch(int stuid) {
		// TODO Auto-generated method stub
		return achievementDao.findBySearch(stuid);
	}

	@Override
	public void add(Achievement achievement) {
		// TODO Auto-generated method stub
		achievementDao.add(achievement);

	}

	@Override
	public void update(Achievement achievement) {
		// TODO Auto-generated method stub
		achievementDao.update(achievement);

	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		achievementDao.delete(id);

	}

	@Override
	public Achievement findById(int id) {
		// TODO Auto-generated method stub
		return achievementDao.findById(id);
	}

	@Override
	public PageBean findByPage(int pageNum, int pageSize, String coursename) {
		//查询总的数据个数
		long totalCount=achievementDao.getCount(coursename);
		
		List<Achievement> data=achievementDao.findByPage(pageNum, pageSize, coursename);
		
		//创建PageBean
		PageBean pageBean=new PageBean(pageNum, pageSize, totalCount, data);
		
		return pageBean;
	}

}
