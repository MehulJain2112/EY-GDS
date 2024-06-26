  package StreamAPI.casestudy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

    public static void main(String[] args) {
        List<Candidate> candidates = Arrays.asList(
                new Candidate("John Doe", "Java", "Pune", 3),
                new Candidate("Jane Smith", "Python", "Mumbai", 1),
                new Candidate("Mike Johnson", "Java", "Pune", 5),
                new Candidate("Emily Brown", "JavaScript", "Bangalore", 2),
                new Candidate("Chris Lee", "Python", "Pune", 4),
                new Candidate("Sarah Clark", "Java", "Mumbai", 1)
        );

        // List candidate names from Pune city
        System.out.println("List of Pune Candidates:");
        candidates.stream()
                  .filter(candidate -> candidate.getCity().equalsIgnoreCase("Pune"))
                  .map(Candidate::getName)
                  .forEach(System.out::println);

        // List city and count of candidates per city
        System.out.println("\nCandidate count per city:");
        Map<String, Long> cityCountMap = candidates.stream()
                .collect(Collectors.groupingBy(Candidate::getCity, Collectors.counting()));
        cityCountMap.forEach((city, count) -> System.out.println(city + ": " + count));

        // List technical expertise and count of candidates
        System.out.println("\nCandidate count by Technical Expertise:");
        Map<String, Long> expertiseCountMap = candidates.stream()
                .collect(Collectors.groupingBy(Candidate::getTechnicalExpertise, Collectors.counting()));
        expertiseCountMap.forEach((expertise, count) -> System.out.println(expertise + ": " + count));

        // List fresher candidates (experience less than or equal to 1 year)
        System.out.println("\nFresher Candidate list:");
        candidates.stream()
                  .filter(candidate -> candidate.getYearsOfExperience() <= 1)
                  .map(Candidate::getName)
                  .forEach(System.out::println);

        // Listing candidates with highest experience
        System.out.println("\nSorted List of Candidates by Experience:");
        candidates.stream()
                  .sorted(Comparator.comparingInt(Candidate::getYearsOfExperience).reversed())
                  .forEach(System.out::println);

        // Sort the candidates by city name
        printLine();
        System.out.println("Sorted List of Candidates by City Name:");
        candidates.stream()
                  .sorted(Comparator.comparing(Candidate::getCity))
                  .forEach(System.out::println);
    }

    private static void printLine() {
        System.out.println("================");
    }
}
