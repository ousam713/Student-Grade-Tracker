import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


public class Student extends JPanel 
{	
	// Instance variables 
	private static final long serialVersionUID = 1L;
//	private JPanel cardPanel;
	private static int count = 1;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
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
	public Student(String firstName,String lastName,String email)
	{
		this.id = String.format("%08d", count);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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
	
	public void setEmail(String email) 
	{
		try 
		{
			if(!email.contains("@"));
			this.email = email;	
		} catch(Exception e) 
		{
			System.out.println("you emial format is not correct!");
		}
	}
	
	public String getEmail() 
	{
		return this.email;
	}
	
	

	// Methods
//	public static void createStd(ArrayList<Student> students) 
//	{
//		try 
//		{
//			
//			
//			Student std = new Student();
//		}catch(Exception e) 
//		{
//			Student std = new Student(null,null,null);
//		}
//		return null;
//	}
//	
//	public static JPanel createAddStudentManu() 
//	{
//		JPanel addStdPanel = new JPanel();
//		addStdPanel.setBackground(null);
//		
//	}
	
				// inner class 
				class AddStudent extends JPanel
				{
					private JPanel cardPanel;
					private JLabel firstNameLabel;
					private JLabel lastNameLabel;
					private JLabel emailLabel;
					private JList branchList; 
					
			//		static 
			//		{
			//			
			//			
			//		}
					
					public AddStudent() 
					{
						cardPanel = new JPanel();
						cardPanel.setBackground(null);
						cardPanel.setLayout(new GridLayout(4,2,20,20));
						firstNameLabel= new JLabel("First name");
						lastNameLabel = new JLabel("Last name");
						emailLabel = new JLabel("Email");
						branchList = new JList<String>();
						
						cardPanel.add(firstNameLabel);
						cardPanel.add(lastNameLabel);
						cardPanel.add(emailLabel);
						cardPanel.add(branchList);
						
					}
					
					public JPanel getAddJPanel() 
					{
						return this;
					}
					
					public static void createAddStudentPanel() 
					{
						
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
	
	public static void searchStudents(ArrayList<Student> students) 
	{
		Student std = StudentHelper.searchStd(students);
		try 
		{
			if(std == null)
			{
				System.out.println("try with another ID.");
			}else 
			{
				System.out.println("\nStudent's ID : "+ std.getId());
				System.out.println("\nFirst name : "+ std.getFirstName());
				System.out.println("\nLast name : "+ std.getLastName());
				System.out.println("\n================================\n");
			}
		}catch(Exception e) 
		{
			System.out.println("Enable to find data");
		}
		
		
	}
	
}












