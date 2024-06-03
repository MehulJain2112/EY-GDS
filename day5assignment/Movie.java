package com.ey.day5assignment;
//import java.util.*;

class Movie implements Comparable<Movie>{
	private String name;
	private String language;
	private String releaseDate;
	private String director;
	private String producer;
	private int duration;
	
	public Movie(String name, String language, String releaseDate, String director, String producer, int duration) {
		super();
		this.name = name;
		this.language = language;
		this.releaseDate = releaseDate;
		this.director = director;
		this.producer = producer;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	public String getReleaseDate() {
		return releaseDate;
	}
	
	public String getDirector() {
		return director;
	}

	public String getProducer() {
		return producer;
	}

	public int getDuration() {
		return duration;
	}

	@Override
	public int compareTo(Movie other) {
		return this.language.compareTo(other.language);
	}
	

	@Override
	public String toString() {
		return "Movie [name=" + name + ", language=" + language + ", releaseDate=" + releaseDate + ", director="
				+ director + ", producer=" + producer + ", duration=" + duration + "]";
	}
	
}

