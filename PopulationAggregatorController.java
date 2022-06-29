package com.countries.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.countries.demo.model.CountriesPopulationDetails;
import com.countries.demo.service.PopulationAggregatorService;

@RestController
@RequestMapping("/population/api")
public class PopulationAggregatorController {
	
	@Autowired
	private PopulationAggregatorService service;
	
	@GetMapping("/fetch/all")
	public CountriesPopulationDetails fetchPopulationDetails() {
		
		return service.fetchPopulationDetails();
	}

}
