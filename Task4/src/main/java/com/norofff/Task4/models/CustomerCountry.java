package com.norofff.Task4.models;

public class CustomerCountry {
    private String countryName;

    public CustomerCountry(String countryName, int invoiceCount) {
        this.countryName = countryName;
        this.invoiceCount = invoiceCount;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getInvoiceCount() {
        return invoiceCount;
    }

    public void setInvoiceCount(int invoiceCount) {
        this.invoiceCount = invoiceCount;
    }

    private int invoiceCount;

}

