package com.coffee.barista.dao;

import com.coffesshop.integrations.model.Coffee;


import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(int id);

    List<T> getAll();

    int save(T t);

    void update(int id, Coffee coffee);

    void delete(int id);
}