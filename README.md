import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {

    // Get the unique surnames in uppercase
    @Override
    public Set<String> getUniqueSurnames(List<Author> authorList) {
        return authorList.stream()
                .map(author -> author.getSurname().toUpperCase())
                .collect(Collectors.toSet());
    }

    // Get the authors by city
    @Override
    public List<Author> getAuthorsByCity(List<Author> authorList, String city) {
        return authorList.stream()
                .filter(author -> author.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    // Calculate the average age of female authors
    @Override
    public double femaleAverageAge(List<Author> authorList) {
        return authorList.stream()
                .filter(author -> "female".equalsIgnoreCase(author.getGender()))
                .mapToInt(author -> Period.between(author.getBirthdate(), LocalDate.now()).getYears())
                .average()
                .orElse(0);
    }

    // Get the mobile number by Adhar Card
    @Override
    public Long getMobileByAdhar(List<Author> authorList, Long adharCard) {
        return authorList.stream()
                .filter(author -> author.getAdharCard().equals(adharCard))
                .map(Author::getMobile)
                .findFirst()
                .orElse(null);
    }
}


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Author> authors = Arrays.asList(
                new Author(1234567890L, "Smith", "John", "Doe", LocalDate.of(1980, 1, 1), "male", "New York", 9876543210L),
                new Author(2345678901L, "Johnson", "Jane", "Doe", LocalDate.of(1990, 2, 2), "female", "Los Angeles", 8765432109L),
                new Author(3456789012L, "Smith", "Anna", "Taylor", LocalDate.of(1985, 3, 3), "female", "New York", 7654321098L),
                new Author(4567890123L, "Brown", "Mike", "Johnson", LocalDate.of(1975, 4, 4), "male", "Chicago", 6543210987L)
        );

        AuthorService authorService = new AuthorServiceImpl();

        System.out.println("Unique Surnames: " + authorService.getUniqueSurnames(authors));
        System.out.println("Authors in New York: " + authorService.getAuthorsByCity(authors, "New York"));
        System.out.println("Average Age of Female Authors: " + authorService.femaleAverageAge(authors));
        System.out.println("Mobile Number for Adhar 1234567890: " + authorService.getMobileByAdhar(authors, 1234567890L));
    }
}

