package org.study;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class App_HB {

    public static void main(String[] args) {

         SessionFactory factory = HibernateUtil.getSessionFactory();

        //System.out.println(factory);
        Emp emp = new Emp();
        emp.setEmpName("Harshad");
        emp.setEmpAddress("Pune");
        emp.setEmpSalary(140000.00);

        Emp emp1 = new Emp();
        emp1.setEmpName("Akash");
        emp1.setEmpAddress("Chanda");
        emp1.setEmpSalary(28000.00);

       Session session =  factory.openSession();
       Transaction tx = session.beginTransaction();

       /*session.save(emp);   // insert or save data into the table
       session.save(emp1);
       tx.commit();*/

        /*Query q = session.createQuery("from Emp");  // get the all data from emp table
           List<Emp> list = q.list();

           for (Emp e : list){
               System.out.println(e);
           }*/

       // System.out.println(session.get(Emp.class, 1)); // get the data from empId = 1

        //System.out.println("Register Successfully");

        /*Query q =  session.createQuery("from Emp where empId= 3 and empAddress='Pune'"); // get data from multiple static condition
        System.out.println(q.uniqueResult());*/

        Query q1 =  session.createQuery("from Emp where empId =:id and empAddress =:ad");  // get data from multiple setting dynamic condition
        q1.setParameter("id",3);
        q1.setParameter("ad","Pune");
        System.out.println(q1.uniqueResult());

       session.close();
       factory.close();
    }
}
