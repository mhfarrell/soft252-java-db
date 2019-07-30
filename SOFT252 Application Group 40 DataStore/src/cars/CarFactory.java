/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import cars.Car;

/**
 *
 * @author Chris
 */
public class CarFactory {
    
    public Car BuildCar(String make, String model, String registration){
        Car newCar = new Car();
        newCar.setModel(model);
        newCar.setMake(make);
        newCar.setRegistration(registration);
        return newCar;
    }
    
}
