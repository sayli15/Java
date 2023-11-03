package com.demo.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="DEV")
public class Developer extends Employee {
	int noOfProjects;

	public int getNoOfProjects() {
		return noOfProjects;
	}

	public void setNoOfProjects(int noOfProjects) {
		this.noOfProjects = noOfProjects;
	}

	public Developer(int empno, String ename, double salary, int noOfProjects) {
		super(empno, ename, salary);
		this.noOfProjects = noOfProjects;
	}

	public Developer(String ename, double salary, int noOfProjects) {
		super(ename, salary);
		this.noOfProjects = noOfProjects;
	}

	public Developer(int noOfProjects) {
		this.noOfProjects = noOfProjects;
	}

	@Override
	public String toString() {
		return "Developer [noOfProjects=" + noOfProjects + ", toString()=" + super.toString() + "]";
	}


}
