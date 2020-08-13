package com.springcloud.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.test.dao.DeptDao;
import com.springcloud.test.entities.Dept;
import com.springcloud.test.service.DeptService;
@Service
public class DeptSerciceImpl implements DeptService{
	@Autowired
	private DeptDao dao;
	@Override
	public boolean add(Dept dept) {
		return dao.addDept(dept);
	}
	@Override
	public Dept get(Long id) {
		return dao.findById(id);
	}
	@Override
	public List<Dept> list() {
		return dao.findAll();
	}
}
