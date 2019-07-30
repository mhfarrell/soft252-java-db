/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import cars.CarList;
import java.util.logging.Level;
import java.util.logging.Logger;
import staff.StaffList;


/**
 *
 * @author Chris
 */
public class StateLoader {
    
    public CarList RestoreCarList () throws IOException, ClassNotFoundException{
                
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("carlist.al"));
        CarList carList = (CarList) is.readObject(); 
        return carList;                   
  
     
    }
    
    public StaffList RestoreStaffList () throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("stafflist.al"));
        StaffList staffList = (StaffList) is.readObject();      
    return staffList;
    }
}
