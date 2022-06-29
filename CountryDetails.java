package com.countries.demo.model;

public class CountryDetails {
	
	private String countryName;
	private Long female_Population;
	private Long male_Population;
	
	public CountryDetails() {
		
	}
	public CountryDetails(String countryName, Long female_Population, Long male_Population) {
		super();
		this.countryName = countryName;
		this.female_Population = female_Population;
		this.male_Population = male_Population;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Long getFemale_Population() {
		return female_Population;
	}
	public void setFemale_Population(Long female_Population) {
		this.female_Population = female_Population;
	}
	public Long getMale_Population() {
		return male_Population;
	}
	public void setMale_Population(Long male_Population) {
		this.male_Population = male_Population;
	}
	
}
