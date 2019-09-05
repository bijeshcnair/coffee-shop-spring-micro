package com.coffeeshop.client.coffeeshopclient.configurations;


import org.springframework.stereotype.Component;

@Component
@org.springframework.boot.context.properties.ConfigurationProperties("coffee-shop")
public class ConfigurationProperties {

    private String max;
    private String open;
    private String close;
    private String currency;
    private String isntance;

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIsntance() {
        return isntance;
    }

    public void setIsntance(String isntance) {
        this.isntance = isntance;
    }
}
