package com.wangfengbabe.learning;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by wangfeng on 01/08/2017.
 */
public class JPAApp {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hbunit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    Message message = new Message();
    message.setText("hello world 2");
    entityManager.persist(message);
    transaction.commit();
  }

}
