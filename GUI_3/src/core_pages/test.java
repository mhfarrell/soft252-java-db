/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_pages;

import cars.Car;
import cars.CarBuyer;
import cars.CarList;
import java.io.IOException;
import java.time.LocalDate;
import staff.StaffList;
import utilities.StateLoader;

/**
 *
 * @author Chris
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
//        CarList carList;
//        StaffList staffList;
//      
//        StateLoader stateLoader = new StateLoader();
//        carList = stateLoader.RestoreCarList();
//        staffList = stateLoader.RestoreStaffList();
//        
//        CarBuyer carBuyer = new CarBuyer();
//        LocalDate motDate = LocalDate.now();
//        int serviceMileage = 30000;
//        int mileage = 12000;
//        String make  = "Ford";
//        String model = "Ford Fiesta";
//        String reg = "CK65JHN";
//                
//        Car testCar = carBuyer.BuyCar(serviceMileage, motDate, mileage, make, model, reg);
//        carList.addCar(testCar);
//        carList.saveState();

            CarList carList = new CarList();
            carList.saveState();
         
        
        
    }
    
}
