//Hibernate Inheritance Mapping
//Table per Hierarchy

package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.bean.Developer;
import com.demo.bean.Employee;
import com.demo.bean.Manager;



public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Employee e1 = new Employee("ABC",20000);
		Manager m1 = new Manager("PQR", 25000,2300);
		Developer d1 = new Developer("XYZ", 45000, 5);
		
		session.save(e1);
		session.save(m1);
		session.save(d1);
		t.commit();
		session.close();
		System.out.println("Done...");

	}

}
