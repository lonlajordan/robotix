package model;

public class Component {
    private String name;
    private String type;
    private String description;
    private double price;

    private Provider provider;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Component() {
    }

    public Component(String name, String type, String description, double price, Provider provider) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
        this.provider = provider;
    }
}
