/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import utilities.IObserver;
import utilities.Loanable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import staff.Staff;

/**
 *
 * @author Chris
 */
public class Car extends Vehicle implements Loanable, Serializable{
    
    LocalDate returnDate;
    Staff staff;
    
    public Car(){
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
    

    @Override
    public void LoanVehicle(LocalDate date, Staff staff) {
        if (state == available){
            state = onLoan;
            stateID = States.ONLOAN;
            returnDate = date.plusDays(1);
            permanentLoan = false;
            this.staff = staff;
            notifyObservers();
        }
    }
    

    @Override
    public void ReturnVehicle(int miles) {
        if (state == onLoan){
            state = available;
            stateID = States.AVAILABLE;
            this.staff = null;
            permanentLoan = false;
            this.setMileage(miles);
            this.notifyObservers();
        }
    }

    @Override
    public void LoanVehiclePermanent(Staff staff) {
        if (state == available){
            state = onLoan;
            stateID = States.ONLOAN;
            permanentLoan = true;
            this.staff = staff;
            notifyObservers();
        }
    }
    
    
    
    

    
    
    
}
