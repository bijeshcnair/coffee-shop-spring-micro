package com.coffee.barista.controllers;


import com.coffee.barista.dao.CoffeeListDao;
import com.coffesshop.integrations.model.Coffee;
import com.coffesshop.integrations.Barista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeController implements Barista {



    @Autowired
    CoffeeListDao coffeeListDao;
    @Autowired
    Environment environment;


    @Override
    public boolean prepareCoffee(String type,int size) {

        try {
            Thread.sleep(200);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Coffee prepared by barista . Type : "+type +" and Size : "+size);
        return true;
    }

    @PostMapping("coffees/addCoffee")
    public int addCoffee(Coffee coffee)
    {
        return coffeeListDao.save(coffee);
    }

    @PutMapping("/updateCoffee/{key}")
    public void updateCoffee(@PathVariable (name = "key") int key,Coffee coffee){
        coffeeListDao.update(key,coffee);
    }

    /**
     * Hateos compatibile
     * @param id
     * @return
     */

    @Override
    public Resource<Coffee> getCoffee(@PathVariable int id){
        Coffee coffee = coffeeListDao.get(id).get();

        String port = environment.getProperty("local.server.port");
        coffee.setPort(port);
        Link selfLink = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder
                        .methodOn(
                                this.getClass())
                        .getCoffee(id))
                .withSelfRel();

        Resource<Coffee> coffeesResource = new Resource<Coffee>(coffee);
        ControllerLinkBuilder controllerLinkBuilder = ControllerLinkBuilder.
                linkTo(ControllerLinkBuilder.methodOn
                        (this.getClass()).getAllCoffees());
        coffeesResource.add(controllerLinkBuilder.withRel("all-coffee"));
        coffeesResource.add(selfLink);
        return coffeesResource;

    }


    @Override
    public List<Coffee> getAllCoffees() {

        System.out.println("Reading all coffees");
        return coffeeListDao.getAll();
    }

}
