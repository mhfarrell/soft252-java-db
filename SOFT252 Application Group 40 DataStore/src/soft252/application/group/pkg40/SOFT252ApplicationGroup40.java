/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252.application.group.pkg40;

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
public class SOFT252ApplicationGroup40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        StaffList staffList = new StaffList();
        CarList carList = new CarList();
             
        
        staffList.saveState();
        carList.saveState();
        
        StateLoader stateLoader = new StateLoader();
        carList = stateLoader.RestoreCarList();
        staffList = stateLoader.RestoreStaffList();
        
        
    }
    
}
