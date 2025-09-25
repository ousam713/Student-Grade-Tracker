import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Student extends JPanel 
{	
	// Instance variables 
	private static final long serialVersionUID = 1L;
//	private JPanel cardPanel;
	private static int count = 1;
	private final int id;

	private String firstName;
	private String lastName;
	private String email;
	private String [] subjects = {"Programming with Java","Mathematics","English"};
	private Map<String , Double>  grades = new HashMap<>();
	private float avg;
	
	
	// Static initialization bloc
	{
        for (String subject : subjects) 
        {
            grades.put(subject, -1.0); // Initialize each grade to -1 <=> the grades are not input yet
        }
    }
	
	// Constructor
	public Student(String firstName,String lastName)
	{
		this.id = count;
		this.firstName = firstName;
		this.lastName = lastName;
		count++;
	}
	public Student(String firstName,String lastName,String email)
	{
		this.id = count;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		count++;
	}
	
	
	// Getters & Setters
	public int getId() 
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
	
	
	 // Add grade method
    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
    }
    
    // Get grade method
    public Double getGrade(String subject) {
        return grades.get(subject);
    }
    
    
    // Calculate average grade
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    // Getters and setters...
    public Map<String, Double> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Double> grades) {
        this.grades = grades;
    }
	
}












