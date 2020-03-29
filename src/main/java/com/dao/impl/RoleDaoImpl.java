package com.dao.impl;

import com.dao.RoleDao;
import com.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Role getByName(String role) {
        Session session = sessionFactory.getCurrentSession();
        Query <Role> query = session.createQuery("from Role where name = :role" , Role.class);
        query.setParameter("role" , role);
        return  query.list().stream().findAny().orElse(null);

    }
}