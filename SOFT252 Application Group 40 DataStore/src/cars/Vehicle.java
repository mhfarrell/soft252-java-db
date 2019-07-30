/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import cars.States;
import cars.OnLoan;
import cars.NeedsService;
import cars.NeedsRepair;
import cars.NeedsMot;
import cars.InRepair;
import cars.InMot;
import cars.Available;
import utilities.ISubject;
import utilities.IObserver;
import utilities.VehicleState;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observer;



/**
 *
 * @author Chris
 */
public class Vehicle implements ISubject  {    
    
    VehicleState available;
    VehicleState inMot;
    VehicleState inRepair;
    VehicleState needsMot;
    VehicleState needsRepair;
    VehicleState needsService;
    VehicleState onLoan;
    
    VehicleState state;
    String registration;
    String make;
    String model;
    LocalDate motDate;
    int mileage;
    int nextServiceMileage;
    ArrayList<IObserver> observers;
    boolean permanentLoan;
    States stateID;
    

    public Vehicle() {
        available= new Available(this);
        inMot = new InMot(this);
        inRepair = new InRepair(this);
        needsMot = new NeedsMot(this);
        needsRepair = new NeedsRepair(this);
        needsService = new NeedsService(this);
        onLoan = new OnLoan(this);
        observers = new ArrayList<IObserver>();
        state = available;
        permanentLoan = false;
        
        
    }   
        
    public VehicleState getState() {
        
        return state;
    }
    
    public States getStateID(){
        return stateID;
    }
    
    public void setStateID(States state){
        this.stateID = state;
    }

    public void setState(VehicleState state) {
        this.state = state;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getMotDate() {
        return motDate;
    }

    public void setMotDate(LocalDate motDate) {
        this.motDate = motDate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getNextServiceMileage() {
        return nextServiceMileage;
    }

    public void setNextServiceMileage(int nextServiceMileage) {
        this.nextServiceMileage = nextServiceMileage;
    }
    
   
    public void CheckMot() {
        LocalDate date;
        date = LocalDate.now();
        LocalDate motDate;
        motDate = this.getMotDate();
        if (motDate.isEqual(date)){
            this.setState(this.needsMot);
            this.setStateID(States.NEEDSMOT);
        }
        else if (motDate.isBefore(date)){
            this.setState(this.needsMot);
            this.setStateID(States.NEEDSMOT);
        }
        notifyObservers();
    }

    
    public void CheckService() {
        int mileage = this.getMileage();
        int serviceMileage = this.getNextServiceMileage();
        if (mileage >= serviceMileage){
            this.setState(this.needsService);
            this.setStateID(States.NEEDSSERVICE);
        }
        notifyObservers();
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
