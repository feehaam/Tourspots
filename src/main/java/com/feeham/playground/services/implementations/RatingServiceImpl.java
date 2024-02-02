package com.feeham.playground.services.implementations;

import com.feeham.playground.models.Rating;
import com.feeham.playground.services.interfaces.RatingService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RatingServiceImpl implements RatingService {
    @Override
    public Rating create(Map<String, Object> input) {
        return null;
    }

    @Override
    public Rating update(Integer ratingId, Map<String, Object> input) {
        return null;
    }

    @Override
    public Boolean delete(Integer ratingId) {
        return null;
    }
}
