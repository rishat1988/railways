package com.dao;

import com.model.Station;

import java.util.List;

public interface StationDao {

    void add(Station station);

    void delete(Station station);

    void update(Station station);

    Station getById(int id);

    List<Station> allStations();

}