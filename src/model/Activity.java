package model;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private List<Interest> interests = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
