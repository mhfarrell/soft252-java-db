/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

/**
 *
 * @author Chris
 */
public class Person {
    
protected String title;
protected String firstName;
protected String lastName;


public Person(String title, String firstName, String lastName) {
    this.title = title;
    this.firstName = firstName;
    this.lastName = lastName;
}

public Person(){

}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
    
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}
    
}
