package com.dao.impl;
import com.dao.ScheduleDao;
import com.model.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public   void add(Schedule schedule){
        Session session = sessionFactory.getCurrentSession();
        session.persist(schedule);

    }
    @Override
    public void delete(Schedule schedule){
        Session session = sessionFactory.getCurrentSession();
        session.delete(schedule);
    }
    @Override
    public  void update(Schedule schedule){
        Session session = sessionFactory.getCurrentSession();
        session.update(schedule);}

    @Override
    public  Schedule getById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Schedule.class , id);}

    @Override
    @SuppressWarnings("unchecked")
    public List<Schedule> allSchedules() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Schedule> criteriaQuery = criteriaBuilder.createQuery(Schedule.class);
        Root<Schedule> root = criteriaQuery.from(Schedule.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        return  query.getResultList();
    }

    @Override
    public int getStationId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select stationId from Schedule where id=:id");
        query.setParameter("id", id);
        return  (Integer) query.getSingleResult();
    }

    @Override
    public int getTrainNumber(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select trainNumber from Schedule where id=:id");
        query.setParameter("id", id);
        return  (Integer) query.getSingleResult();
    }

    @Override
    public LocalDateTime getArrivalTime(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select arrivalTime from Schedule where id=:id");
        query.setParameter("id", id);
        return (LocalDateTime) query.getSingleResult();
    }

    @Override
    public LocalDateTime getDepartureTime(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select departureTime from Schedule where id=:id");
        query.setParameter("id", id);
        return (LocalDateTime) query.getSingleResult();
    }

    @Override
    public List<Integer> getAllTrainsNumbers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select id from Train");
        List <Integer> trainNumbers = query.getResultList();
        return  trainNumbers;
    }

    @Override
    public List<String> getAllStations() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select  name from Station ");
        List <String> stations = query.getResultList();
        return stations;
    }
}