package com.demo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.demo.bean.Products;

public class DemoCriteria1 {
	
	Session s;
	public DemoCriteria1() {
		
			Configuration cfg=new Configuration().configure();
			ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build();
			SessionFactory sf=cfg.buildSessionFactory(sr);
			s=sf.openSession();
	}
	
	public void showProducts() {
		Transaction t = s.beginTransaction();
		Criteria criteria = s.createCriteria(Products.class);
		List<Products> plist= criteria.list();
		for(Products p:plist) {
			System.out.println(p);
		}
		t.commit();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoCriteria1 dc1 = new DemoCriteria1();
		dc1.showProducts();

	}

}
