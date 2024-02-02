package com.feeham.playground.services.interfaces;

import com.feeham.playground.models.Accommodation;

import java.util.List;
import java.util.Map;

public interface AccommodationService extends CommonService {
    Accommodation getById(Integer accommodationId);
    List<Accommodation> getByType(String type);
    void create(Map<String, Object> mappedObject);
    void update(Integer accId, Map<String, Object> mappedObject);
    void delete(Integer accId);
}
