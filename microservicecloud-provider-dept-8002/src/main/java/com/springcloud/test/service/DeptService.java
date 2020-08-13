package com.springcloud.test.service;

import java.util.List;

import com.springcloud.test.entities.Dept;

public interface DeptService {
	public boolean add(Dept dept);
	public Dept get(Long id);
	public List<Dept> list();
}
