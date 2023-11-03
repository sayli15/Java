package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.bean.Book;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Book b = (Book)session.get(Book.class, 102);
		
		if(b!=null) {
			System.out.println(b);
			b.setPrice(450);
			b.setTitle("Spring");
			session.update(b);
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
