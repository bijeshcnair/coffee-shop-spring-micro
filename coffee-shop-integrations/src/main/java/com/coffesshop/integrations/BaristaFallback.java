package com.coffesshop.integrations;

import com.coffesshop.integrations.model.Coffee;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BaristaFallback implements Barista {

    @Override
    public boolean prepareCoffee(String type, int size) {
        System.out.println("Fall back. Failed to prepare the coffee ");
        return false;
    }

    @Override
    public List<Coffee> getAllCoffees() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Resource<Coffee> getCoffee(int id) {
        return null;
    }
}
