package com.coffee.barista.controllers;


import com.coffee.barista.dao.CoffeeListDao;
import com.coffesshop.integrations.model.Coffee;
import com.coffesshop.integrations.Barista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CoffeeController {

    Logger logger  = LoggerFactory.getLogger(this.getClass());


    @Autowired
    CoffeeListDao coffeeListDao;
    @Autowired
    Environment environment;


    @RequestMapping("/barista-services/prepare-coffee")
    public boolean prepareCoffee(String type,int size) {

        try {
            Thread.sleep(200);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
            return false;
        }
        logger.info("Coffee prepared by barista Type {}, Size {}",type,size);
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
    @GetMapping(value = "/coffees/{id}",produces = "application/hal+json")
    public Resource<Coffee> getCoffee(@PathVariable int id){
        logger.info("Getting coffee with ID {}",id);
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


    @GetMapping("/coffees")
    public List<Coffee> getAllCoffees() {

        logger.info("Reading all coffees");
        return coffeeListDao.getAll();
    }


    @GetMapping("/status")
    public String getStatus(){
        return "up";
    }
}
