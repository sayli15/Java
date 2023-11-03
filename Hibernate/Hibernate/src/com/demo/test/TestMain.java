package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.bean.Employee;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(12,"XYZ",5000);
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.save(e1);
		t.commit();
		System.out.println("Done...");
		session.close();
		
		

	}

}
