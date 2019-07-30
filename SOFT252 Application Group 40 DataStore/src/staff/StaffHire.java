/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import staff.StaffFactory;
import staff.Staff;

/**
 *
 * @author Chris
 */
public class StaffHire extends StaffFactory {
    
    public void HireStaff(String firstname, String secondname, String title){
        StaffFactory factory = new StaffFactory();
        Staff newStaff = factory.createStaff();
        newStaff.setFirstName(firstname);
        newStaff.setLastName(secondname);
        newStaff.setTitle(title);        
    }
    
    
}
