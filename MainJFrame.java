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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainJFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private static ArrayList<Student> students = new ArrayList<>();
	
	public static void addStudent (Student std) 
	{
		students.add(std);
	}
	public static Student editStudent(Student)
	{
		return 
	}
	
	public static void deleteStudent(int id) 
	{
		
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
		setSize(850, 610);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout());
		
		JLabel imageLogo = new JLabel(new ImageIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/SMS.png"));
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
		// TODO : add  JLayeredPanel to solve Labels problem (it must contain manuSubPanel and labelContainerPanel a JPanel that has an ABSOLUTE LM)
		/*
		
		JLayeredPane manuContainerPanel = new JLayeredPane();
		manuPanel.add(manuContainerPanel, BorderLayout.CENTER); 
		
		*/
//		>> >> add JPanel : manuSubPanel
		
		
//		<< << << create JPanel : manuSubPanel
		JPanel manuSubPanel = createMainManuPanel();
		cardPanel.add(manuSubPanel, "MainManu");
//		>> >> >> add JPanel : manuSubPanel
		
		
//		<< << << create JPanel : manageStdPanel
		JPanel manageStdPanel = createStudentManu();
		cardPanel.add(manageStdPanel, "ManageStudentManu");
//		>> >> >> add JPanel : manageStdPanel
		
		
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
	
	private JPanel createMainManuPanel() 
	{
		JPanel manuSubPanel = new JPanel();
		manuSubPanel.setBackground(null);
		manuSubPanel.setLayout(new GridLayout(2,2,20,20));
		
		
		ImageIcon icon1 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/manage_std.png");
		JButton manageStdBtn = new JButton(icon1);
		removeMarginBtn(manageStdBtn,icon1);
		manageStdBtn.addActionListener(event->{
			cardLayout.show(cardPanel, "ManageStudentManu");
		});
		
		ImageIcon icon2 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/search_std.png");
		JButton searchStdBtn = new JButton(icon2);
		removeMarginBtn(searchStdBtn,icon1);
		
		ImageIcon icon3 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/manage_grades.png");
		JButton manageGradesBtn = new JButton(icon3);
		removeMarginBtn(manageGradesBtn,icon1);
		
		ImageIcon icon4 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/statistic.png");
		JButton statisticBtn = new JButton(icon4);
		removeMarginBtn(statisticBtn,icon1);
		
		
		manuSubPanel.add(manageStdBtn);
		manuSubPanel.add(searchStdBtn);
		manuSubPanel.add(manageGradesBtn);
		manuSubPanel.add(statisticBtn);
		
		return manuSubPanel;
	}
	
	private JPanel createStudentManu() 
	{
		JPanel manageStdPanel = new JPanel();
		manageStdPanel.setBackground(null);
		manageStdPanel.setLayout(new GridLayout(2,2,20,20));
		
		
		ImageIcon icon1_1 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/add_std.png");
		JButton addStdBtn = new JButton(icon1_1);
		removeMarginBtn(addStdBtn,icon1_1);
		addStdBtn.addActionListener(e->{
			
		});
		
		ImageIcon icon1_2 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/modify_std.png");
		JButton modefyStdBtn = new JButton(icon1_2);
		removeMarginBtn(modefyStdBtn,icon1_1);
		
		ImageIcon icon1_3 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/delete_std.png");
		JButton deleteStdBtn = new JButton(icon1_3);
		removeMarginBtn(deleteStdBtn,icon1_1);
		
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
	
	
}

/*
do 
		{
			System.out.println( "\n=============="+
					"\nPress a number:\n"+
				    "\n1. Manage students"+
				    "\n2. Show / Search students"+
				    "\n3. Input grades"+
				    "\n4. Statistics"+
				    "\n0. Exit"+
				    "\n=============="
					);
			
				int n = in.nextInt();
				
				if(n == 0) 
				{
					System.out.println("Good bye!");
					break;
				}
				
				switch(n) 
				{
					case 1:
						do 
						{
							System.out.println( "/n=============="+
								    "\nPress a number:\n"+
								    "\n1. Create student"+
								    "\n2. Update student"+
								    "\n3. Delete student"+
								    "\n0. Return"+
								    "\n=============="
									);
							int n1 = in.nextInt();
							
							if(n1 == 0) break;
							
							switch(n1) 
							{
							case 1:
								Student.createStd(students);
								break;
								
							case 2:
								Student.updateStd(students);
								break;
								
							case 3:
								Student.deleteStd(students);
								break;
								
							default:
								System.out.println("Number unavailable");
								break;
								
							}
							
						}while(true);
						break;
					case 2:
						do 
						{
							System.out.println( "/n=============="+
									"\nPress a number:\n"+
									"\n1. Show all students"+
									"\n2. Search a student"+
									"\n0. Return"+
									"\n=============="
									);
							int n2 = in.nextInt();
							
							if(n2 == 0) break;
							
							switch(n2)
							{
								case 1 : 
									Student.showStudents(students);
									break;
								case 2 : 
									Student.searchStudents(students);
									break;
								default : 
									System.out.println("Number unavailable");
									break;
								
							}
							
						}while(true);
						break;
					case 3:
						
						break;
					case 4:
						do 
						{
							System.out.println( "/n=============="+
									"\nPress a number:\n"+
									"\n1. Highest score"+
									"\n2. Lowest score"+
									"\n3. Class's avergage"+
									"\n0. Return"+
									"\n=============="
									);
							int n4 = in.nextInt();
							
							if(n4 == 0) break;
						}while(true);
						break;
					default:
						System.out.println("Number unavailable");
						break;
				}
			
			} while(true);
 */
