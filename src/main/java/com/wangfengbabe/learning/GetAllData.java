package com.wangfengbabe.learning;

/**
 * Created by wangfeng on 27/07/2017.
 */

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class GetAllData {

  public static void main(String[] args) throws Exception {

    SessionFactory sessFact = HibernateUtil.getSessionFactory();
    Session session = sessFact.getCurrentSession();
    org.hibernate.Transaction tr = session.beginTransaction();

    CriteriaQuery cq = session.getCriteriaBuilder().createQuery(Employee.class);
    cq.from(Employee.class);
    List<Employee> employeeList = session.createQuery(cq).getResultList();

    for (Employee employee : employeeList) {
      System.out.println("ID: " + employee.getId());
      System.out.println("Name: " + employee.getEmpName());
    }

    tr.commit();
    System.out.println("Data printed");
    sessFact.close();
  }
}
