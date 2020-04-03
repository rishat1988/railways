package com.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table (name = "train")
public class Train {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "number")
    @Min(value = 1, message = "Trains number must be more than 0")
    @NotNull(message = "Trains number must be filled in")
    private Integer number; //String???

    @Column (name = "capacity_train")
    @Min(value=1, message = "capacity must be more than 0")
    @NotNull(message = "Trains capacity must be filled in")
    private Integer capacityTrain;

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy(value = "departureTime")
    private List<Schedule> schedules;

    public Train() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacityTrain() {
        return capacityTrain;
    }

    public void setCapacityTrain(Integer capacityTrain) {
        this.capacityTrain = capacityTrain;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", number=" + number +
                ", capacityTrain=" + capacityTrain +
                '}';
    }
}