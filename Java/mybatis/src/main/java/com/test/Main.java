package com.test;


import com.hackerspace.dao.Studio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.sql.Timestamp;
import java.util.Map;

public class Main {


    public static void main(final String[] args) throws Exception {

        MDC.put("name","test");

        Logger  logger = LoggerFactory.getLogger(Studio.class);

        logger.info("important");

//        Configuration configuration = new Configuration();
//
//        configuration.configure("hibernate.cfg.xml");
//
//
//        configuration.addAnnotatedClass(Studio.class);
//
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//
//        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//        Session session = sessionFactory.openSession();

        Configuration configuration = new Configuration();
        //configuration.configure();
        /**
         * 加载hibernate的配置文件
         */
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();


        Transaction tx = session.beginTransaction();




        for (int i = 1; i < 3; i++) {
            System.out.println(i);

            Studio studio = new Studio();



            studio.setSdNumber(1);
            studio.setSdOpen(true);

            System.out.println(session.save(studio));


        }

        System.out.println("Successful");

        tx.commit();

        session.close();
    }
}