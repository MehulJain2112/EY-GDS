package com.ey.model;

public class BookMyMovie {
    private int movield;
    private int noOfTickets;
    private double discount;
    private double totalAmount;

    public BookMyMovie(int movield, int noOfTickets) {
        this.movield = movield;
        this.noOfTickets = noOfTickets;
    }

    public int getMovield() {
        return movield;
    }

    public void setMovield(int movield) {
        this.movield = movield;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void calculateDiscount() {
        if (movield == 101 || movield == 103) {
            if (noOfTickets >= 5 && noOfTickets < 10) {
                discount = 15;
            } else if (noOfTickets >= 10 && noOfTickets <= 15) {
                discount = 20;
            } else {
                discount = 0;
            }
        } else if (movield == 102) {
            if (noOfTickets >= 5 && noOfTickets < 10) {
                discount = 10;
            } else if (noOfTickets >= 10 && noOfTickets <= 15) {
                discount = 15;
            } else {
                discount = 0;
            }
        } else {
            discount = 0;
        }
    }

    public double calculateTicketAmount() throws InvalidMovieIdException {
        calculateDiscount();

        double baseFare;
        switch (movield) {
            case 101:
                baseFare = 120;
                break;
            case 102:
                baseFare = 170;
                break;
            case 103:
                baseFare = 150;
                break;
            default:
                throw new InvalidMovieIdException("Invalid Movie ID: " + movield);
        }

        totalAmount = baseFare * noOfTickets - (baseFare * noOfTickets * discount / 100);
        return totalAmount;
    }
}


package com.ey.exception;

public class InvalidMovieIdException extends Exception {
    public InvalidMovieIdException(String message) {
        super(message);
    }
}


package com.ey.service;

public interface BookMyMovieInterface {
    double calculateTicketAmount() throws InvalidMovieIdException;
}



package com.ey.service;

import com.ey.model.BookMyMovie;
import com.ey.exception.InvalidMovieIdException;

public class BookMyMovieImpl extends BookMyMovie implements BookMyMovieInterface {

    public BookMyMovieImpl(int movield, int noOfTickets) {
        super(movield, noOfTickets);
    }

    @Override
    public double calculateTicketAmount() throws InvalidMovieIdException {
        return super.calculateTicketAmount();
    }
}



package com.ey.ui;

import com.ey.model.BookMyMovie;
import com.ey.service.BookMyMovieImpl;
import com.ey.exception.InvalidMovieIdException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void main(String[] args) {
        try {
            displayFares();

            List<BookMyMovie> bookings = new ArrayList<>();
            bookings.add(new BookMyMovieImpl(101, 5));
            bookings.add(new BookMyMovieImpl(102, 4));
            bookings.add(new BookMyMovieImpl(103, 8));

            for (BookMyMovie booking : bookings) {
                try {
                    double totalAmount = booking.calculateTicketAmount();
                    System.out.println("Total amount for booking: " + totalAmount);
                } catch (InvalidMovieIdException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayFares() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("movie.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}


101: 120
102: 170
103: 150
