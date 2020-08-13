package com.springcloud.test.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springcloud.test.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				return null;
			}
			
			@Override
			public Dept get(Long id) {
//				return null;
				Dept dept = new Dept();
				dept.setDeptno(id);
				dept.setDname("该ID："+id+"没有对应信息，Consumer客户端提供的降级信息");
				dept.setDname("no this database in MySQL");
				return dept;
			}
			
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
