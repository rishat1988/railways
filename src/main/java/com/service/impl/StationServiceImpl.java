package com.service.impl;


import com.dao.StationDao;
import com.model.Station;
import com.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StationServiceImpl implements StationService {

    @Autowired
    StationDao stationDao;

    @Override
    @Transactional
    public void add(Station station){
        stationDao.add(station);
    }

    @Override
    @Transactional
    public void delete(Station station){
        stationDao.delete(station);
    }

    @Override
//    @Transactional (propagation = Propagation.REQUIRES_NEW,
//            rollbackFor = Exception.class,
//            timeout = 20)
    @Transactional
    public  void update(Station station){
        stationDao.update(station);
    }

    @Override
    @Transactional
    public   Station getById(int id){
        return stationDao.getById(id);
    }

    @Override
    @Transactional
    public  List<Station> allStations()
    {
        return stationDao.allStations();
    }

    @Override
    public Station getStationByName(String name) {
        return  stationDao.getStationByName(name);
    }
}