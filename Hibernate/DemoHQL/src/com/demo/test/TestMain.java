package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import com.demo.bean.Products;

public class TestMain {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf=cfg.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Products p1=new Products("Britania","Biscuit",34,100.00);
	    Products p2=new Products("Maggie","Food",54,58.90);
		Products p3=new Products("Wheel","WashPowder",45,90.54);
		Products p4=new Products("Ponds","Cream",75,64.90);
		Products p5=new Products("Lakme","Foundation",25,98.90);
		Products p6=new Products("Mac","Lipstick",14,200.90);
		Products p7=new Products("KBeauty","Concealer",65,98.90);
		Products p8=new Products("Lenskart","Specs",58,58.90);
		Products p9=new Products("Navneet","Guide",86,78.90);
		Products p10=new Products("Nike","Shoes",54,58.90);
		s.save(p1);
		s.save(p2);
		s.save(p3);
		s.save(p4);
		s.save(p5);
		s.save(p6);
		s.save(p7);
		s.save(p8);
		s.save(p9);
		s.save(p10);
		t.commit();
		s.close();
		System.out.println("Done...");		
	}

}