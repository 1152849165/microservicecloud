package com.springcloud.myrule;

import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {
	public IRule myRule() {
//		return new RandomRule();//Ribbon默认是轮询，现在自定义为随机
		return new RandomRule_ZY(); //现在自定义每台机器5次
	}
}
