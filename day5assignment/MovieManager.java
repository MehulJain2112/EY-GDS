package com.ey.day5assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieManager {
	public List<Movie> createMovieSet() {
		List<Movie> movieList = new ArrayList<>();
		movieList.add(new Movie("ZNMD","English","2010","Farah","FarahKhan",120));
		movieList.add(new Movie("K3G","Hindi","2001","Karan","KaranJohar",180));
		movieList.add(new Movie("SOTY","French","2002","Mehul","MehulJain",156));
		return movieList;
	}
	
	public void sortByLanguage(List<Movie> movieList) {
		Collections.sort(movieList);
	}
	
	public void sortByDirector(List<Movie> movieList) {
		Collections.sort(movieList,new Comparator<Movie>() {
			@Override
			public int compare(Movie m1,Movie m2) {
				return m1.getDirector().compareTo(m2.getDirector());
			}
		});
	}
	
	public static void main(String[] args) {
		MovieManager manager = new MovieManager();
		List<Movie> movies = manager.createMovieSet();
		
		System.out.println("List of Movies : ");
		for(Movie movie:movies)
			System.out.println(movie);
		
		manager.sortByLanguage(movies);
		System.out.println("\nSorted by Language : ");
		for(Movie movie:movies)
			System.out.println(movie);
		
		manager.sortByDirector(movies);
		System.out.println("\nSorted by Director : ");
		for(Movie movie:movies)
			System.out.println(movie);
		
	}
}
