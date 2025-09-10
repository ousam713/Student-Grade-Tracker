import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		do 
		{
			System.out.println( "/n=============="+
								"\nPresse a number:"+
							    "\n1. Manage students"+
							    "\n2. Show students"+
							    "\n3. Input grades"+
							    "\n4. Manage grades"+
							    "\n0. exit"+
							    "/n=============="
					);
			
				int n = in.nextInt();
				
				if(n == 0) break;
				
				switch(n) 
				{
					case 1:
						do 
						{
							System.out.println( "/n=============="+
									   "\nPresse a number:"+
									   "\n1. Show student"+
									   "\n2. Create students"+
									   "\n3. Update student"+
									   "\n4. Delete student"+
									   "\n0. exit"+
									   "/n=============="
									);
							int n1 = in.nextInt();
							if(n1 == 0) break;
						}while(true);
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					default:
						break;
				}
			
			} while(true);
 	}

}


//"\n1. "+
//"\n2. "+
//"\n3. "+
//"\n4. "+