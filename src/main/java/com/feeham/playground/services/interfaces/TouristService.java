package com.feeham.playground.services.interfaces;

import com.feeham.playground.models.Tourist;

public interface TouristService {
    public Tourist getTouristsById(Integer touristId);
    public Tourist getTouristsByName(String name);
}
