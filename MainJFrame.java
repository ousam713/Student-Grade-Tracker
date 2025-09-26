import java.awt.EventQueue;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
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
		
//		 add JPanel : cardPanel
		JPanel manuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
//		manuPanel.setSize(300,300);
		
//		<< create JPanel : cardPanel
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
		
		
//		<< <<  create JPanel : manuSubPanel
		JPanel manuSubPanel = getMainManuPanel();
		cardPanel.add(manuSubPanel, "MainManu");
//		>> >>  add JPanel : manuSubPanel
		
		
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
		JPanel gradesStdPanel = createManageGradesPanel();
		cardPanel.add(gradesStdPanel, "ManageGradesPanel");
//		>> >> >> add JPanel : modifyStdPanel
		
//		<< <<  create JPanel : statistcsPanel
		JPanel statistcsPanel = getStatsticsPanel();
		cardPanel.add(statistcsPanel, "StatisticsPanel");
//		>> >>  add JPanel : statistcsPanel
		
		
		manuPanel.add(cardPanel, BorderLayout.CENTER);
//		>> add JPanel : cardPanel
		
		
//		<< add JPanel : manuPanel
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
		searchStdBtn.addActionListener(e->{
			cardLayout.show(cardPanel, "SearchStudentPanel");
		});
		
		ImageIcon icon3 = getResizedIcon("icons/manage_grades.png");
		JButton manageGradesBtn = new JButton(icon3);
		removeMarginBtn(manageGradesBtn,icon1);
		manageGradesBtn.addActionListener(e->{
			cardLayout.show(cardPanel, "ManageGradesPanel");
		});
		
		ImageIcon icon4 = getResizedIcon("icons/statistic.png");
		JButton statisticBtn = new JButton(icon4);
		removeMarginBtn(statisticBtn,icon1);
		statisticBtn.addActionListener(e->{
			cardLayout.show(cardPanel, "StatisticsPanel");
		});
		
		
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
        	article1.setVisible(false);
            article2.setVisible(false);
            article3.setVisible(false);
        	
        	idField.setText("");
        	firstNameField.setText("");
	        lastNameField.setText("");
	        emailField.setText("");
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
//        article0.add(searchBtn, BorderLayout.EAST);
        
        
        // Article 1
        JPanel article1 = new JPanel(new BorderLayout(10, 5));
        article1.setBackground(null);

        JLabel firstNameLabel = new JLabel("First name:");
        firstNameLabel.setPreferredSize(new Dimension(100, 30));
        JTextField firstNameField = new JTextField();
        
        firstNameField.setFont(new Font("Serif", Font.BOLD, 14));
        firstNameField.setEditable(false);

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
        lastNameField.setEditable(false);

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
        emailField.setEditable(false);
        
        emailField.setFont(new Font("Serif", Font.BOLD, 14));

        article3.add(emailLabel, BorderLayout.WEST);
        article3.add(emailField, BorderLayout.CENTER);
        article3.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        article3.add(Box.createHorizontalStrut(50), BorderLayout.EAST);

        // Article 4
        JPanel article4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        article4.setBackground(null);

        JButton returnBtn = new JButton("Return");
        returnBtn.setPreferredSize(new Dimension(100, 30));

        article4.add(searchBtn);
        article4.add(returnBtn);

        article1.setVisible(false);
        article2.setVisible(false);
        article3.setVisible(false);
        article4.setVisible(true);
        
        searchBtn.addActionListener(e->{
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
        	    } else {
        	        JOptionPane.showMessageDialog(this, "Student with ID " + id + " not found", 
        	                                    "Not Found", JOptionPane.WARNING_MESSAGE);
        	    }
        	} catch (NumberFormatException ex) {
        	    JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID", 
        	                                "Invalid ID", JOptionPane.ERROR_MESSAGE);
        	}
        });
        
        returnBtn.addActionListener(e->{
        	idField.setText("");
        	firstNameField.setText("");
	        lastNameField.setText("");
	        emailField.setText("");
	        
	        article1.setVisible(false);
	        article2.setVisible(false);
	        article3.setVisible(false);
        	cardLayout.show(cardPanel, "MainManu");
        });

        
        // Add all articles to main panel
        modefyStdPanel.add(article0);
        modefyStdPanel.add(article1);
        modefyStdPanel.add(article2);
        modefyStdPanel.add(article3);
        modefyStdPanel.add(article4);

        return modefyStdPanel;
    }
	
	
	
	public JPanel getDeleteStudentPanel() 
	{
		JPanel modefyStdPanel = new JPanel();
        modefyStdPanel.setBackground(null);
        modefyStdPanel.setLayout(new GridLayout(5, 1, 20, 0));
        
        
     // Article 0
        JPanel article0 = new JPanel();
        article0.setPreferredSize(new Dimension(article0.getPreferredSize().width, 40));
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
    	            int id = Integer.parseInt(idStr)-1;
//    	            id--;

    	            if (id >= 0 && id < students.size()) {
    	                Student studentToDelete = students.get(id);
    	                
    	                int confirm = JOptionPane.showConfirmDialog(
    	                    cardPanel,
    	                    "Are you sure you want to delete:\n" +
    	                    studentToDelete.getFirstName() + " " + studentToDelete.getLastName() + "?",
    	                    "Confirm Deletion", 
    	                    JOptionPane.YES_NO_OPTION,
    	                    JOptionPane.WARNING_MESSAGE
    	                );
    	                
    	                if (confirm == JOptionPane.YES_OPTION) {

    	                    students.remove(id);
    	                    
    	                    JOptionPane.showMessageDialog(
    	                        cardPanel,
    	                        "Student deleted successfully!",
    	                        "Success",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                    );
    	                    
    	                    System.out.println("Remaining students:");
    	                    for(Student std : students) {
    	                        System.out.println("ID: " + std.getId() + 
    	                                         " - " + std.getFirstName() + " " + std.getLastName());
    	                    }
    	                }
    	            } else {
    	            	id++;
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
        	idField.setText("");
        	cardLayout.show(cardPanel, "ManageStudentManu");
        });
        
        modefyStdPanel.add(article0);
        modefyStdPanel.add(article4);

        return modefyStdPanel;
	}
	
	
	
	

	private JPanel createManageGradesPanel() 
	{
	    JPanel gradesPanel = new JPanel(new BorderLayout(40, 10));
	    gradesPanel.setBackground(null);

	    // Title
	    JLabel titleLabel = new JLabel("Manage Student Grades", JLabel.CENTER);
	    titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
	    gradesPanel.add(titleLabel, BorderLayout.NORTH);

// 		<< Main content panel
	    JPanel contentPanel = new JPanel(new GridLayout(4, 1, 10, 60));
	    contentPanel.setBackground(null);

	    
//		<< << Student selection
	    JPanel studentPanel = new JPanel(new BorderLayout(10, 5));
	    studentPanel.setBackground(null);
	    JLabel studentLabel = new JLabel("Select student:");
	    studentLabel.setPreferredSize(new Dimension(120, 30));
	    
	    // Create dropdown of students
	    JComboBox<String> studentComboBox = new JComboBox<>();
	    studentComboBox.setMaximumSize(new Dimension(250, 30));
	    updateStudentComboBox(studentComboBox); // Method to populate dropdown
	    
	    studentPanel.add(studentLabel, BorderLayout.WEST);
	    studentPanel.add(studentComboBox, BorderLayout.CENTER);
//	    >> >> Student Selection

	    
// 		<< << Subject selection
	    JPanel subjectPanel = new JPanel(new BorderLayout(10, 5));
	    subjectPanel.setBackground(null);
	    JLabel subjectLabel = new JLabel("Select subject:");
	    subjectLabel.setPreferredSize(new Dimension(120, 30));
	    
	    JComboBox<String> subjectComboBox = new JComboBox<>();
	    subjectComboBox.setMaximumSize(new Dimension(250, 30));
	    updateSubjectComboBox(subjectComboBox);
	    
//	    JTextField subjectField = new JTextField();
	    subjectPanel.add(subjectLabel, BorderLayout.WEST);
	    subjectPanel.add(subjectComboBox, BorderLayout.CENTER);
	    
//	    >> >> Subject selection
	    
	    
// 		<< << Grade input
	    JPanel gradePanel = new JPanel(new BorderLayout(10, 5));
	    gradePanel.setBackground(null);
	    JLabel gradeLabel = new JLabel("Grade (0-100):");
	    gradeLabel.setPreferredSize(new Dimension(120, 30));
	    JTextField gradeField = new JTextField();
	    gradeField.setFont(new Font("Serif", Font.BOLD, 16));
	    gradeField.setPreferredSize(new Dimension(100,20));
	    gradePanel.add(gradeLabel, BorderLayout.WEST);
	    gradePanel.add(gradeField, BorderLayout.CENTER);
//	    >> >> Grade input

//   	<< << Buttons
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
	    buttonPanel.setBackground(null);
	    
	    JButton addGradeBtn = new JButton("Add Grade");
	    JButton viewGradesBtn = new JButton("View Grades");
	    JButton returnBtn = new JButton("Return to Main Menu");

	    buttonPanel.add(addGradeBtn);
	    buttonPanel.add(viewGradesBtn);
	    buttonPanel.add(returnBtn);
//	    >> >> Buttons
	    
	    // Add all panels to content
	    contentPanel.add(studentPanel);
	    contentPanel.add(subjectPanel);
	    contentPanel.add(gradePanel);
	    contentPanel.add(buttonPanel);

	    gradesPanel.add(contentPanel, BorderLayout.CENTER);
//	    >> Main content panel

	    // Button actions
	    addGradeBtn.addActionListener(e -> {
	        addGradeToStudent(studentComboBox, subjectComboBox, gradeField);
	    });
	    
	    viewGradesBtn.addActionListener(e -> {
	        viewStudentGrades(studentComboBox);
	    });
	    
	    returnBtn.addActionListener(e -> {
	        cardLayout.show(cardPanel, "MainManu");
	    });

	    return gradesPanel;
	}
	
	
	

	
	private void updateStudentComboBox(JComboBox<String> comboBox) 
	{
	    comboBox.removeAllItems();
	    for (Student student : students) 
	    {
	        String displayText = student.getFirstName() + " " + student.getLastName() + 
	                           " (ID: " + student.getId() + ")";
	        comboBox.addItem(displayText);
	    }
	}
	
	private void updateSubjectComboBox(JComboBox<String> comboBox) 
	{
	    comboBox.removeAllItems();
	    for (String subject : Student.getSubjects()) 
	    {
	        String displayText = subject; 
	        comboBox.addItem(displayText);
	    }
	}

	private void addGradeToStudent(JComboBox<String> studentComboBox, JComboBox<String> subjectComboBox, JTextField gradeField) 
	{
	    int subjectAtAt = subjectComboBox.getSelectedIndex();
	    String subject = Student.getSubjects()[subjectAtAt];
	    String gradeStr = gradeField.getText().trim();
	    
	    if (subject.isEmpty() || gradeStr.isEmpty()) {
	        JOptionPane.showMessageDialog(cardPanel, "Please fill in both subject and grade", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    try {
	        double grade = Double.parseDouble(gradeStr);
	        
	        if (grade < 0 || grade > 100) 
	        {
	            JOptionPane.showMessageDialog(cardPanel, "Grade must be between 0 and 100", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        
	        // Get selected student
	        int selectedStudentIndex = studentComboBox.getSelectedIndex();
	        if (selectedStudentIndex >= 0 && selectedStudentIndex < students.size()) {
	            Student student = students.get(selectedStudentIndex);
	            student.addGrade(subject, grade);
	            
	            JOptionPane.showMessageDialog(cardPanel, 
	                "Grade added successfully!\n" +
	                "Student: " + student.getFirstName() + " " + student.getLastName() + "\n" +
	                "Subject: " + subject + "\n" +
	                "Grade: " + grade, 
	                "Success", 
	                JOptionPane.INFORMATION_MESSAGE);
	            
	            // Clear fields
	            gradeField.setText("");
	        }
	    } catch (NumberFormatException e) 
	    {
	        JOptionPane.showMessageDialog(cardPanel, "Please enter a valid number for grade", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	

	private void viewStudentGrades(JComboBox<String> studentComboBox) 
	{
	    int selectedStudentIndex = studentComboBox.getSelectedIndex();
	    if (selectedStudentIndex >= 0 && selectedStudentIndex < students.size()) 
	    {
	        Student student = students.get(selectedStudentIndex);
	        Map<String, Double> grades = student.getGrades();
	        
	        if (grades.isEmpty()) 
	        {
	            JOptionPane.showMessageDialog(cardPanel, "No grades found for this student", "Info", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	        
	        StringBuilder gradesText = new StringBuilder();
	        gradesText.append("Grades for ").append(student.getFirstName()).append(" ").append(student.getLastName()).append(":\n\n");
	        
	        for (Map.Entry<String, Double> entry : grades.entrySet()) 
	        {
	            gradesText.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
	        }
	        
	        gradesText.append("\nAverage Grade: ").append(String.format("%.2f", student.getAverageGrade()));
	        
	        JOptionPane.showMessageDialog(cardPanel, gradesText.toString(), "Student Grades", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
	
	/////////////////// 2. create statistics panel
	
	public JPanel getStatsticsPanel() 
	{
		JPanel statsPanel = new JPanel(new BorderLayout(10, 10));
	    statsPanel.setBackground(null);

	    // Title
	    JLabel titleLabel = new JLabel("Student Statistics", JLabel.CENTER);
	    titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
	    statsPanel.add(titleLabel, BorderLayout.NORTH);

	    // Main content with table and statistics
	    JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
	    
	    // Create table
	    JTable studentTable = createStudentTable();
	    JScrollPane scrollPane = new JScrollPane(studentTable);
	    scrollPane.setPreferredSize(new Dimension(800, 300));
	    
	    // Statistics panel
	    JPanel statsInfoPanel = createStatisticsInfoPanel();
	    
	    // Pagination controls
	    JPanel paginationPanel = createPaginationPanel(studentTable);
	    
	    contentPanel.add(scrollPane, BorderLayout.CENTER);
	    contentPanel.add(statsInfoPanel, BorderLayout.SOUTH);
	    
	    statsPanel.add(contentPanel, BorderLayout.CENTER);
	    statsPanel.add(paginationPanel, BorderLayout.SOUTH);

	    // Return button
	    JButton returnBtn = new JButton("Return to Main Menu");
	    returnBtn.addActionListener(e -> cardLayout.show(cardPanel, "MainManu"));
	    
	    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    bottomPanel.add(returnBtn);
	    statsPanel.add(bottomPanel, BorderLayout.SOUTH);

	    return statsPanel;
	}
	
	
	
	/////////////////// 3. create students panel 
	private JTable createStudentTable() 
	{
	    String[] columnNames = {"ID", "First Name", "Last Name", "Email", "Math", "JAVA Programming", "English", "Average"};
	    
	    Object[][] data = getStudentData(0, 5); // Start with first 5 students
	    
	    DefaultTableModel model = new DefaultTableModel(data, columnNames) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // Make table non-editable
	        }
	    };
	    
	    JTable table = new JTable(model);
	    table.setFillsViewportHeight(true);
	    table.setRowHeight(25);
	    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
	    
	    return table;
	}
	
	
	/////////////////// 4. get student data
	private Object[][] getStudentData(int from, int to) 
	{
	    int pageSize = to - from;
	    List<Student> pageStudents = students.stream()
	            .skip(from)
	            .limit(pageSize)
	            .collect(Collectors.toList());
	    
	    Object[][] data = new Object[pageStudents.size()][8];
	    
	    for (int i = 0; i < pageStudents.size(); i++) {
	        Student student = pageStudents.get(i);
	        data[i][0] = students.indexOf(student); // ID
	        data[i][1] = student.getFirstName();
	        data[i][2] = student.getLastName();
	        data[i][3] = student.getEmail();
	        data[i][4] = formatGrade(student.getGrade("Math"));
	        data[i][5] = formatGrade(student.getGrade("JAVA Programming"));
	        data[i][6] = formatGrade(student.getGrade("English"));
	        data[i][7] = String.format("%.2f", student.getAverage());
	    }
	    
	    return data;
	}
	private String formatGrade(Double grade) 
	{
	    return grade != null ? String.format("%.2f", grade) : "N/A";
	}
	
	
	
	
	/////////////////// 5. pagination
	private JPanel createPaginationPanel(JTable table) 
	{
	    JPanel paginationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
	    paginationPanel.setBackground(null);
	    
	    JButton prevBtn = new JButton("Previous 5");
	    JButton nextBtn = new JButton("Next 5");
	    JLabel pageLabel = new JLabel("Page 1");
	    
	    // Pagination state
	    int[] currentPage = {0};
	    int pageSize = 5;
	    
	    prevBtn.addActionListener(e -> {
	        if (currentPage[0] >= pageSize) 
	        {
	            currentPage[0] -= pageSize;
	            updateTable(table, currentPage[0], pageSize, pageLabel);
	        }
	    });
	    
	    nextBtn.addActionListener(e -> {
	        if (currentPage[0] + pageSize < students.size()) 
	        {
	            currentPage[0] += pageSize;
	            updateTable(table, currentPage[0], pageSize, pageLabel);
	        }
	    });
	    
	    paginationPanel.add(prevBtn);
	    paginationPanel.add(pageLabel);
	    paginationPanel.add(nextBtn);
	    
	    return paginationPanel;
	}

	private void updateTable(JTable table, int from, int pageSize, JLabel pageLabel) {
	    int pageNumber = (from / pageSize) + 1;
	    pageLabel.setText("Page " + pageNumber);
	    
	    Object[][] newData = getStudentData(from, from + pageSize);
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setDataVector(newData, getColumnNames());
	}
	
	
	
	
	
	/////////////////// 6. create statistics information panel
	private JPanel createStatisticsInfoPanel() 
	{
	    JPanel statsPanel = new JPanel(new GridLayout(1, 3, 10, 5));
	    statsPanel.setBorder(BorderFactory.createTitledBorder("Class Statistics"));
	    statsPanel.setBackground(null);
	    
	    // Calculate statistics using Streams
	    DoubleSummaryStatistics stats = students.stream()
	            .mapToDouble(Student::getAverage)
	            .summaryStatistics();
	    
	    JLabel maxLabel = new JLabel(String.format("Max Average: %.2f", stats.getMax()));
	    JLabel minLabel = new JLabel(String.format("Min Average: %.2f", stats.getMin()));
	    JLabel avgLabel = new JLabel(String.format("Class Average: %.2f", stats.getAverage()));
	    
	    // Style the labels
	    Font statsFont = new Font("SansSerif", Font.BOLD, 14);
	    maxLabel.setFont(statsFont);
	    minLabel.setFont(statsFont);
	    avgLabel.setFont(statsFont);
	    
	    maxLabel.setHorizontalAlignment(JLabel.CENTER);
	    minLabel.setHorizontalAlignment(JLabel.CENTER);
	    avgLabel.setHorizontalAlignment(JLabel.CENTER);
	    
	    statsPanel.add(maxLabel);
	    statsPanel.add(minLabel);
	    statsPanel.add(avgLabel);
	    
	    return statsPanel;
	}
	
	
	
	/////////////////// 7. helper method for column names
	private String[] getColumnNames() 
	{
	    return new String[]{"ID", "First Name", "Last Name", "Email", "Math", "JAVA Programming", "English", "Average"};
	} 

}


