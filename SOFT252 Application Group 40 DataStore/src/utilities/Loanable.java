/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.time.LocalDate;
import staff.Staff;

/**
 *
 * @author Chris
 */
public interface Loanable {
    
    public void LoanVehicle(LocalDate date, Staff staff);
    public void ReturnVehicle(int miles);
    public void LoanVehiclePermanent(Staff staff);
    
    
}
