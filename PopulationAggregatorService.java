package com.countries.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.countries.demo.model.CountriesPopulationDetails;
import com.countries.demo.model.CountryDetails;

@Service
public class PopulationAggregatorService {
	

	@Autowired
	RestTemplate restTemplate;

	public CountriesPopulationDetails fetchPopulationDetails() {

		List<CountryDetails> countriesDetails = new ArrayList<>();
		getCountryList().forEach(s -> countriesDetails.add(restTemplate.getForEntity("http://localhost:8092/country/api/fetch/population/"+s, CountryDetails.class)
				.getBody()));
		
		CountriesPopulationDetails populationDetails = new CountriesPopulationDetails();
		
		
		populationDetails.setTotalFemalePopulation(Long.toString(countriesDetails.stream().mapToLong(c -> c.getFemale_Population()).sum()));
		populationDetails.setTotalMalePopulation(Long.toString(countriesDetails.stream().mapToLong(c -> c.getMale_Population()).sum()));
		populationDetails.setTotalPopulation(Long.toString(Long.valueOf(countriesDetails.stream().mapToLong(c -> Math.addExact(c.getMale_Population(),
				c.getFemale_Population())).sum())));
				return populationDetails;
	}

	public List<String> getCountryList() {
		List<String> countryList = new ArrayList<>();
		countryList.add("USA");
		countryList.add("UK");
		countryList.add("INDIA");

		return countryList;
	}

}
