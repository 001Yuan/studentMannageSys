package com.qf.service.impl;

import java.util.List;

import com.qf.dao.CclasDao;
import com.qf.dao.impl.CclasDaoImpl;
import com.qf.domain.Cclas;
import com.qf.domain.PageBean;
import com.qf.domain.Student;
import com.qf.domain.Teacher;
import com.qf.service.CclasService;

public class CclasServiceImpl implements CclasService {
	
	private CclasDao cclassDao=new CclasDaoImpl();

	@Override
	public List<Cclas> findAll() {
		// TODO Auto-generated method stub
		return cclassDao.findAll();
	}

	@Override
	public List<Cclas> findBySearch(String classname) {
		// TODO Auto-generated method stub
		return cclassDao.findBySearch(classname);
	}

	@Override
	public void add(Cclas clas) {
		// TODO Auto-generated method stub
		cclassDao.add(clas);

	}

	@Override
	public void update(Cclas clas) {
		cclassDao.update(clas);

	}

	@Override
	public void delete(int id) {
		cclassDao.delete(id);

	}

	@Override
	public Cclas findById(int id) {
		// TODO Auto-generated method stub
		return cclassDao.findById(id);
	}

	@Override
	public PageBean findByPage(int pageNum, int pageSize, String classname) {
		//查询总的数据个数
				long totalCount=cclassDao.getCount(classname);
				
				List<Cclas> data=cclassDao.findByPage(pageNum, pageSize, classname);
				
				//创建PageBean
				PageBean pageBean=new PageBean(pageNum, pageSize, totalCount, data);
				
				return pageBean;
	}
	
	@Override
	public  List<Cclas> findAlltname(){
		return cclassDao.findAlltname();
	};

}
