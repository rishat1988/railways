package com.service;

import com.model.Train;

import java.util.List;

public interface TrainService {


    void add(Train train);

    void delete(Train train);

    void update(Train train);

    Train getById(int id);

    List<Train> allTrains();

}
