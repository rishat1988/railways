package com.service;

import com.model.Station;

import java.util.List;

public interface StationService {

    void add(Station station);

    void delete(Station station);

    void update(Station station);

    Station getById(int id);

    List<Station> allStations();

    Station getStationByName(String name);

}