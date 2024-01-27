package com.feeham.playground.services;

import com.feeham.playground.models.Accommodation;

import java.util.List;

public interface AccommodationService {
    Accommodation getAccommodationById(Integer accommodationId);
    List<Accommodation> getAccommodationsByType(String type);
}
