package com.demo.bean;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mgrtpc")
public class Manager extends Employee {
	double incentive;

	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}

	public Manager(int empno, String ename, double salary, double incentive) {
		super(empno, ename, salary);
		this.incentive = incentive;
	}
	
	public Manager(String ename, double salary, double incentive) {
		super(ename, salary);
		this.incentive = incentive;
	}

	public Manager(double incentive) {
		this.incentive = incentive;
	}

	@Override
	public String toString() {
		return "Manager [incentive=" + incentive + ", toString()=" + super.toString() + "]";
	}
	
	
}
