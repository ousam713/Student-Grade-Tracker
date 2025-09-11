import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Student 
{	
	private static int count = 1;
	private String id;
	private String firstName;
	private String lastName;
	private Map<String , Float> grades = new HashMap<>();
	private String [] subjects = {"Programming with Java","Mathematics","English"};
	private float avg;
	
	static Scanner in = new Scanner(System.in);
	
	public Student(String firstName,String lastName)
	{
		this.id = String.format("%08d", count);
		this.firstName = firstName;
		this.lastName = lastName;
		count++;
	}

	public static void CreateStd() 
	{
		try 
		{
			System.out.print("enter first name : ");
			String fName = in.nextLine();
			
			System.out.print("enter first name : ");
			String lName = in.nextLine();
			
		} catch(Exception e){
			System.out.println("");
		}
	}

	public static void UpdateStd() 
	{
		
	}

	public static void DeleteStd() 
	{
		
	}
	
	
}
