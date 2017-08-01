package com.wangfengbabe.learning;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by wangfeng on 01/08/2017.
 */
public class MessageTest {

  @Test
  public void testSaveMessage() {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Message message = new Message();
    message.setText("hello world");
    session.save(message);
    List<Message> resultMessages = session.createQuery("select  m from Message m ").list();
    assertThat(resultMessages, notNullValue());
    assertThat(resultMessages.size(), greaterThan(0));
    assertThat(resultMessages.get(0).getText(), equalTo("hello world"));
    transaction.commit();
    session.close();
    sessionFactory.close();
  }

  @Test
  public void testPersistMessage() {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Message message = new Message();
    message.setText("hello world");
    session.persist(message);
    List<Message> resultMessages = session.createQuery("select  m from Message m ").list();
    assertThat(resultMessages, notNullValue());
    assertThat(resultMessages.size(), greaterThan(0));
    assertThat(resultMessages.get(0).getText(), equalTo("hello world"));
    transaction.commit();
    session.close();
    sessionFactory.close();
  }

  @Test
  public void testUpdateMessage() {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Message message = (Message) session.createQuery("select m from Message m").list().get(0);
    message.setText("hello world again");
    //session.save(message);
    List<Message> resultMessages = session.createQuery("select  m from Message m ").list();
    assertThat(resultMessages, notNullValue());
    assertThat(resultMessages.size(), greaterThan(0));
    assertThat(resultMessages.get(0).getText(), equalTo("hello world again"));
    transaction.commit();
    session.close();
    sessionFactory.close();
  }


}