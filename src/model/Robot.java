package model;

public class Robot {
    private String name;
    private String type;
    private String serialNumber;
    private Account supervisor;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Account getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Account supervisor) {
        this.supervisor = supervisor;
    }

    public Robot() {
    }

    public Robot(String name, String type, String serialNumber, Account supervisor) {
        this.name = name;
        this.type = type;
        this.serialNumber = serialNumber;
        this.supervisor = supervisor;
    }
}
