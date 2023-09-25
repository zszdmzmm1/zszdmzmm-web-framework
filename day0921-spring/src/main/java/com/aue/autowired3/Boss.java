package com.aue.autowired3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
    Assistant assistant;
    Car car;
    Plane plane;

    @Autowired
    public Boss(Car car) {
        this.car = car;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    @Autowired
    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public Plane getPlane() {
        return plane;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public void setPlane(@Autowired Plane plane) {
        this.plane = plane;
    }
}
