import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Student> students= new ArrayList<>(); 
		
		StudentHelper.Go(students);
		
		do 
		{
			System.out.println( "\n=============="+
					"\nPresse a number:\n"+
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
								    "\nPresse a number:\n"+
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
									"\nPresse a number:\n"+
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
									Student.showStudents(students);
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
									"\nPresse a number:\n"+
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
 	}

}


//"\n1. "+
//"\n2. "+
//"\n3. "+
//"\n4. "+


