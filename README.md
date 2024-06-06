package com.sapient.asde.service;

import com.sapient.asde.model.Car;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    @Override
    public double sumOfPrices(List<Car> carList) {
        return carList.stream()
                .mapToDouble(Car::getPrice)
                .sum();
    }

    @Override
    public List<String> getCarNames(List<Car> carList) {
        return carList.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getCarMakers(List<Car> carList) {
        return carList.stream()
                .map(Car::getCareMake)
                .collect(Collectors.toSet());
    }

    @Override
    public double getHighPricedCar(List<Car> carList) {
        return carList.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0.0);
    }

    @Override
    public Car getCarWithLowPricedCar(List<Car> carList) {
        return carList.stream()
                .min((car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice()))
                .orElse(null);
    }
}


package com.sapient.asde.ui;

import com.sapient.asde.model.Car;
import com.sapient.asde.service.CarService;
import com.sapient.asde.service.CarServiceImpl;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

