/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import utilities.VehicleState;
import java.time.LocalDate;

/**
 *
 * @author Chris
 */
public class NeedsService implements VehicleState{

    Vehicle v;
    
    public NeedsService(Vehicle v) {
        this.v = v;
    }
    
    @Override
    public void SendRepair() {
        v.setState(v.inRepair);
        v.setStateID(States.INREPAIR);
        v.notifyObservers();
    }

    @Override
    public void SendService() {
        v.setState(v.inRepair);
        v.setStateID(States.INREPAIR);
        v.notifyObservers();
    }

    @Override
    public void SendMot() {
        v.setState(v.inMot);
        v.setStateID(States.INMOT);
        v.notifyObservers();
    }
        
    

    @Override
    public void ReturnMot(LocalDate date) {
        v.CheckService();
        v.notifyObservers();
    }

    @Override
    public void ReturnService(int mileage) {
        v.CheckMot();
        v.setNextServiceMileage(mileage);
        v.notifyObservers();
    }

    @Override
    public void ReturnRepair() {
        v.CheckMot();
        v.CheckService();
        v.notifyObservers();
    }
}
