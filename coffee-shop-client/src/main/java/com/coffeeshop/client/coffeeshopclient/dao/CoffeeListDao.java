package com.coffeeshop.client.coffeeshopclient.dao;

import com.coffeeshop.client.coffeeshopclient.models.Coffee;

import java.util.List;
import java.util.Optional;

public class CoffeeDao implements Dao<Coffee> {

    @Override
    public Optional<Coffee> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Coffee> getAll() {
        return null;
    }

    @Override
    public void save(Coffee coffee) {

    }

    @Override
    public void update(Coffee coffee, String[] params) {

    }

    @Override
    public void delete(Coffee coffee) {

    }
}
