package com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.controllers;

import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Customer;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

@GetMapping(value = "/customers/bookings/{id}")
    public ResponseEntity<List<Customer>> getCustomersByCourse(@PathVariable Long id) {
    List<Customer> found = customerRepository.findByBookingsCourseId(id);
    return new ResponseEntity<>(found, HttpStatus.FOUND);
}
@GetMapping(value = "/customers/bookings/{id}/town")
    public ResponseEntity<List<Customer>> getCustomersByTownAndCourseID(@RequestParam(name="town") String town, @PathVariable Long id){
    List<Customer> found = customerRepository.findByTownAndBookingsCourseId(town, id);
    return new ResponseEntity<>(found, HttpStatus.FOUND);
//    http://localhost:8080//customers/bookings/1/town?town=Hawick
}

    @GetMapping(value = "/customers/bookings/{id}/{age}/town")
    public ResponseEntity<List<Customer>> getCustomersByAgeAndTownAndCourseID(@PathVariable int age, @RequestParam(name="town") String town, @PathVariable Long id){
        List<Customer> found = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseId(age, town, id);
        return new ResponseEntity<>(found, HttpStatus.FOUND);
    }
//    http://localhost:8080//customers/bookings/1/32/town?town=Hawick




}
