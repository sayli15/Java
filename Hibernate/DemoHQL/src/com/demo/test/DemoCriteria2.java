package com.demo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import com.demo.bean.Products;

public class DemoCriteria2 {
	
	Session s;
	public DemoCriteria2() {
		
			Configuration cfg=new Configuration().configure();
			ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build();
			SessionFactory sf=cfg.buildSessionFactory(sr);
			s=sf.openSession();
	}
	
	public void showProducts() {
		Transaction t = s.beginTransaction();
		Criteria criteria = s.createCriteria(Products.class);
		Criterion crt1 = Restrictions.like("category", "B%");
		criteria.add(crt1);
		List<Products> list = criteria.list();
		for(Products p:list) {
			System.out.println(p);
		}
		
		t.commit();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoCriteria2 dc1 = new DemoCriteria2();
		dc1.showProducts();
	}

}
