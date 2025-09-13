import java.util.ArrayList;
import java.util.Scanner;

public class StudentHelper {
	public static void Go(ArrayList<Student> arr) 
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
		System.out.print("Enter the student's ID : ");
		Scanner in = new Scanner(System.in);
		String idNumber = in.next();
		String ID_to_Search = String.format("%08d", idNumber);
		
		for(Student student : students) 
		{
			if(ID_to_Search.equals(student.getId())) 
			{
				return student;
			}
		}
		
		System.out.println("Student does not found!");
		
		return null;
	}
}

