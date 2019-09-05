package com.coffeeshop.client.coffeeshopclient.models;

public class MakeCoffeeResponse {

    String userName;
    Boolean coffeePrepared;
    String amountWithCurrency;

    public MakeCoffeeResponse(String userName, Boolean coffeePrepared, String amountWithCurrency) {
        this.userName = userName;
        this.coffeePrepared = coffeePrepared;
        this.amountWithCurrency = amountWithCurrency;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getCoffeePrepared() {
        return coffeePrepared;
    }

    public void setCoffeePrepared(Boolean coffeePrepared) {
        this.coffeePrepared = coffeePrepared;
    }

    public String getAmountWithCurrency() {
        return amountWithCurrency;
    }

    public void setAmountWithCurrency(String amountWithCurrency) {
        this.amountWithCurrency = amountWithCurrency;
    }
}
