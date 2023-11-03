package com.demo.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.demo.bean.Products;

public class DemoHQL1 {
Session s;

		public DemoHQL1() {
		Configuration cfg=new Configuration().configure();
		ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory sf=cfg.buildSessionFactory(sr);
		s=sf.openSession();
	}

	public void showProducts() {
		Transaction t=s.beginTransaction();
		Query query=s.createQuery("from Products");
		List<Products> list=query.list();
		for(Products p:list)
			System.out.println(p);
		t.commit();
		s.close();
	}
	public static void main(String[] args) {
			
		DemoHQL1 dh1=new DemoHQL1();
		dh1.showProducts();
}
}