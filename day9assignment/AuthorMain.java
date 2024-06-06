package com.ey.day9assignment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AuthorMain {
    public static void main(String[] args) {
        List<Author> authors = Arrays.asList(
                new Author(1234567890L, "Jain", "Mehul", "Jainn", LocalDate.of(2001, 1, 15), "male", "Bangalore", 6362795752L),
                new Author(2345678901L, "Jain", "Akshat", "Kumar", LocalDate.of(2000, 2, 13), "male", "Ranchi", 8765432109L),
                new Author(3456789012L, "Gangurde", "Komal", "Vasant", LocalDate.of(2002, 5, 16), "female", "Nashik", 7654321098L),
                new Author(4567890123L, "Jainn", "Nirmala", "Jainn", LocalDate.of(1975, 11, 12), "female", "Jaipur", 6543210987L)
        );

        AuthorService authorService = new AuthorServiceImpl();

        System.out.println("Unique Surnames: " + authorService.getUniqueSurnames(authors));
        System.out.println("Authors in New Bangalore: " + authorService.getAuthorsByCity(authors, "Bangalore"));
        System.out.println("Average Age of Female Authors: " + authorService.femaleAverageAge(authors));
        System.out.println("Mobile Number for Adhar 1234567890: " + authorService.getMobileByAdhar(authors, 1234567890L));
    }
}
