package com.feeham.playground.services.implementations;

import com.feeham.playground.exceptions.CustomException;
import com.feeham.playground.models.Accommodation;
import com.feeham.playground.models.Address;
import com.feeham.playground.models.Facilities;
import com.feeham.playground.models.GeoLocation;
import com.feeham.playground.services.interfaces.AccommodationService;
import com.feeham.playground.staticdata.DB;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    @Override
    public Accommodation getById(Integer accommodationId) {
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
    public List<Accommodation> getByType(String type) {
        return DB.accommodations.stream()
                .filter(acc -> acc.getType().equalsIgnoreCase(type))
                .toList();
    }

    private Accommodation getObjectFromRequestMap(Map<String, Object> mappedObject){
        return Accommodation.builder()
                .name(read(mappedObject, ACCOMMODATION_NAME, String.class, ERROR_ACCOMMODATION_NAME_MISSING))
                .type(read(mappedObject, ACCOMMODATION_TYPE, String.class, ERROR_ACCOMMODATION_TYPE_MISSING))
                .address(read(mappedObject, ACCOMMODATION_ADDRESS, Address.class, ERROR_ACCOMMODATION_ADDRESS_MISSING))
                .description(read(mappedObject, ACCOMMODATION_DESCRIPTION, String.class, ERROR_ACCOMMODATION_DESCRIPTION_INVALID))
                .facilities(read(mappedObject, ACCOMMODATION_FACILITIES, Facilities.class, ERROR_ACCOMMODATION_FACILITIES_MISSING))
                .geoLocation(read(mappedObject, ACCOMMODATION_GEOLOCATION, GeoLocation.class, ERROR_ACCOMMODATION_GEOLOCATION_MISSING))
                .photos(read(mappedObject, ACCOMMODATION_PHOTOS, Set.class, ERROR_ACCOMMODATION_PHOTOS_MISSING))
                .build();
    }

    @Override
    public Accommodation create(Map<String, Object> mappedObject) {
        Accommodation accommodation = getObjectFromRequestMap(mappedObject);
        accommodation.setAverageRating(0.0);
        accommodation.setTotalRatingCount(0);
        DB.accommodations.add(accommodation);
        return null;
    }

    @Override
    public Accommodation update(Integer accId, Map<String, Object> mappedObject) {
        Accommodation existing = getById(accId);
        Accommodation accommodation = getObjectFromRequestMap(mappedObject);
        existing.setName(accommodation.getName());
        existing.setType(accommodation.getType());
        existing.setAddress(accommodation.getAddress());
        existing.setFacilities(accommodation.getFacilities());
        existing.setGeoLocation(accommodation.getGeoLocation());
        existing.setPhotos(accommodation.getPhotos());
        existing.setRatings(accommodation.getRatings());
        existing.setDescription(accommodation.getDescription());

        return null;
    }

    @Override
    public Boolean delete(Integer accId) {
        DB.accommodations = DB.accommodations.stream()
                .filter(acc -> !Objects.equals(acc.getAccommodationId(), accId))
                .toList();
        return true;
    }
}
