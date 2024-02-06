package com.feeham.playground.services.interfaces;

import com.feeham.playground.models.Tourist;

import java.util.Map;

public interface TouristService extends CommonService{
    public Tourist getTouristsById(Integer touristId);
    public Tourist getTouristsByName(String name);
    public Tourist create(Map<String, Object> input);
    public Tourist update(Integer touristId, Map<String, Object> input);
    public Boolean delete(Integer touristId);
}
