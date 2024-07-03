package model;

import enumeration.Status;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private Status status;
    private List<Interest> interests = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public Activity() {
    }
}
