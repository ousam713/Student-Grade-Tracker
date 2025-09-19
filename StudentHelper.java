import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentHelper {
	public static void factory(ArrayList<Student> arr) 
	{
		arr.add(new Student("Oussama","Benzzi"));
		arr.add(new Student("Layla", "Hassan"));
		arr.add(new Student("Omar", "Khalid"));
		arr.add(new Student("Zayn", "Abbas"));
		arr.add(new Student("Noura", "El-Sayed"));
		arr.add(new Student("Kareem", "Soliman"));
		arr.add(new Student("Jamilah", "Farhat"));
		arr.add(new Student("Tariq", "Nassar"));
		arr.add(new Student("Samira", "Mansour"));
		arr.add(new Student("Idris", "Al-Zahrani"));
	}
	
	public static Student searchStd(ArrayList<Student> students)
	{
		
		if(students.size() == 0) 
		{
			System.out.println("there is no student in the list yet.");
		}
		
		try 
		{
			System.out.print("Enter the student's ID : ");
			Scanner innerIn = new Scanner(System.in);
			int idNumber = innerIn.nextInt();
			String ID_to_Search = String.format("%08d", idNumber);
			
//			innerIn.close();
			
			for(Student student : students) 
			{
				if(ID_to_Search.equals(student.getId())) 
				{
					return student;
				}
			}
			
			System.out.println("Student does not found!");
		}catch(NoSuchElementException e) 
		{
			System.out.println("Error : "+ e);
		}
		
		return null;
	}
}

