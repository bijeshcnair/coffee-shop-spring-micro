package com.coffeeshop.client.coffeeshopclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;


public class CompanyPaymentData {

    @NonNull
    @JsonProperty
    public String paymentCondition;

    @Email
    public String invoiceEmailId;

}
