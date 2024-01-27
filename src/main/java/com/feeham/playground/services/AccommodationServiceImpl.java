package com.feeham.playground.services;

import com.feeham.playground.exceptions.CustomException;
import com.feeham.playground.models.Accommodation;
import com.feeham.playground.staticdata.DB;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    @Override
    public Accommodation getAccommodationById(Integer accommodationId) {
        Optional<Accommodation> result = DB.accommodations.stream()
                .filter(acc -> Objects.equals(acc.getAccommodationId(), accommodationId))
                .findFirst();
        if(result.isEmpty()){
            throw new CustomException("Accommodation with ID "+ accommodationId
                    + " was not found!", HttpStatus.NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public List<Accommodation> getAccommodationsByType(String type) {
        return DB.accommodations.stream()
                .filter(acc -> acc.getType().equalsIgnoreCase(type))
                .toList();
    }
}
