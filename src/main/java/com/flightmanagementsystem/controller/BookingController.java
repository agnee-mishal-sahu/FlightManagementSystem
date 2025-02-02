package com.flightmanagementsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.entity.Booking;
import com.flightmanagementsystem.exception.BookingManagementException;
import com.flightmanagementsystem.serviceimpl.IBookingServiceImpl;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	IBookingServiceImpl bookingService;
	

	@PostMapping("/")
	public String addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}

	@DeleteMapping("/delete")
	public String deleteBooking(@RequestParam(name="bookingid") Integer bookingId) throws BookingManagementException {
		return bookingService.cancelBooking(bookingId);
	}

	@GetMapping("/viewbookings")
	public List<Booking> viewBookings() {
		return bookingService.viewBookings();
	}
 
	@GetMapping("/bypassengerid/{passengerid}")
	public List<Booking> getBookingByPassengerId(@PathVariable("passengerid") Long passengerId) throws BookingManagementException {
		
		return bookingService.viewBookingByPassengerId(passengerId);
	}

	@GetMapping("/bybookingid/{bookingid}")
	public Booking viewBookingByBookingId(@PathVariable("bookingid") Integer bookingId) throws BookingManagementException {
		
		return bookingService.viewBookingByBookingId(bookingId);

	}

	@GetMapping("/bydate/{bookingdate}")
	public List<Booking> viewBookingByDate(@PathVariable("bookingdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate) throws BookingManagementException {
		return bookingService.viewBookingByDate(bookingDate);
	}

	@GetMapping("/byflight/{flightid}")
	public List<Booking> viewBookingsByFlightId(@PathVariable("flightid") Integer flightid) throws BookingManagementException {
		return bookingService.viewBookingsByFlightId(flightid);
	}

	@PutMapping("/update")
	public Booking updateBooking(@RequestBody Booking booking)  {
		return bookingService.updateBooking(booking);
	}
}
