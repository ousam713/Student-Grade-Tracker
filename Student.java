import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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

	private static String [] subjects = {"Java Programming","Mathematics","English"};
	
	private float avg;
	
    private String firstName, lastName, email;
    private Map<String, Double> grades = new HashMap<>();
    
    
    
	
	// Static initialization bloc
//	{
//        for (String subject : subjects) 
//        {
//            grades.put(subject, -1.0); // Initialize each grade to -1 <=> the grades are not input yet
//        }
//    }
	
	// Constructor
	public Student(String firstName,String lastName,String email)
	{
		this.id = count;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		count++;
	}
	public Student(String firstName,String lastName,String email,double grade1, double grade2, double grade3)
	{
		this.id = count;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.grades.put("Mathematics", grade1);
		this.grades.put("Java Programming", grade2);
		this.grades.put("English", grade3);
		count++;
	}
	
	public static String[] getSubjects () 
	{
		return subjects;
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
    
    public Double getGradeOrdefault(String subject) 
    {
        return grades.getOrDefault(subject, null);
    }
    
    public double getAverage() 
    {
    	if (grades.isEmpty()) return 0.0;
    	double sum = grades.values().stream().mapToDouble(Double::doubleValue).sum();
    	double average = sum / grades.size();
    	return Math.round(average * 100.0) / 100.0;
    }
	
}












