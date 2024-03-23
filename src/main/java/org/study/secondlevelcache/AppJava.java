package org.study.secondlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppJava {

    public static void main(String[] args) {

         /*SessionFactory factory = HibernateUtil.getSessionFactory();

        //System.out.println(factory);
        Employee emp = new Employee();
        emp.setEmpName("Harshad");
        emp.setEmpAddress("Pune");
        emp.setEmpSalary(140000.00);

        Employee emp1 = new Employee();
        emp1.setEmpName("Akash");
        emp1.setEmpAddress("Chanda");
        emp1.setEmpSalary(28000.00);

       Session session =  factory.openSession();
       Transaction tx = session.beginTransaction();

       session.save(emp);   // insert or save data into the table
       session.save(emp1);
       tx.commit();
       session.close();
       factory.close();*/

        /*Query q = session.createQuery("from Emp");  // get the all data from emp table
           List<Emp> list = q.list();

           for (Emp e : list){
               System.out.println(e);
           }*/

       // System.out.println(session.get(Emp.class, 1)); // get the data from empId = 1

        //System.out.println("Register Successfully");

        /*Query q =  session.createQuery("from Emp where empId= 3 and empAddress='Pune'"); // get data from multiple static condition
        System.out.println(q.uniqueResult());*/

        /*Query q1 =  session.createQuery("from Emp where empId =:id and empAddress =:ad");  // get data from multiple setting dynamic condition
        q1.setParameter("id",3);
        q1.setParameter("ad","Pune");
        System.out.println(q1.uniqueResult());*/


        SessionFactory factory = HibernateUtil.getSessionFactory();  //second level cache
        Session session = factory.openSession();
        Employee empD = session.get(Employee.class, 2);
        System.out.println(empD);
       session.close();

        Session session2 = factory.openSession();
        Employee empD1 = session2.get(Employee.class, 2);
        System.out.println(empD1);
        session2.close();
       factory.close();
    }
}
