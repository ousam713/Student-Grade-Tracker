import java.util.HashMap;
import java.util.Map;

public class Student 
{
	private static int count = 1;
	private String id;
	private String firstName;
	private String lastName;
	private Map<String , Float> grades = new HashMap<>();
	private String [] subjects = {"Programming with Java","Mathematics","English"};
	private float avg;
	
	public Student(String firstName,String lastName)
	{
		this.id = String.format("%08d", count);
		this.firstName = firstName;
		this.lastName = lastName;
		count++;
	}
	
	
}
