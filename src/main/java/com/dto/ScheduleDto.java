package com.dto;

import java.time.LocalDateTime;

public class ScheduleDto {


        private int id;

        private int trainNumber;

        private String stationName;

        private LocalDateTime arrivalTime;

        private LocalDateTime departureTime;

        private String arrivalTimeFormat;

        private String departureTimeFormat;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTrainNumber(int trainNumber) {
            return this.trainNumber;
        }

        public void setTrainNumber(int trainNumber) {
            this.trainNumber = trainNumber;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public LocalDateTime getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(LocalDateTime arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public LocalDateTime getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(LocalDateTime departureTime) {
            this.departureTime = departureTime;
        }

        public String getArrivalTimeFormat() {
            return arrivalTimeFormat;
        }

        public void setArrivalTimeFormat(String arrivalTimeFormat) {
            this.arrivalTimeFormat = arrivalTimeFormat;
        }

        public String getDepartureTimeFormat() {
            return departureTimeFormat;
        }

        public void setDepartureTimeFormat(String departureTimeFormat) {
            this.departureTimeFormat = departureTimeFormat;
        }
    }

