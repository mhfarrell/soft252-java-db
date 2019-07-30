/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import staff.Person;
import utilities.ISubject;
import utilities.IObserver;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Staff extends Person implements ISubject, Serializable {
    
private ArrayList<Staff> staffList;
private ArrayList<IObserver> observers;


public Staff(String title, String firstName, String lastName) {

    super(title, firstName, lastName);
    observers = new ArrayList<IObserver>();
}

public Staff(){
    observers = new ArrayList<IObserver>();
}

public ArrayList GetStaffList(){
    return staffList;
}



@Override
public void setFirstName(String name){
    this.setFirstName(name);
    notifyObservers();
}

@Override
public void setLastName (String name){
    this.setLastName(name);
    notifyObservers();
}

@Override
public void setTitle (String title){
    this.setTitle(title);
    notifyObservers();
}

@Override
public String getTitle(){
    return title;
}

@Override
public String getFirstName(){
    return firstName;
}

@Override
public String getLastName(){
    return lastName;
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
    for (int i = 0; i < observers.size(); i++) {
        IObserver observer = (IObserver)observers.get(i);
        observer.update();
    }
}

    
    
}
