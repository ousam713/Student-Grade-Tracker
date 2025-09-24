import java.awt.EventQueue;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainJFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private static ArrayList<Student> students = new ArrayList<>();
	

	public ArrayList<Student> getStudents(ArrayList<Student> st_u_dents)
	{
		return st_u_dents;
	}
	
	public Student getStudent(int idWanted)
	{
		Student student = null;
		try 
		{
			for(Student std:students) 
			{
				if(std.getId() == idWanted) 
				{
					student = std;
					break;
				}
			}
		}catch(Exception e) 
		{
			System.out.println("std not found");
		}
		return student;
	}
	
	public static void addStudent (Student std)
	{
		students.add(std);
	}
	
	public void modifyStudent (int id, String firstName,String lastName,String email)
	{
		students.get(id).setFirstName(firstName);
		students.get(id).setLastName(lastName);
		students.get(id).setEmail(email);
	}
	
	public void deleteStudent (int id)
	{
		int i=0;
		for(Student std:students) 
		{
			if(std.getId() == id) {
				students.remove(i);
			}
			i++;
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		 
		
		StudentHelper.factory(students);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainJFrame() 
	{
		setTitle("Student Managemnt System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 740);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout());
		
		JLabel imageLogo = new JLabel(new ImageIcon("icons/SMS.png"));
		contentPane.add(imageLogo, BorderLayout.NORTH);
		
//		<< create JPanel : manuPanel
		JPanel manuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
//		manuPanel.setSize(300,300);
		
//		<< << create JPanel : cardPanel
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.setBackground(null);
//		cardPanel.setSize();
		


		
//		<< << create JPanel : manuContainerPanel
		// TODO 1 : add  JLayeredPanel to solve Labels problem (it must contain manuSubPanel and labelContainerPanel a JPanel that has an ABSOLUTE LM)
		/*
		
		JLayeredPane manuContainerPanel = new JLayeredPane();
		manuPanel.add(manuContainerPanel, BorderLayout.CENTER); 
		
		*/
//		>> >> add JPanel : manuSubPanel
		
		
//		<< << << create JPanel : manuSubPanel
		JPanel manuSubPanel = getMainManuPanel();
		cardPanel.add(manuSubPanel, "MainManu");
//		>> >> >> add JPanel : manuSubPanel
		
		
//		<< << << create JPanel : manageStdPanel
		JPanel manageStdPanel = getStudentManu();
		cardPanel.add(manageStdPanel, "ManageStudentManu");
//		>> >> >> add JPanel : manageStdPanel
		
//		<< << << create JPanel : addStdPanel
		JPanel addStdPanel = getAddStudentPanel();
		cardPanel.add(addStdPanel, "AddStudentPanel");
//		>> >> >> add JPanel : addStdPanel
		
//		<< << << create JPanel : modifyStdPanel
		JPanel modifyStdPanel = getModefyStudentPanel();
		cardPanel.add(modifyStdPanel, "ModifyStudentPanel");
//		>> >> >> add JPanel : modifyStdPanel
		
//		<< << << create JPanel : modifyStdPanel
		JPanel deleteStdPanel = getDeleteStudentPanel();
		cardPanel.add(deleteStdPanel, "DeleteStudentPanel");
//		>> >> >> add JPanel : modifyStdPanel
		
		
//		<< << << create JPanel : modifyStdPanel
		JPanel searchStdPanel = getSearchStudentPanel();
		cardPanel.add(searchStdPanel, "SearchStudentPanel");
//		>> >> >> add JPanel : modifyStdPanel
		
//		<< << << create JPanel : modifyStdPanel
//		JPanel deleteStdPanel = getDeleteStudentPanel();
//		cardPanel.add(deleteStdPanel, "DeleteStudentPanel");
//		>> >> >> add JPanel : modifyStdPanel
		
//		<< << << create JPanel : addStdPanel
//		JPanel addStdPanel = Student.createAddStudentManu();
//		cardPanel.add(addStdPanel, "AddStudent");
//		>> >> >> add JPanel : addStdPanel
		
		
		manuPanel.add(cardPanel, BorderLayout.CENTER);
//		>> >> add JPanel : cardPanel
		

		
		getContentPane().add(manuPanel, BorderLayout.CENTER);
//		>> add JPanel : manuPanel
		cardLayout.show(cardPanel, "MainMenu");
		
	}
	
	public ImageIcon getResizedIcon(String path) 
	{
		try 
		{
			Image originalIcon= new ImageIcon(path)
									.getImage()
									.getScaledInstance(130, 110, Image.SCALE_SMOOTH);
			ImageIcon resizedIcon = new ImageIcon(originalIcon);
			
			return resizedIcon;
		} catch(Exception e) 
		{
			System.out.println("unable to lorad images");
			return null;
		}
	}
	
	public void removeMarginBtn(JButton btn, ImageIcon icon) 
	{
		btn.setBackground(SystemColor.inactiveCaptionBorder);
		btn.setMargin(new Insets(0,0,0,0));
		btn.setBorder(null);
		btn.setBorderPainted(false);
		if (icon != null) {
	        btn.setPreferredSize(new Dimension(icon.getIconWidth()+100, icon.getIconHeight()+30));
	    }
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private JPanel getMainManuPanel() 
	{
		JPanel manuSubPanel = new JPanel();
		manuSubPanel.setBackground(null);
		manuSubPanel.setLayout(new GridLayout(2,2,20,20));
		
		
		ImageIcon icon1 = getResizedIcon("icons/manage_std.png");
		JButton manageStdBtn = new JButton(icon1);
		removeMarginBtn(manageStdBtn,icon1);
		manageStdBtn.addActionListener(event->{
			cardLayout.show(cardPanel, "ManageStudentManu");
		});
		//
		ImageIcon icon2 = getResizedIcon("icons/search_std.png");
		JButton searchStdBtn = new JButton(icon2);
		removeMarginBtn(searchStdBtn,icon1);
		
		ImageIcon icon3 = getResizedIcon("icons/manage_grades.png");
		JButton manageGradesBtn = new JButton(icon3);
		removeMarginBtn(manageGradesBtn,icon1);
		
		ImageIcon icon4 = getResizedIcon("icons/statistic.png");
		JButton statisticBtn = new JButton(icon4);
		removeMarginBtn(statisticBtn,icon1);
		
		
		manuSubPanel.add(manageStdBtn);
		manuSubPanel.add(searchStdBtn);
		manuSubPanel.add(manageGradesBtn);
		manuSubPanel.add(statisticBtn);
		
		return manuSubPanel;
	}
	
	private JPanel getStudentManu() 
	{
		JPanel manageStdPanel = new JPanel();
		manageStdPanel.setBackground(null);
		manageStdPanel.setLayout(new GridLayout(2,2,20,20));
		
		
		ImageIcon icon1_1 = getResizedIcon("icons/add_std.png");
		JButton addStdBtn = new JButton(icon1_1);
		removeMarginBtn(addStdBtn,icon1_1);
		addStdBtn.addActionListener(e->{
				cardLayout.show(cardPanel, "AddStudentPanel");
		});
		
		ImageIcon icon1_2 = getResizedIcon("icons/modify_std.png");
		JButton modefyStdBtn = new JButton(icon1_2);
		removeMarginBtn(modefyStdBtn,icon1_2);
		modefyStdBtn.addActionListener(e->{
			cardLayout.show(cardPanel, "ModifyStudentPanel");
	});
//		ModifyStudentPanel
		
		ImageIcon icon1_3 = getResizedIcon("icons/delete_std.png");
		JButton deleteStdBtn = new JButton(icon1_3);
		removeMarginBtn(deleteStdBtn,icon1_3);
		deleteStdBtn.addActionListener(e->{
			cardLayout.show(cardPanel, "DeleteStudentPanel");

			

	});
		
		
		JButton returnBtn = new JButton("Retrun back");
		returnBtn.addActionListener(event->{
			cardLayout.show(cardPanel, "MainManu");
		});
		removeMarginBtn(returnBtn,null);
		
		
		manageStdPanel.add(addStdBtn);
		manageStdPanel.add(modefyStdBtn);
		manageStdPanel.add(deleteStdBtn);
		manageStdPanel.add(returnBtn);
		
		return manageStdPanel;
	}	
	
		
	public JPanel getAddStudentPanel() 
	{
        JPanel addStdPanel = new JPanel();
        addStdPanel.setBackground(null);
        addStdPanel.setLayout(new GridLayout(5, 1, 20, 0));

        // Article 1
        JPanel article1 = new JPanel(new BorderLayout(10, 5));
        article1.setBackground(null);

        JLabel firstNameLabel = new JLabel("First name:");
        firstNameLabel.setPreferredSize(new Dimension(100, 30));
        JTextField firstNameField = new JTextField();
        
        firstNameField.setFont(new Font("Serif", Font.BOLD, 14));

        article1.add(firstNameLabel, BorderLayout.WEST);
        article1.add(firstNameField, BorderLayout.CENTER);
        article1.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        article1.add(Box.createHorizontalStrut(50), BorderLayout.EAST);

        // Article 2
        JPanel article2 = new JPanel(new BorderLayout(10, 5));
        article2.setBackground(null);

        JLabel lastNameLabel = new JLabel("Last name:");
        lastNameLabel.setPreferredSize(new Dimension(100, 30));
        JTextField lastNameField = new JTextField();
        
        lastNameField.setFont(new Font("Serif", Font.BOLD, 14));

        article2.add(lastNameLabel, BorderLayout.WEST);
        article2.add(lastNameField, BorderLayout.CENTER);
        article2.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        article2.add(Box.createHorizontalStrut(50), BorderLayout.EAST);

        // Article 3
        JPanel article3 = new JPanel(new BorderLayout(10, 5));
        article3.setBackground(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setPreferredSize(new Dimension(100, 30));
        JTextField emailField = new JTextField();
        
        emailField.setFont(new Font("Serif", Font.BOLD, 14));

        article3.add(emailLabel, BorderLayout.WEST);
        article3.add(emailField, BorderLayout.CENTER);
        article3.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        article3.add(Box.createHorizontalStrut(50), BorderLayout.EAST);

        // Article 4
        JPanel article4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        article4.setBackground(null);

        JButton submitBtn = new JButton("Submit");
        JButton returnBtn = new JButton("Return");
        
        submitBtn.addActionListener(e->{
        	String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String email = emailField.getText();
        	if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) 
        	{
        		JOptionPane.showMessageDialog(cardPanel, 
                        "Please fill in all fields", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
        	} else 
        	{
        		addStudent(new Student(firstName,lastName,email));
                JOptionPane.showMessageDialog(cardPanel, 
                    "Student added successfully!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
                
                for(Student std: students) 
                {
                	System.out.println(std.getId() + " " +std.getLastName());
                }
        	}
        });
        returnBtn.addActionListener(e->{
        	cardLayout.show(cardPanel, "ManageStudentManu");
        }); 

        article4.add(submitBtn);
        article4.add(returnBtn);

        // Add all articles to main panel
        addStdPanel.add(article1);
        addStdPanel.add(article2);
        addStdPanel.add(article3);
        addStdPanel.add(article4);

        return addStdPanel;
    }
	
	
	
	public JPanel getModefyStudentPanel() 
	{
        JPanel modefyStdPanel = new JPanel();
        modefyStdPanel.setBackground(null);
        modefyStdPanel.setLayout(new GridLayout(5, 1, 20, 0));

        
     // Article 0
        JPanel article0 = new JPanel();
        article0.setPreferredSize(new Dimension(article0.getPreferredSize().width, 40)); // Fixed height
        article0.setBackground(null);

        JLabel idLabel = new JLabel("Student's id:");
        idLabel.setPreferredSize(new Dimension(100, 30));
        
        JTextField idField = new JTextField();
        idField.setFont(new Font("Serif", Font.BOLD, 14));
        idField.setPreferredSize(new Dimension(200, 30));
        
        JButton searchBtn = new JButton("search");
        searchBtn.setPreferredSize(new Dimension(100, 30));
        
        
        article0.add(idLabel, BorderLayout.WEST);
        article0.add(idField, BorderLayout.CENTER);
        article0.add(searchBtn, BorderLayout.EAST);
        
//        article0.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
//        article0.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
        
        // Article 1
        JPanel article1 = new JPanel(new BorderLayout(10, 5));
        article1.setBackground(null);

        JLabel firstNameLabel = new JLabel("First name:");
        firstNameLabel.setPreferredSize(new Dimension(100, 30));
        JTextField firstNameField = new JTextField();
        
        firstNameField.setFont(new Font("Serif", Font.BOLD, 14));

        article1.add(firstNameLabel, BorderLayout.WEST);
        article1.add(firstNameField, BorderLayout.CENTER);
        article1.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        article1.add(Box.createHorizontalStrut(50), BorderLayout.EAST);

        // Article 2
        JPanel article2 = new JPanel(new BorderLayout(10, 5));
        article2.setBackground(null);

        JLabel lastNameLabel = new JLabel("Last name:");
        lastNameLabel.setPreferredSize(new Dimension(100, 30));
        JTextField lastNameField = new JTextField();
        
        lastNameField.setFont(new Font("Serif", Font.BOLD, 14));

        article2.add(lastNameLabel, BorderLayout.WEST);
        article2.add(lastNameField, BorderLayout.CENTER);
        article2.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        article2.add(Box.createHorizontalStrut(50), BorderLayout.EAST);

        // Article 3
        JPanel article3 = new JPanel(new BorderLayout(10, 5));
        article3.setBackground(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setPreferredSize(new Dimension(100, 30));
        JTextField emailField = new JTextField();
        
        emailField.setFont(new Font("Serif", Font.BOLD, 14));

        article3.add(emailLabel, BorderLayout.WEST);
        article3.add(emailField, BorderLayout.CENTER);
        article3.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        article3.add(Box.createHorizontalStrut(50), BorderLayout.EAST);

        // Article 4
        JPanel article4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        article4.setBackground(null);

        JButton submitBtn = new JButton("Submit");
        JButton returnBtn = new JButton("Return");
         

        article4.add(submitBtn);
        article4.add(returnBtn);

        article1.setVisible(false);
        article2.setVisible(false);
        article3.setVisible(false);
        article4.setVisible(true);
        
        searchBtn.addActionListener(e->{
//        	String idStr = idField.getText();
//        	int id = Integer.parseInt(idStr);
//        	Student student = getStudent(id);
        	try {
        	    String idStr = idField.getText().trim();
        	    int id = Integer.parseInt(idStr);
        	    Student student = getStudent(id);
        	    
        	    if (student != null) {
        	        // Student found - populate fields or show info
        	        firstNameField.setText(student.getFirstName());
        	        lastNameField.setText(student.getLastName());
        	        emailField.setText(student.getEmail());
        	        
        	        
        	        article1.setVisible(true);
        	        article2.setVisible(true);
        	        article3.setVisible(true);
        	        article4.setVisible(true);
        	    } else {
        	        JOptionPane.showMessageDialog(this, "Student with ID " + id + " not found", 
        	                                    "Not Found", JOptionPane.WARNING_MESSAGE);
        	    }
        	} catch (NumberFormatException ex) {
        	    JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID", 
        	                                "Invalid ID", JOptionPane.ERROR_MESSAGE);
        	}
        });
        
        
        
        submitBtn.addActionListener(e->{
        	String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String email = emailField.getText();
        	if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) 
        	{
        		JOptionPane.showMessageDialog(cardPanel, 
                        "Please fill in all fields", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
        	} else 
        	{
        		String idStr = idField.getText().trim();
        	    int id = Integer.parseInt(idStr);
        	    Student student = getStudent(id);
        	    
//        	    student.setFirstName(student.getFirstName());
//        	    student.setLastName(student.getLastName());
//        	    student.setEmail(student.getEmail());
        	    
                JOptionPane.showMessageDialog(cardPanel, 
                    "Student added successfully!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                student.setFirstName(firstNameField.getText());
                student.setLastName(lastNameField.getText());
                student.setEmail(emailField.getText());
                
                for(Student std: students) 
                {
                	System.out.println(std.getLastName());
                }
        	}
        });
        returnBtn.addActionListener(e->{
        	cardLayout.show(cardPanel, "ManageStudentManu");
        });
        
        // Add all articles to main panel
        modefyStdPanel.add(article0);
        modefyStdPanel.add(article1);
        modefyStdPanel.add(article2);
        modefyStdPanel.add(article3);
        modefyStdPanel.add(article4);

        return modefyStdPanel;
    }
	
	
	// TODO 2 reimplement this: 
	public JPanel getSearchStudentPanel() 
	{		
        JPanel searchStdPanel = new JPanel();
        searchStdPanel.setBackground(null);
        searchStdPanel.setLayout(new GridLayout(4, 1, 20, 0));

        // Article 1
        JPanel article1 = new JPanel(new BorderLayout(10, 5));
        article1.setBackground(null);

        JLabel idLabel = new JLabel("STUDENT'S id:");
        idLabel.setPreferredSize(new Dimension(100, 30));
        JTextField idField = new JTextField();
        
        idField.setFont(new Font("Serif", Font.BOLD, 14));

        article1.add(idLabel, BorderLayout.WEST);
        article1.add(idField, BorderLayout.CENTER);
        article1.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        article1.add(Box.createHorizontalStrut(50), BorderLayout.EAST);


        // Article 4
        JPanel article4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        article4.setBackground(null);

        JButton submitBtn = new JButton("Submit");
        JButton returnBtn = new JButton("Return");
        
        submitBtn.addActionListener(e->{
        	String id = idField.getText();
        	if(id.isEmpty()) 
        	{
        		JOptionPane.showMessageDialog(cardPanel, 
                        "Please fill in all fields", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
        	} else 
        	{
        		
                JOptionPane.showMessageDialog(cardPanel, 
                    "Student searchd successfully!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                idField.setText("");
                
                for(Student std: students) 
                {
                	System.out.println(std.getLastName());
                }
        	}
        });
        returnBtn.addActionListener(e->{
        	cardLayout.show(cardPanel, "ManageStudentManu");
        }); 

        article4.add(submitBtn);
        article4.add(returnBtn);

        // Add all articles to main panel
        searchStdPanel.add(article1);
        searchStdPanel.add(article4);

        return searchStdPanel;
    }
	
	
	
	
	
	public JPanel getDeleteStudentPanel() 
	{
		JPanel modefyStdPanel = new JPanel();
        modefyStdPanel.setBackground(null);
        modefyStdPanel.setLayout(new GridLayout(5, 1, 20, 0));
        
        
     // Article 0
        JPanel article0 = new JPanel();
        article0.setPreferredSize(new Dimension(article0.getPreferredSize().width, 40)); // Fixed height
        article0.setBackground(null);

        JLabel idLabel = new JLabel("Student's id:");
        idLabel.setPreferredSize(new Dimension(100, 30));
        
        JTextField idField = new JTextField();
        idField.setFont(new Font("Serif", Font.BOLD, 14));
        idField.setPreferredSize(new Dimension(225, 30));
        
        JButton searchBtn = new JButton("search");
        searchBtn.setPreferredSize(new Dimension(100, 30));
        
        
        article0.add(idLabel, BorderLayout.WEST);
        article0.add(idField, BorderLayout.CENTER);
//        article0.add(searchBtn, BorderLayout.EAST);
        
//        article0.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
//        article0.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
        

        // Article 4
        JPanel article4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        article4.setBackground(null);

        JButton deleteBtn = new JButton("Delete");
        JButton returnBtn = new JButton("Return");
         

        article4.add(deleteBtn);
        article4.add(returnBtn);

        article4.setVisible(true);
        
        
        
        
        deleteBtn.addActionListener(e->{
        	String idStr = idField.getText().trim();

    	    if (idStr != null && !idStr.trim().isEmpty()) {
    	        try {
    	            int id = Integer.parseInt(idStr);
    	            id--;
    	            // Check if student exists
    	            if (id >= 0 && id < students.size()) {
    	                Student studentToDelete = students.get(id);
    	                
// Confirm deletion
    	                int confirm = JOptionPane.showConfirmDialog(
    	                    cardPanel,
    	                    "Are you sure you want to delete:\n" +
    	                    studentToDelete.getFirstName() + " " + studentToDelete.getLastName() + "?",
    	                    "Confirm Deletion", 
    	                    JOptionPane.YES_NO_OPTION,
    	                    JOptionPane.WARNING_MESSAGE
    	                );
    	                
    	                if (confirm == JOptionPane.YES_OPTION) {
    	                    // Delete from ArrayList
    	                    students.remove(id);
    	                    
    	                    JOptionPane.showMessageDialog(
    	                        cardPanel,
    	                        "Student deleted successfully!",
    	                        "Success",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                    );
    	                    
    	                    // Print remaining students for verification
    	                    System.out.println("Remaining students:");
    	                    for(Student std : students) {
    	                        System.out.println("ID: " + students.indexOf(std) + 
    	                                         " - " + std.getFirstName() + " " + std.getLastName());
    	                    }
    	                }
    	            } else {
    	                JOptionPane.showMessageDialog(
    	                    cardPanel,
    	                    "Student with ID " + id + " not found!",
    	                    "Error",
    	                    JOptionPane.ERROR_MESSAGE
    	                );
    	            }
    	        } catch (NumberFormatException ex) {
    	            JOptionPane.showMessageDialog(
    	                cardPanel,
    	                "Please enter a valid numeric ID",
    	                "Error",
    	                JOptionPane.ERROR_MESSAGE
    	            );
    	        }
    	    }
        });
        returnBtn.addActionListener(e->{
        	cardLayout.show(cardPanel, "ManageStudentManu");
        });
        
        modefyStdPanel.add(article0);
        modefyStdPanel.add(article4);

        return modefyStdPanel;


	}

}


