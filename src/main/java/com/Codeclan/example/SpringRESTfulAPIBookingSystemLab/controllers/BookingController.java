package com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.controllers;


import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Booking;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings/date")
    public ResponseEntity<List<Booking>> getBookingsByDate(@RequestParam(name = "date")String date){
        List<Booking> found = bookingRepository.findByDate(date);
        return new ResponseEntity<>(found, HttpStatus.FOUND);
    }
//    http://localhost:8080/bookings/date?date=31-01-20

}
