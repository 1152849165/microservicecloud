package com.springcloud.test.entities;

import java.io.Serializable;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;

//@SuppressWarnings(value = "serial")
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Accessors(chain = true)
@SuppressWarnings("serial")
public class Dept implements Serializable{  //继承改接口 是序列化该实体类（必须）
	private Long deptno; //主键。
	private String dname;  //部门名称。
	private String db_source; //来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	
	
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Dept(Long deptno, String dname, String db_source) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.db_source = db_source;
	}


	public Long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDb_source() {
		return db_source;
	}
	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}

	
}
