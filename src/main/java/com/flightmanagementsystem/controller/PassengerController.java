package com.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.dto.PassengerDTO;
import com.flightmanagementsystem.entity.Passenger;
import com.flightmanagementsystem.exception.PassengerManagementException;
import com.flightmanagementsystem.service.IPassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	IPassengerService passengerService;

	@PostMapping("/")
	public String addPassenger(@RequestBody Passenger passenger) {
		return passengerService.addPassenger(passenger);
	}

	@GetMapping("/allpassenger")
	public List<PassengerDTO> getAllPassenger() throws PassengerManagementException {
		return passengerService.viewAllPassenger();
	}

	@GetMapping("/byuin/{uin}")
	public PassengerDTO getByUin(@PathVariable("uin") long uin) throws PassengerManagementException {
		return passengerService.viewPassengerByUIN(uin);
	}

	@GetMapping("/bymobile/{mob}")
	public PassengerDTO getByMobileNumber(@PathVariable("mob") long contactNo) throws PassengerManagementException {
		return passengerService.viewPassengerByMobileNo(contactNo);
	}
}
