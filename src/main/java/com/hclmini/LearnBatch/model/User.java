package com.hclmini.LearnBatch.model;

import java.util.Date;

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
	private Date time;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(Integer id, String name, String dept, Integer salary, Integer age, Date time) {
		
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.age = age;
		this.time = time;
	}

	public Date getTime() {
		return time;
	}



	public void setTime(Date time) {
		this.time = time;
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



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", age=" + age
				+ ", time=" + time + "]";
	}
	
	
	
}
