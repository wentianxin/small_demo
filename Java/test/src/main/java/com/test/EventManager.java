package com.test;

/**
 * Created by tianx on 2016/2/27.
 */
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.*;



public class EventManager {

    public static void main(String[] args) {
        EventEntity eventEntity = new EventEntity();

        eventEntity.setTitle("111");
        eventEntity.setDate(new Timestamp(11));

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();


        session.beginTransaction();

        session.save(eventEntity);

        session.getTransaction().commit();
    }



}