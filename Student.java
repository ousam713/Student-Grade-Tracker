import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Student 
{	
	// Instance variables 
	private static int count = 1;
	private String id;
	private String firstName;
	private String lastName;
	private String [] subjects = {"Programming with Java","Mathematics","English"};
	private Map<String , Float>  grades = new HashMap<>();
	private float avg;
	
	
	// Static initialization bloc
	{
        for (String subject : subjects) 
        {
            grades.put(subject, -1.0f); // Initialize each grade to -1 <=> the grades are not input yet
        }
    }
	
	// Constructor
	public Student(String firstName,String lastName)
	{
		this.id = String.format("%08d", count);
		this.firstName = firstName;
		this.lastName = lastName;
		count++;
	}
	
	
	// Getters & Setters
	public String getId() 
	{
		return this.id;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getFirstName() 
	{
		return this.firstName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getLastName() 
	{
		return this.lastName;
	}
	
	

	// Methods
	public static void createStd(ArrayList<Student> students) 
	{
		Scanner in = new Scanner(System.in);
		try 
		{
			System.out.print("enter first name : ");
			String fName = in.nextLine();
			
			System.out.print("enter first name : ");
			String lName = in.nextLine();
			
			in.close();
			
			students.add(new Student(fName, lName));			
			
		} catch(Exception e){
			System.out.println("There is an exception !");
		}
	}

	
	
	public static void updateStd(ArrayList<Student> students) 
	{
		System.out.print("Enter the student's ID : ");
		Scanner in = new Scanner(System.in);
		String idNumber = in.next();
		String ID_to_Search = String.format("%08d", idNumber);
		
		Student student = StudentHelper.searchStd(students);
		
		
		try
		{
			System.out.print("Enter the new firstname: ");
			String newFirstName = in.next();
			System.out.print("Enter the new lastname: ");
			String newLastName = in.next();
			
			student.setFirstName(newFirstName);
			student.setLastName(newLastName);
		} catch(Exception e)
		{
			System.out.println("ERROR : Maybe you enter a wrong type");
		}
			
			
		in.close();
	}

	public static void deleteStd(ArrayList<Student> students)
	{
		Student student = StudentHelper.searchStd(students);
		if(student != null) 
		{
			try 
			{
				students.remove(student);
			} catch(Exception e) 
			{
				System.out.println("ERROR : while trying to delete student!");
			}
		}
	}
	
	
	public static void showStudents(ArrayList<Student> students) 
	{
		for(Student student:students) 
		{
			System.out.println("\nStudent's ID : "+ student.getId());
			System.out.println("\nFirst name : "+ student.getFirstName());
			System.out.println("\nLast name : "+ student.getLastName());
			System.out.println("\n================================\n");
			
		}
	}
	
	public static Student searchStudents(ArrayList<Student> students) 
	{
		Student std = StudentHelper.searchStd(students);
		if(std == null)
		{
			System.out.println("try with another ID");
		}
		return std;
	}
	
}












