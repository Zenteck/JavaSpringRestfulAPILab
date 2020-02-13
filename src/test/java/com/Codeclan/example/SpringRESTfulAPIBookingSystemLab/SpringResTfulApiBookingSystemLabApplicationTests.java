package com.Codeclan.example.SpringRESTfulAPIBookingSystemLab;

import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Course;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Booking;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.models.Customer;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories.BookingRepository;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories.CourseRepository;
import com.Codeclan.example.SpringRESTfulAPIBookingSystemLab.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringResTfulApiBookingSystemLabApplicationTests {


	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BookingRepository bookingRepository;



	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetCoursesWithGivenRating(){
		List<Course> found = courseRepository.findByRating(3);
		assertEquals(1, found.size());
		assertEquals("Salsa", found.get(0).getTitle());
	}

	@Test
	public void getAllCustomersForAGivenCourse(){
		List<Customer> found = customerRepository.findByBookingsCourseId((long)1);
		assertEquals(2, found.size());
		assertEquals("Jeb", found.get(0).getName());
		assertEquals("Val", found.get(1).getName());
	}

	@Test
	public void canGetAllCoursesForAGivenCustomer(){
		List<Course> found = courseRepository.findByBookingsCustomerId((long) 1);
		assertEquals(2, found.size());
		assertEquals("Salsa", found.get(0).getTitle());
		assertEquals("Ballroom", found.get(1).getTitle());
	}

	@Test
	public void canGetAllBookingsForAGivenDate(){
		List<Booking> found = bookingRepository.findByDate("10-05-20");
		assertEquals(1, found.size());
	}

	@Test
	public void canGetAllCustomersGivenTownGivenCourse(){
		List<Customer> found = customerRepository.findByTownAndBookingsCourseId( "Hawick", 1L);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetAllCustomersOverAgeGivenTownGivenCourse(){
		List<Customer> found = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseId(34, "Hawick", 1L);
		assertEquals(1, found.size());
	}


}


