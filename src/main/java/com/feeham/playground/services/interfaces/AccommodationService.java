package com.feeham.playground.services.interfaces;

import com.feeham.playground.models.Accommodation;

import java.util.List;
import java.util.Map;

public interface AccommodationService extends CommonService {
    Accommodation getById(Integer accommodationId);
    List<Accommodation> getByType(String type);
    Accommodation create(Map<String, Object> input);
    Accommodation update(Integer accommodationId, Map<String, Object> input);
    Boolean delete(Integer accommodationId);
}
