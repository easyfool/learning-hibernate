package com.wangfengbabe.learning;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by wangfeng on 31/07/2017.
 */
public class MessageApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Message message = new Message();
    message.setText("hello world");
    session.save(message);
    List<Message> messages = session.createQuery("select m from Message m").list();
    for (Message item : messages) {
      System.out.println(item);
    }
    transaction.commit();
    session.close();
    sessionFactory.close();
  }

}
