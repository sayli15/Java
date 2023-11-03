package com.demo.test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
		
		
public class DemoHQL3 {
	Session s;
	public DemoHQL3() {
		Configuration cfg=new Configuration().configure();
		ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory sf=cfg.buildSessionFactory(sr);
		s=sf.openSession();
	}
		public void showproducts() {
			Transaction t=s.beginTransaction();
			Query q=s.createQuery("select prodname,category,price"
					+" from Products where price>? and category like :cat");
			q.setParameter(0,200.00);
			q.setParameter("cat", "L%");
			List plist=q.list();
			for(int i=0;i<plist.size();i++) {
				Object obj[]=(Object[])plist.get(i);
				System.out.println(obj[0]+" "+obj[1]+" "+obj[2]);
			}
			t.commit();
		}

	public static void main(String[] args) {
		DemoHQL3 dh1=new DemoHQL3();
		dh1.showproducts();
	}

}