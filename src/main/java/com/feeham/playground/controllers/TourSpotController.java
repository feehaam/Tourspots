package com.feeham.playground.controllers;

import com.feeham.playground.models.TourSpot;
import com.feeham.playground.services.TourSpotService;
import com.feeham.playground.services.TouristService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TourSpotController {

    private final TourSpotService tourSpotService;

    public TourSpotController(TourSpotService tourSpotService) {
        this.tourSpotService = tourSpotService;
    }

    @QueryMapping
    public TourSpot getTourSpotById(@Argument Integer tourSpotId){
        return tourSpotService.getTourSpotById(tourSpotId);
    }

    @QueryMapping
    public List<TourSpot> getTourSpotsByRating(@Argument Integer minRating, @Argument Integer maxRating){
        return tourSpotService.getTourSpotsByRating(minRating, maxRating);
    }
}
