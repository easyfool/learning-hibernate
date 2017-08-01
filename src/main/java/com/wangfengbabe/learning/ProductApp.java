package com.wangfengbabe.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by wangfeng on 01/08/2017.
 */
public class ProductApp {

  public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sessionFactory = cfg.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Product product = new Product();
    product.setName("product1");
    session.persist(product);
    transaction.commit();
    sessionFactory.close();
  }

}
