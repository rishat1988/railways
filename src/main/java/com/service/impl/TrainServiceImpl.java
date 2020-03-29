package com.service.impl;

import com.dao.TrainDao;
import com.model.Train;
import com.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    TrainDao trainDao;

    @Override
    @Transactional
    public void add(Train train) {
        trainDao.add(train);
    }

    @Override
    @Transactional
    public void delete(Train train) {
        trainDao.delete(train);
    }

    @Override
    @Transactional
    public void update(Train train) {
        trainDao.update(train);
    }

    @Override
    @Transactional
    public Train getById(int id) {
        return trainDao.getById(id);
    }

    @Override
    @Transactional
    public List<Train> allTrains() {
        return trainDao.allTrains();
    }
}
