package com.feeham.playground.services.implementations;

import com.feeham.playground.exceptions.CustomException;
import com.feeham.playground.models.Tourist;
import com.feeham.playground.services.interfaces.TouristService;
import com.feeham.playground.staticdata.DB;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService {
    @Override
    public Tourist getTouristsById(Integer touristId) {
        Optional<Tourist> result = DB.tourists.stream()
                .filter(tourist -> Objects.equals(tourist.getTouristId(), touristId))
                .findFirst();
        if(result.isEmpty()){
            throw new CustomException("Tourist with ID "+ touristId + " was not found!", HttpStatus.NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public Tourist getTouristsByName(String name) {
        Optional<Tourist> result = DB.tourists.stream()
                .filter(tourist ->
                        tourist.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
                        tourist.getLastName().toLowerCase().contains(name.toLowerCase()))
                .findFirst();
        if(result.isEmpty()){
            throw new CustomException("Tourist with name "+ name + " was not found!", HttpStatus.NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public Tourist create(Map<String, Object> input) {
        Tourist tourist = mapToObject(input, Tourist.class);
        return tourist;
    }

    @Override
    public Tourist update(Integer touristId, Map<String, Object> input) {
        return null;
    }

    @Override
    public Boolean delete(Integer touristId) {
        return null;
    }
}
