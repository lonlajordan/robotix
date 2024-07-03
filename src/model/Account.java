package model;

import enumeration.Profil;

import java.util.ArrayList;
import java.util.List;

public class Account {
    // Common properties
    private Long id;
    private Profil profil;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String company;

    // Only for users
    private String surname;
    private String pseudo;
    private List<Activity> activities = new ArrayList<>();
    private List<Account> followers = new ArrayList<>();

    // Only for providers
    private String address;
    private Long constructionCapacity;
    private List<Component> components = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Account> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Account> followers) {
        this.followers = followers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getConstructionCapacity() {
        return constructionCapacity;
    }

    public void setConstructionCapacity(Long constructionCapacity) {
        this.constructionCapacity = constructionCapacity;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Account() {
    }

    public Account(Long id, Profil profil, String name, String surname, String pseudo, String email, String password, String phone, String company) {
        this.id = id;
        this.profil = profil;
        this.name = name;
        this.surname = surname;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.company = company;
    }

    public Account(Long id, Profil profil, String name, String email, String password, String phone, String address, String company, long constructionCapacity) {
        this.id = id;
        this.profil = profil;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.company = company;
        this.constructionCapacity = constructionCapacity;
    }
}
