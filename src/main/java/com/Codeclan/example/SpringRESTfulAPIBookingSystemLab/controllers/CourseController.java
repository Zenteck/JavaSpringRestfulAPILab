package com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.controllers;

import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Course;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Customer;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses/rating")
    public ResponseEntity<List<Course>> getCoursesByRating(@RequestParam(name="rating") int rating){
        List<Course> found = courseRepository.findByRating(rating);
        return new ResponseEntity<>(found, HttpStatus.FOUND);
    }

    @GetMapping(value = "/courses/bookings/{id}")
    public ResponseEntity<List<Course>> getCoursesByCustomer(@PathVariable Long id) {
        List<Course> found = courseRepository.findByBookingsCustomerId(id);
        return new ResponseEntity<>(found, HttpStatus.FOUND);
    }



}
