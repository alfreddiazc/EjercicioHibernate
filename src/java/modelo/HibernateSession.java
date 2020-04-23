/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author USUARIO
 */
public class HibernateSession {
     private static Session session;
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        Configuration configuration =new Configuration();
        configuration.configure();
        
        SessionFactory sessionFactory=configuration.buildSessionFactory(/*serviceRegistry*/);
        return sessionFactory;
    }
    
    /*     static 
    { 
        try 
        { 
            sessionFactory = new Configuration().configure().buildSessionFactory(); 
        } catch (HibernateException he) 
        { 
           System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
           throw new ExceptionInInitializerError(he); 
        } 
    }  
    */
    public static SessionFactory getSessionFactory() 
    { 
        return sessionFactory; 
    }
    public static Session getSession(){
        if(null==session){
            session=sessionFactory.openSession();
        }
        return session;
    }
    
   
    
    
    
}
