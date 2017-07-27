package com.wangfengbabe.learning;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    // 配置方法一
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//	    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

//		配置方法二
    Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sessionFactory = cfg.buildSessionFactory();

    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    User user = new User();
    user.setUsername("root");
    user.setPassword("123456");
    session.save(user);
    transaction.commit();
    //9. 关闭会话
    session.close();
    //10. 关闭会话工厂
    sessionFactory.close();

  }
}

