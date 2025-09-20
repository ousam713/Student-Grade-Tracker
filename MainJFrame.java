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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Student> students= new ArrayList<>(); 
		
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
		setSize(871, 707);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout());
		
		JLabel imageLogo = new JLabel(new ImageIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/SMS.png"));
		contentPane.add(imageLogo, BorderLayout.NORTH);
		
//		<< create JPanel : manuPanel
		JPanel manuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
//		<< << create JPanel : cardPanel
		CardLayout cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.setBackground(Color.red);
		cardPanel.setSize(300,300);
		
		manuPanel.add(cardPanel, BorderLayout.CENTER);
//		>> >> add JPanel : manuSubPanel

		
//		<< << create JPanel : manuContainerPanel
		// TODO : add  JLayeredPanel to solve Labels problem (it must contain manuSubPanel and labelContainerPanel a JPanel that has an ABSOLUTE LM)
		/*
		
		JLayeredPane manuContainerPanel = new JLayeredPane();
		manuPanel.add(manuContainerPanel, BorderLayout.CENTER); 
		
		*/
//		>> >> add JPanel : manuSubPanel
		
		
//		<< << create JPanel : manuSubPanel
		JPanel manuSubPanel = new JPanel();
		manuSubPanel.setBackground(null);
		manuSubPanel.setLayout(new GridLayout(2,2,50,50));
		
		
		ImageIcon icon1 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/manage_std.png");
		JButton manageStdBtn = new JButton(icon1);
		removeMarginBtn(manageStdBtn);
		
		ImageIcon icon2 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/search_std.png");
		JButton searchStdBtn = new JButton(icon2);
		removeMarginBtn(searchStdBtn);
		
		ImageIcon icon3 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/manage_grades.png");
		JButton manageGradesBtn = new JButton(icon3);
		removeMarginBtn(manageGradesBtn);
		
		ImageIcon icon4 = getResizedIcon("/home/ousam713/Desktop/mes_stages/09-2025_Code_Alpha/Projects/TASK_1/Student_Grade_Tracker/icons/statistic.png");
		JButton statisticBtn = new JButton(icon4);
		removeMarginBtn(statisticBtn);
		
		
		manuSubPanel.add(manageStdBtn);
		manuSubPanel.add(searchStdBtn);
		manuSubPanel.add(manageGradesBtn);
		manuSubPanel.add(statisticBtn);
		
		
		cardPanel.add(manuSubPanel, BorderLayout.CENTER);
//		>> >> add JPanel : manuSubPanel
		
		contentPane.add(manuPanel, BorderLayout.CENTER);
//		>> add JPanel : manuPanel
		
	}
	
	public ImageIcon getResizedIcon(String path) 
	{
		try 
		{
			Image originalIcon= new ImageIcon(path)
									.getImage()
									.getScaledInstance(185, 170, Image.SCALE_SMOOTH);
			ImageIcon resizedIcon = new ImageIcon(originalIcon);
			
			return resizedIcon;
		} catch(Exception e) 
		{
			System.out.println("unable to lorad images");
			return null;
		}
	}
	
	public void removeMarginBtn(JButton btn) 
	{
		btn.setBorder(null);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
