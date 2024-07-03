package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private String pseudo;
    private String email;
    private String password;
    private String phone;
    private String company;

    private List<Activity> activities = new ArrayList<>();
    private List<User> followers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public User() {
    }

    public User(String name, String surname, String pseudo, String email, String password, String phone, String company) {
        this.name = name;
        this.surname = surname;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.company = company;
    }
}
