import java.util.NoSuchElementException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentHelper {
	public static void factory(ArrayList<Student> arr) 
	{

		Random random = new Random();

		arr.add(new Student("Oussama","Benzzi","oussama@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

		arr.add(new Student("Layla", "Hassan","layla@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

		arr.add(new Student("Omar", "Khalid","omar@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

		arr.add(new Student("Zayn", "Abbas","zayn@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

		arr.add(new Student("Noura", "El-Sayed","noura@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

		arr.add(new Student("Kareem", "Soliman","kareem@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

		arr.add(new Student("Jamilah", "Farhat","jamilah@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

		arr.add(new Student("Tariq", "Nassar","tariq@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

		arr.add(new Student("Samira", "Mansour","samira@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

		arr.add(new Student("Idris", "Al-Zahrani","idris@gmail.com",
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0,
		        Math.round(random.nextDouble() * 100 * 100.0) / 100.0));

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

