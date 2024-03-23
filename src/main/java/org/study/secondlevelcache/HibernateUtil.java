package org.study.secondlevelcache;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    public static SessionFactory sessionFactory;

    public static  SessionFactory getSessionFactory()
    { if (sessionFactory == null)
    {
        Configuration  configuration = new Configuration();

        Properties properties = new Properties();

        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatedb");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "Harsh358");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.SHOW_SQL, true);

        properties.put(Environment.USE_SECOND_LEVEL_CACHE, true); // second level cache
        properties.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory"); // second level cache

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Employee.class);


        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }




}
