package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.bean.Book;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book b = new Book(102,"Java",350);
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.save(b);
		t.commit();
		System.out.println("Done...");
		session.close();

	}

}
