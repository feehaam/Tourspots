package com.feeham.playground.services;

import com.feeham.playground.exceptions.CustomException;
import com.feeham.playground.models.TourSpot;
import com.feeham.playground.staticdata.DB;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TourSpotServiceImpl implements TourSpotService {
    @Override
    public TourSpot getTourSpotById(Integer tourSpotId) {
        Optional<TourSpot> result = DB.tourSpots.stream()
                .filter(tourSpot -> Objects.equals(tourSpot.getTourSpotId(), tourSpotId))
                .findFirst();
        if(result.isEmpty()){
            throw new CustomException("Tour spot with ID "+ tourSpotId
                    + " was not found!", HttpStatus.NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public List<TourSpot> getTourSpotsByRating(Integer min, Integer max) {
        return DB.tourSpots.stream()
                .filter(tourSpot -> tourSpot.getAverageRating() >= min && tourSpot.getAverageRating() <= max)
                .toList();
    }
}
