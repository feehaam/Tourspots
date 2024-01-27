package com.feeham.playground.services;

import com.feeham.playground.models.Accommodation;

public interface AccommodationService {
    Accommodation getAccommodationById(Integer accommodationId);
    Accommodation getAccommodationsByType(String type);
}
