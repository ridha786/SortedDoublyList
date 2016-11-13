import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author Ridha Ali
 *
 */
public class Demo {

	public static void main(String[] args) throws ParseException, ClassNotFoundException {
		
		//Testing the student constructor and the toString method
		Date date = new Date("08/17/1997");
		Student x = new Student( "adam", "bob", 1111, date, "uga");
		Student b = new Student( "james", "bob", 1221, date, "uga");
		Student c = new Student( "ed", "bob", 1331, date, "uga");
		System.out.println(x.toString());
		//testing the person constructor
		Person g = new Person( "adam", "bob", 1111, date);
		Person h = new Person( "sam", "bob", 1661, date);
		Person i = new Person( "wes", "bob", 1771, date);
		
		//testing the add method and printList method
		SortedDblList z = new SortedDblList();
		z.add(2);
		z.add(1);
		z.printList();
		System.out.println("");
		
		SortedDblList y = new SortedDblList();
		y.add(3);
		y.add(1);
		y.add(7);
		y.printList();
		System.out.println("");

		//testing the intersection method 
		SortedDblList m = new SortedDblList();
		m = y.intersection(z);
		m.printList();
		System.out.println("");
		
		//testing the union method
		SortedDblList r = new SortedDblList();
		m = y.union(z);
		m.printList();
		System.out.println("");
		
		
		// testing the remove method
		SortedDblList f = new SortedDblList();
		f.add(4);
		f.add(2);
		f.add(5);
		f.remove(4);
		f.printList();
		System.out.println("");
		
		//testing the indexOf method
		System.out.println(z.indexOf(3));
		System.out.println(z.indexOf(5));
		System.out.println("");
		
		//testing the get method
		System.out.println(z.get(0));
		System.out.println(y.get(2));
		System.out.println("");
		
		//testing the isEmpty method
		System.out.println(z.isEmpty());
		SortedDblList a = new SortedDblList();
		System.out.println(a.isEmpty());
		System.out.println("");
		
		//testing student/Person case of union method
		SortedDblList studentExample = new SortedDblList();
		SortedDblList person = new SortedDblList();
		studentExample.add(x);
		studentExample.add(b);
		studentExample.add(c);
		person.add(g);
		person.add(h);
		person.add(i);
		SortedDblList combined = new SortedDblList();
		combined = studentExample.union(person);
		combined.printList();
		System.out.println("");
		
		//testing student/Person case of intersection method
		SortedDblList intersection = new SortedDblList();
		intersection= studentExample.intersection(person);
		intersection.printList();
		
		
		//test write
		studentExample.writeObject("src/fileName");
		
		//test read
		SortedDblList readTester = new SortedDblList();
		readTester = studentExample.readObject("src/fileName");
		readTester.printList();
		
		
		
		
		
	}

}
