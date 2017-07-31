package com.wangfengbabe.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by wangfeng on 27/07/2017.
 */
public class CreateData {

  public static void main(String[] args) {
    SessionFactory sessFact = HibernateUtil.getSessionFactory();
    Session session = sessFact.getCurrentSession();
    org.hibernate.Transaction tr = session.beginTransaction();
    Employee emp = new Employee();
    emp.setEmpName("Deepak Kumar");
    emp.setEmpMobileNos("000000");
    emp.setEmpAddress("Delhi - India");
    session.save(emp);
    tr.commit();
    System.out.println("Successfully inserted");
    sessFact.close();
  }

}
