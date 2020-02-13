package com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories;

import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseId(Long id);

    List<Customer> findByTownAndBookingsCourseId(String town, Long courseId);

    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseId(int age, String townName, long courseId);
}
