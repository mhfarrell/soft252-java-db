/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import cars.Car;
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
public class CarList implements IObserver, IStateSaver, Serializable, ISubject {

private ArrayList<Car> carList = new ArrayList<Car>();
private ArrayList<Car> carList_inMot = new ArrayList<Car>();
private ArrayList<Car> carList_inRepair = new ArrayList<Car>();
private ArrayList<Car> carList_needsMot = new ArrayList<Car>();
private ArrayList<Car> carList_needsRepair = new ArrayList<Car>();
private ArrayList<Car> carList_needsService = new ArrayList<Car>();
private ArrayList<Car> carList_onLoan = new ArrayList<Car>();
private ArrayList<Car> carList_available = new ArrayList<Car>();
ArrayList<IObserver> observers;

public void addCar(Car newCar){
carList.add(newCar);
carList_available.add(newCar);
newCar.registerObserver(this);
saveState();
}

public void removeCar(Car car){
carList.remove(car);
car.removeObserver(this);
}
//public void getCar(Car car) {
//return all atributes?
//}

public ArrayList GetCarList(){
    return carList;
}

@Override
public void saveState(){

    try{
        FileOutputStream cl = new FileOutputStream("carlist.al");
        ObjectOutputStream os = new ObjectOutputStream(cl);
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
    for (int i = 0; i > carList.size(); i++) // The beginning of a for loop
    {       
        
        if (null != carList.get(i).getStateID()) 
        switch (carList.get(i).getStateID()) {
            case INMOT:
                carList_inMot.add(carList.get(i));
                break;
            case AVAILABLE:
                carList_available.add(carList.get(i));
                break;
            case INREPAIR:
                carList_inRepair.add(carList.get(i));
                break;
            case NEEDSMOT:
                carList_needsMot.add(carList.get(i));
                break;
            case NEEDSREPAIR:
                carList_needsRepair.add(carList.get(i));
                break;
            case NEEDSSERVICE:
                carList_needsService.add(carList.get(i));
                break;
            case ONLOAN:
                carList_onLoan.add(carList.get(i));
                break;
            default:
                break;
        }
    }
    
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