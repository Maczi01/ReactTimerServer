package com.example.reacttimer;

public class TimeboxMapper {

    static TimeboxTo toTimeboxTo(Timebox timeboxEntity) {
        TimeboxTo timeboxTo = new TimeboxTo();
        timeboxTo.setId(timeboxEntity.getId());
        timeboxTo.setTitle(timeboxEntity.getTitle());
        timeboxTo.setTotalTimeInMinutes(timeboxEntity.getTotalTimeInMinutes());
        return timeboxTo;
    }

    static Timebox toTimeboxEntity(TimeboxTo timeboxTo) {
        Timebox timeboxEntity = new Timebox();
        timeboxEntity.setId(timeboxTo.getId());
        timeboxEntity.setTitle(timeboxTo.getTitle());
        timeboxEntity.setTotalTimeInMinutes(timeboxTo.getTotalTimeInMinutes());
        return timeboxEntity;
    }
}
