package com.dao.impl;


import com.dao.StationDao;
import com.model.Schedule;
import com.model.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class StationDaoImpl implements StationDao {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void add(Station station){
        Session session = sessionFactory.getCurrentSession();
        session.persist(station);

    }
    @Override
    public void delete(Station station){
        Session session = sessionFactory.getCurrentSession();
        session.delete(station);
    }
    @Override
    public  void update(Station station){
        Session session = sessionFactory.getCurrentSession();
        session.update(station);
    }
    @Override
    public  Station getById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Station.class, id);
    }
    @Override
    @SuppressWarnings("unchecked")
    public   List<Station> allStations(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Station> criteriaQuery = criteriaBuilder.createQuery(Station.class);
        Root<Station> root = criteriaQuery.from(Station.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        return  query.getResultList();
    }
}