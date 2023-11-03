package com.demo.bean;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hasaemp")
public class Employee {
	@Id
	int empno;
	@Column(length=15)
	String ename;
	@Embedded
	Address location;
	
	public Employee() {
	}

	public Employee(int empno, String ename, Address location) {
		this.empno = empno;
		this.ename = ename;
		this.location = location;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", location=" + location + "]";
	}
	
	

}
