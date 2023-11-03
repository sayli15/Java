package com.demo.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="empmgrdev")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="emptype",length=10,discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="EMP")

public class Employee {
	@Id
	@GeneratedValue
	int empno;
	@Column(length=10)
	String ename;
	double salary;
	
	public Employee(int empno, String ename, double salary) {
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
	}
	
	public Employee(String ename, double salary) {
		this.ename = ename;
		this.salary = salary;
	}

	public Employee() {
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", salary=" + salary + "]";
	}
	
	
	
}
