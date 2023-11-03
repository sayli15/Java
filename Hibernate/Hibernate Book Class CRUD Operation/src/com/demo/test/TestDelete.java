package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.bean.Book;


public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Book b = (Book)session.get(Book.class, 101);
		if(b!=null) {
			System.out.println(b);
			session.delete(b);
			System.out.println("Record deleted successfully!");
		}
		else {
			System.out.println("No record found! \nNot deleted");
		}
		
		t.commit();
		System.out.println("Done...");
		session.close();

	}

}
