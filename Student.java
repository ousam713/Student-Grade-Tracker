import java.util.HashMap;
import java.util.Map;

public class Student 
{
	private static int count = 0;
	private String id;
	private String firstName;
	private String lastName;
	private Map<String , Float> grades = new HashMap<>();
	private String [] subjects = new {"Programming with Java","Math","English"};
	private float avg;
	
	public Student(int id,String firstName,String lastName)
	{
		this.id = String.format("%06d", count);
		this.firstName = firstName;
		this.lastName = lastName;
		count++;
	}
}
