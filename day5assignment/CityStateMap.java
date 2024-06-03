package com.ey.day5assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CityStateMap {
	private HashMap<String, String> cityStateMap;
	
	public CityStateMap() {
		this.cityStateMap = new HashMap<>();
	}
	
	public void addCityState(String city, String state) {
		cityStateMap.put(city, state);
	}
	
	public String getState(String city) {
		return cityStateMap.get(city);
	}
	
	public Set<String> getAllCities() {
		return cityStateMap.keySet();
	}
	
	public Set<String> getAllStates() {
		return new HashSet<>(cityStateMap.values());
	}
	
	public Set<String> getCitiesForState(String state) {
		Set<String> cities = new HashSet<>();
		for(Map.Entry<String, String> entry : cityStateMap.entrySet()) {
			if(entry.getValue().equals(state))
				cities.add(entry.getKey());
		}
		return cities;
	}
	
	public void deleteCitiesForState(String state) {
		cityStateMap.entrySet().removeIf(entry -> entry.getValue().equals(state));
	}
	
	public static void main(String[] args) {
		CityStateMap cityStateMap = new CityStateMap();
		
		cityStateMap.addCityState("Bangalore","Karnataka");
		cityStateMap.addCityState("Mysore","Karnataka");
		cityStateMap.addCityState("Hubbali","Karnataka");
		cityStateMap.addCityState("Mumbai","Maharashtra");
		cityStateMap.addCityState("Pune","Maharashtra");
		
		System.out.println("All cities : "+cityStateMap.getAllCities());
		System.out.println("All States : "+cityStateMap.getAllStates());
		System.out.println("State of Bangalore : "+cityStateMap.getState("Bangalore"));
		System.out.println("State of Mumbai : "+cityStateMap.getState("Mumbai"));
		System.out.println("Cities in Karnataka : "+cityStateMap.getCitiesForState("Karnataka"));
		System.out.println("Cities in Maharashtra : "+cityStateMap.getCitiesForState("Maharashtra"));
		System.out.println("Deleting all Karnataka cities...");
		cityStateMap.deleteCitiesForState("Karnataka");
		System.out.println("All cities after deletion : "+cityStateMap.getAllCities());
	}
}
