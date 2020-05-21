package com.example.reacttimer;

public class TimeboxTo {

    private Long id;
    private String title;
    private Integer totalTimeInMinutes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalTimeInMinutes() {
        return totalTimeInMinutes;
    }

    public void setTotalTimeInMinutes(Integer totalTimeInMinutes) {
        this.totalTimeInMinutes = totalTimeInMinutes;
    }
}
