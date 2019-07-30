/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import cars.Car;
import java.time.LocalDate;

/**
 *
 * @author Chris
 */
public class CarBuyer extends CarFactory {
    
    public Car BuyCar (int serviceMileage, LocalDate mot, int mileage, String make, String Model, String registration){
        CarFactory factory = new CarFactory();
        Car newCar = factory.BuildCar(make, Model, registration);
        newCar.setMotDate(mot);
        newCar.setMileage(serviceMileage);
        newCar.setMileage(mileage);
        return newCar;
    }
    
}
