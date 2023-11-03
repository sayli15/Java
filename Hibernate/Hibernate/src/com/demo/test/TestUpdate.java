package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.bean.Employee;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Employee e1 = (Employee)session.get(Employee.class, 12);
		
		if(e1!=null) {
			System.out.println(e1);
			e1.setSalary(60000);
			e1.setName("ABC");
			session.update(e1);
			System.out.println("Record updated successfully!");
		}
		else {
			System.out.println("Not updated!");
		}
	
		t.commit();
		System.out.println("Done...");
		session.close();

	}

}
