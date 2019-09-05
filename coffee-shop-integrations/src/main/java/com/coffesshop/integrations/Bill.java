package com.coffesshop.integrations;

public class Bill {
    String userName;
    double amount;
    String currency;


    public Bill(String userName, double amount, String currency) {
        this.userName = userName;
        this.amount = amount;
        this.currency = currency;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
