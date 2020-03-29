package com.dao;

import com.model.Station;
import com.model.Train;

import java.util.List;

public interface TrainDao {

    void add(Train train);

    void delete(Train train);

    void update(Train train);

    Train  getById(int id);

    List<Train> allTrains();

    Train getByNumber(Integer number);

}