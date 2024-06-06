package com.ey.day9assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarApp {

    public static void main(String[] args) {
        Car[] cars = {
                new Car("Maruti", "Swift Dezire", 810000.00),
                new Car("Hyundai", "Verna", 1100000.00),
                new Car("Toyota", "Innova", 2450000.00),
                new Car("Audi", "Q3", 4500000.00)
        };

        List<Car> carList = new ArrayList<>(Arrays.asList(cars));
        CarService carService = new CarServiceImpl();

        try {
            System.out.println("Sum of Prices: " + carService.sumOfPrices(carList));
            System.out.println("Car Names: " + carService.getCarNames(carList));
            System.out.println("Car Makers: " + carService.getCarMakers(carList));
            System.out.println("Highest Priced Car: " + carService.getHighPricedCar(carList));
            System.out.println("Car with Lowest Price: " + carService.getCarWithLowPricedCar(carList));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
