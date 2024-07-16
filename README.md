Problem Statement:

-com.ey.model 

------------------------------------------ 

public class Car { 

private String careMake; //ex. Maruti  

private String carName; // ex.Swift Dezire 

private double price;  // ex. 8120000.0 

 

public Car() {		 

} 

public Car(String careMake, String carName, double price) { 

super(); 

this.careMake = careMake; 

this.carName = carName; 

this.price = price; 

} 

public String getCareMake() { 

return careMake; 

} 

 

public String getCarName() { 

return carName; 

} 

 

public double getPrice() { 

return price; 

} 

 

public void setCareMake(String careMake) { 

this.careMake = careMake; 

} 

 

public void setCarName(String carName) { 

this.carName = carName; 

} 

 

public void setPrice(double price) { 

this.price = price; 

} 

 

@Override 

public String toString() { 

return "Car [careMake=" + careMake + ", carName=" + carName + ", price=" + price + "]"; 

} 

 

 

} 

 

com.ey.service 

---------------------------------------------------------------- 

public interface CarService{ 

public double sumOfPrices(List<Car> carList); 

public List<String> getCarNames(List<Car> carList); 

public Set<String> getCarMakers(List<Car> carList); 

//returns price of the car which has highest price 

public double getHighPricedCar(List<Car> carList); 

//returns Car which has lowest price 

public Car getCarWithLowPricedCar(List<Car> carList) 

} 
//Implement the above interface using Stream API in com.ey.service 


com.ey.ui 

public class CarApp{ 

public static void main(String[] args){ 

Car cars[]= { 

new Car("Maruti","Swift Dezire",810000.00), 

new Car("Hyundai","Verna",1100000.00), 

new Car("Toyota","Innova",2450000.00), 

new Car("Audi","Q3",4500000.00) 

}; 

List<Car> carList = new ArrayList<>(Arrays.asList(cars)); 

try { 

//TODO 

}catch(Exception e) { 

e.printStackTrace(); 

} 

} 


package com.ey.ui;

import com.ey.model.Car;
import com.ey.service.CarService;
import com.ey.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarApp {

    public static void main(String[] args) {

        Car cars[] = {
            new Car("Maruti", "Swift Dezire", 810000.00),
            new Car("Hyundai", "Verna", 1100000.00),
            new Car("Toyota", "Innova", 2450000.00),
            new Car("Audi", "Q3", 4500000.00)
        };

        List<Car> carList = new ArrayList<>(Arrays.asList(cars));
        CarService carService = new CarServiceImpl();

        try {
            double totalSum = carService.sumOfPrices(carList);
            List<String> carNames = carService.getCarNames(carList);
            Set<String> carMakers = carService.getCarMakers(carList);
            double highestPrice = carService.getHighPricedCar(carList);
            Car lowestPricedCar = carService.getCarWithLowPricedCar(carList);

            System.out.println("Sum of all car prices: " + totalSum);
            System.out.println("List of car names: " + carNames);
            System.out.println("Set of car makers: " + carMakers);
            System.out.println("Highest car price: " + highestPrice);
            System.out.println("Car with the lowest price: " + lowestPricedCar);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package com.ey.service;

import com.ey.model.Car;
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
                      .orElse(0);
    }

    @Override
    public Car getCarWithLowPricedCar(List<Car> carList) {
        return carList.stream()
                      .min((car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice()))
                      .orElse(null);
    }
}


package com.ey.service;

import com.ey.model.Car;

import java.util.List;
import java.util.Set;

public interface CarService {
    double sumOfPrices(List<Car> carList);
    List<String> getCarNames(List<Car> carList);
    Set<String> getCarMakers(List<Car> carList);
    double getHighPricedCar(List<Car> carList);
    Car getCarWithLowPricedCar(List<Car> carList);
}
