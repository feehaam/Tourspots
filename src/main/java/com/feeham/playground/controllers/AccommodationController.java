package com.feeham.playground.controllers;

import com.feeham.playground.models.Accommodation;
import com.feeham.playground.services.AccommodationService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @QueryMapping
    public Accommodation getAccommodationById(@Argument Integer accommodationId){
        return accommodationService.getAccommodationById(accommodationId);
    }

    @QueryMapping
    public List<Accommodation> getAccommodationsByType(@Argument String type){
        return accommodationService.getAccommodationsByType(type);
    }
}
