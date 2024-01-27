package com.feeham.playground.controllers;

import com.feeham.playground.models.Address;
import com.feeham.playground.models.Tourist;
import com.feeham.playground.services.TouristService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @QueryMapping
    public Tourist getTouristById(@Argument Integer touristId){
        return touristService.getTouristsById(touristId);
    }

    @QueryMapping
    public Tourist getTouristByName(@Argument String name){
        return touristService.getTouristsByName(name);
    }

    @SchemaMapping
    public Address address(Tourist tourist){
        return null;
    }
}
