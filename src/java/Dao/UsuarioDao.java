/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import modelo.HibernateSession;
import modelo.UsuarioInterfaceDAO;
import modelo.Usuario;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author USUARIO
 */
public class UsuarioDao implements UsuarioInterfaceDAO {

    @Override
    public Usuario selectById(String UsuarioId) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Usuario usuario = (Usuario) session.get(Usuario.class, UsuarioId);
        session.close();
        return usuario;
    }

    @Override
    public List<Usuario> selectAll() {
        SessionFactory sessionFactory=HibernateSession.getSessionFactory();
        Session session=sessionFactory.openSession();
        List<Usuario> usuarios=session.createCriteria(Usuario.class).list();
        session.close();
        return  usuarios;
    }

    @Override
    public void insert(Usuario usuario) {
        System.out.println("usuario " + usuario.getUsuario());
        SessionFactory sessionFactory=HibernateSession.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        String id=(String) session.save(usuario);
        usuario.setUsuario(id);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Usuario usuario) {
        SessionFactory sessionFactory=HibernateSession.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.merge(usuario);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Usuario usuario) {
        SessionFactory sessionFactory=HibernateSession.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();
        session.close();
    }

}
