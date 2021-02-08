package com.norofff.Task4.models;

public class FavGenre {

    private String customerId;
    private String firstName;
    private String lastName;
    private String genre;
    private Double total;

    public FavGenre(String customerId, String firstName, String lastName, String genre, Double total) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
