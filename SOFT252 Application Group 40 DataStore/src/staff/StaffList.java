/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import staff.Staff;
import cars.CarList;
import utilities.IStateSaver;
import utilities.IObserver;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.ISubject;

/**
 *
 * @author Chris
 */
public class StaffList implements IStateSaver, IObserver, Serializable, ISubject {

private ArrayList<Staff> staffList = new ArrayList<Staff>();   
ArrayList<IObserver> observers;
    


public void addStaff(Staff newStaff){
    staffList.add(newStaff);
    newStaff.registerObserver(this);
}
public void removeStaff(Staff staff){
    staffList.remove(staff);
    staff.removeObserver(this);
}
public void getStaff(Staff staff) {
    //return all attributes?
}

public ArrayList GetStaffList(){
    return staffList;
}

    @Override
    public void saveState(){
    try{
        FileOutputStream sl = new FileOutputStream("stafflist.al");
        ObjectOutputStream os = new ObjectOutputStream(sl);
        os.writeObject(this);
        os.close();
        
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(CarList.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(CarList.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override 
    public void update() 
{
    staffList = staffList;
}

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
    }

  
    @Override
    public void removeObserver(IObserver o) {
        int i = observers.indexOf(o);
    if (i >= 0) {
        observers.remove(i);
    }
    }

    @Override
    public void notifyObservers() {
        
        for (IObserver observer : observers){
            observer.update();
    }
}
    
}
