package com.feeham.playground.services.interfaces;

import com.feeham.playground.models.TourSpot;

import java.util.List;

public interface TourSpotService {
    TourSpot getTourSpotById(Integer tourSpotId);
    List<TourSpot> getTourSpotsByRating(Integer min, Integer max);
}
