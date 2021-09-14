package com.hclmini.LearnBatch.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Integer id;
	private String name;
	private String dept;
	private Integer salary;
	private Integer age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, String dept, Integer salary, Integer age) {
		
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
