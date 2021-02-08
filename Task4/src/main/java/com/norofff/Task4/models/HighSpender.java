package com.norofff.Task4.models;

public class HighSpender {

    private String customerId;
    private String firstName;
    private String lastName;
    private double total;

    public HighSpender(String customerId, String firstName, String lastName, double total) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.total = total;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
