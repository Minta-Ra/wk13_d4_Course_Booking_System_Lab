package com.codeclan.example.courseBookingSystem;

import com.codeclan.example.courseBookingSystem.models.Course;
import com.codeclan.example.courseBookingSystem.models.Customer;
import com.codeclan.example.courseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.courseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.courseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void findCoursesByRating() {

		List<Course> found = courseRepository.findByStarRating(4);

		assertEquals(1, found.size());

	}

	@Test
	void findAllCustomersForAGivenCourse() {
		Course course = courseRepository.getById(1L);
		List<Customer> found = customerRepository.findByBookingsCourse(course);

		assertEquals(1, found.size());
		assertEquals("Jombo", found.get(0).getName());
	}

	@Test
	void findAllCoursesForAGivenCustomer() {
		Customer customer = customerRepository.getById(1L);
		List<Course>  found = courseRepository.findByBookingsCustomerName(customer.getName());

		assertEquals("Wobble Physics Introduction", found.get(0).getName());
	}
}
