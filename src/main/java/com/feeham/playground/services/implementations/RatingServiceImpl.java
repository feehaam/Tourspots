package com.feeham.playground.services.implementations;

import com.feeham.playground.exceptions.CustomException;
import com.feeham.playground.models.Rating;
import com.feeham.playground.models.Tourist;
import com.feeham.playground.repositories.RatingRepository;
import com.feeham.playground.services.interfaces.RatingService;
import com.feeham.playground.services.interfaces.TouristService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final TouristService touristService;

    @Override
    public Rating create(Map<String, Object> input) {
        Rating rating = mapToObject(input, Rating.class);
        rating.setRatingId(0);
        rating.setCreated(LocalDateTime.now());
        Tourist user = touristService.getTouristsById(getUserId());
        ratingRepository.save(rating);
        return rating;
    }

    @Override
    public Rating update(Integer ratingId, Map<String, Object> input) {
        Rating ratingUpdated = mapToObject(input, Rating.class);
        Rating rating = getRatingAndCheckAccess(ratingId);
        rating.setUpdated(LocalDateTime.now());
        rating.setRate(ratingUpdated.getRate());
        rating.setComment(ratingUpdated.getComment());
        ratingRepository.save(rating);
        return rating;
    }

    @Override
    public Boolean delete(Integer ratingId) {
        Rating rating = getRatingAndCheckAccess(ratingId);
        ratingRepository.delete(rating);
        return true;
    }

    private Rating getRatingAndCheckAccess(Integer ratingId){
        Optional<Rating> ratingOp = ratingRepository.findById(ratingId);
        if(ratingOp.isEmpty()) {
            throw new CustomException("Rating is not found.", HttpStatus.NOT_FOUND);
        }
        Rating rating = ratingOp.get();
        if(!Objects.equals(rating.getRatedBy().getTouristId(), getUserId())){
            throw new CustomException("Access denied! Only rating owner edit or delete.", HttpStatus.BAD_REQUEST);
        }
        return rating;
    }
}
