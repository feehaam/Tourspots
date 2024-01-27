package com.feeham.playground.staticdata;

import com.feeham.playground.models.Address;
import com.feeham.playground.models.Tourist;

import java.util.List;

public class DB {
    public static final Address dummyAddress
            = new Address("Street", "City", "State", "PostCode", "Country");
    public static List<Tourist> tourists = List.of(
            new Tourist(1, "Ibn", "Batutta", dummyAddress, dummyAddress),
            new Tourist(2, "Leo", "Vinci", dummyAddress, dummyAddress),
            new Tourist(3, "Nadir", "On the go", dummyAddress, dummyAddress),
            new Tourist(4, "MD", "Feeham", dummyAddress, dummyAddress),
            new Tourist(5, "Mubarak", "Shuvo", dummyAddress, dummyAddress)
    );
}