package com.coffesshop.integrations.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;

@ApiModel(description = "All about coffee")
public class Coffee {

    int coffeeID;

    @Min(4)
    @ApiModelProperty(notes = "Coffee type should have at least 4 characters")
    String coffeeType;

    @Min(3)
    @ApiModelProperty(notes = "Origin should have at least 3 characters")
    String coffeeOringin;

    String port;

    public int getCoffeeID() {
        return coffeeID;
    }

    public void setCoffeeID(int coffeeID) {
        this.coffeeID = coffeeID;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public String getCoffeeOringin() {
        return coffeeOringin;
    }

    public void setCoffeeOringin(String coffeeOringin) {
        this.coffeeOringin = coffeeOringin;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
