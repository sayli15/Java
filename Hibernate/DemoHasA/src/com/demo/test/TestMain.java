package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.bean.Address;
import com.demo.bean.Employee;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Address a1 = new Address("PUNE",411029);
		Employee e1 = new Employee(123,"ABC",a1);
		session.save(e1);
		t.commit();
		System.out.println("Done...");
		session.close();
	}

}
