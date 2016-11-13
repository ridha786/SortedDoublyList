import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author Ridha Ali
 *
 */
public class Person implements Comparable<Person> , Serializable {
protected String firstName;
protected String lastName;
protected int id;
protected Date dob;
SimpleDateFormat dt = new SimpleDateFormat("MM-dd-yyyy");
/**
 * 
 */
public Person(){
	
}
/**
 * 
 * @param firstName
 * @param lastName
 * @param id
 * @param dob
 */
public Person(String firstName, String lastName, int id,  Date dob ){
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	if (id>=1000 && id<=9999){
	this.id = id;
	}
	
}
/**
 * 
 * @return this returns firstName
 */
public String getFirstName() {
	return firstName;
}
/**
 * 
 * @param firstName
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

/**
 * 
 * @return this returns lastName
 */
public String getLastName() {
	return lastName;
}

/**
 * 
 * @param lastName
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/**
 * 
 * @return this returns Id
 */
public int getId() {
	return id;
}

/**
 * 
 * @param id
 */
public void setId(int id) {
	if (id>=1000 && id<=9999){
		this.id = id;
		}
}
/**
 * 
 * @return this returns Dob
 */

public Date getDob() {
	return dob;
}
/**
 * 
 * @param dob
 */

public void setDob(Date dob) {
	this.dob = dob;
}

/**
 * 
 */
public String toString(){
	String answer = "";
	String dob1 = dt.format(getDob());
	answer += id + " " +firstName+ " " + lastName + " "+ dob1;
	return answer;
}


public boolean equals(Person o){
	boolean answer = false;
	if (this.id == o.getId()){
		answer = true;
	}
	
	return answer;
}



@Override
/**
 * @param o 
 */
public int compareTo(Person o) {
	int answer = 0;
	if (this.id == o.getId()){
		
	answer = 0;
	}
	if (this.id < o.getId()){
		
		answer =  -1;
		}
	if (this.id > o.getId()){
		
		answer = 1;
		}
	return answer;
	
}




}
