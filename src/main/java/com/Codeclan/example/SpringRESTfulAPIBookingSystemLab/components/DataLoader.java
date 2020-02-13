package com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.components;


import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Booking;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Course;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Customer;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories.BookingRepository;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories.CourseRepository;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        bookingRepository.deleteAll();
        courseRepository.deleteAll();
        customerRepository.deleteAll();


        Course salsa = new Course("Salsa", "Uddingston", 3);
        courseRepository.save(salsa);

        Course ballroom = new Course("Ballroom", "Hawick", 5);
        courseRepository.save(ballroom);

        Course tango = new Course("Tango", "Kilmartin", 2);
        courseRepository.save(tango);



        Customer jeb = new Customer("Jeb", "Hawick", 32);
        customerRepository.save(jeb);

        Customer bill = new Customer("Bill", "Gretna", 27);
        customerRepository.save(bill);

        Customer val = new Customer("Val", "Hawick", 35);
        customerRepository.save(val);



        Booking booking1 = new Booking("31-01-20", jeb, ballroom);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("03-02-20", val, salsa);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("10-05-20", bill, tango);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("17-04-20", jeb, salsa);
        bookingRepository.save(booking4);

    }
}
