import java.util.Date;

/**
 * 
 * @author Ridha Ali
 *
 */
public class Student extends Person {
protected String college;
/**
 * 
 * @param firstName
 * @param lastName
 * @param id
 * @param dob
 * @param college
 */

public Student(String firstName, String lastName, int id, Date dob, String college){
	
super(firstName, lastName, id, dob);
this.college = college;

}
/**
 * 
 * @return this returns college
 */

public String getCollege() {
	return college;
}

/**
 * 
 * @param college
 */
public void setCollege(String college) {
	this.college = college;
}
/**
 * 
 */

public String toString(){
	String answer ="";
	answer = super.toString();
	answer += " [" +college + "]";
	return answer;
}
	
}
