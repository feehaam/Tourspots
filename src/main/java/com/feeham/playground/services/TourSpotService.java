package com.feeham.playground.services;

import com.feeham.playground.models.TourSpot;

public interface TourSpotService {
    TourSpot getTourSpotById(Integer tourSpotId);
    TourSpot getTourSpotsByRating(Double min, Double max);
}
