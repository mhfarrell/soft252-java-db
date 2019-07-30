/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.time.LocalDate;

/**
 *
 * @author Chris
 */
public interface VehicleState {
    
    
    public void SendRepair();
    public void SendService();
    public void SendMot();
    public void ReturnMot(LocalDate date);
    public void ReturnService(int mileage);
    public void ReturnRepair();
    
}
