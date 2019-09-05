package com.coffee.barista.dao;

import com.coffesshop.integrations.model.Coffee;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CoffeeListDao implements Dao<Coffee> {


    private static Map<Integer,Coffee> coffees = new HashMap();
    private int coffeeCounter = 2;
    static {
        fillCoffees();
    }

    private static void fillCoffees() {
        Coffee coffee1 = makeCoffee(1, "Peru", "Americano");
        Coffee coffee2 = makeCoffee(2, "Ethiopia", "Arabica");

        coffees.put(1,coffee1);
        coffees.put(2,coffee2);
        System.out.println("Coffee list initialized");
    }

    private static Coffee makeCoffee(int i, String peru, String americano) {
        Coffee coffee1 = new Coffee();
        coffee1.setCoffeeID(i);
        coffee1.setCoffeeOringin(peru);
        coffee1.setCoffeeType(americano);
        return coffee1;
    }

    @Override
    public Optional<Coffee> get(int id) {
     return Optional.of(coffees.get(id));
    }

    @Override
    public List<Coffee> getAll() {
        return new ArrayList<>(coffees.values());
    }

    @Override
    public int save(Coffee coffee) {
        coffeeCounter++;
        coffees.put(coffeeCounter,coffee);
        return coffeeCounter;
    }


    @Override
    public void update(int id, Coffee coffee) {
        coffees.put(id,coffee);
    }

    @Override
    public void delete(int id) {
        coffees.remove(id);
    }
}
