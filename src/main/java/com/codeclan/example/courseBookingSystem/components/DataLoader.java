package com.codeclan.example.courseBookingSystem.components;

import com.codeclan.example.courseBookingSystem.models.Booking;
import com.codeclan.example.courseBookingSystem.models.Course;
import com.codeclan.example.courseBookingSystem.models.Customer;
import com.codeclan.example.courseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.courseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.courseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Customer customer = new Customer("Jombo","Lionsville",24);
        customerRepository.save(customer);
        Course course =  new Course("Wobble Physics Introduction", "Tigersville", 4);
        courseRepository.save(course);
        Booking booking = new Booking("17-11-1765",course,customer);
        bookingRepository.save(booking);
    }
}
