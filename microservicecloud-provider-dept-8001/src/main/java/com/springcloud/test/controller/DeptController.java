package com.springcloud.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.test.entities.Dept;
import com.springcloud.test.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value = "/dept/add",method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}
	
	@RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
	public Dept get(@PathVariable("id")Long id) {
		return service.get(id);
	}
	
	@RequestMapping(value = "/dept/list",method = RequestMethod.GET)
	public List<Dept> list(){
		return service.list();
	}
	
	@RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
	public Object discovery() {
		List<String> services = client.getServices();
		System.out.println("**********"+services);
		List<ServiceInstance> instances = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance instance : instances) {
			System.out.println(instance.getServiceId()+"\t"
					+instance.getHost()+"\t"
					+instance.getPort()+"\t"
					+instance.getUri());
		}
		return this.client;
	}
}
