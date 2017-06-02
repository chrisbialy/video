package VideoRenatal;

import java.util.Scanner;

public class Menu {

	client c1 = new client();
	item i1 = new item(); 
	rental r1 = new rental(); 
	 
	
	
	public void videoMenu()
	{
		
		int choice=0;
		Scanner kboard = new Scanner(System.in);
		
		System.out.println("\nMENU WYPO¯YCZALNIA");
		System.out.println("\n1. KLIENT \n2. FILM  \n3. REJESTRACJA \n4. Wyjœcie");
		choice = kboard.nextInt();
		while (choice != 4)
		{
			switch(choice)
			{
			case 1: this.clientMenu();			break;
			case 2: this.itemMenu();			break;
			case 3: this.rentalMenu();			break;
			case 4: System.exit(0);				break;
			}
			System.out.println("\nMENU WYPO¯YCZALNIA");
			System.out.println("\n1. KLIENT \n2. FILM  \n3. REJESTRACJA \n4. Wyjœcie");
			choice = kboard.nextInt();
		}
		
	}


	private void rentalMenu() {
		r1.rentalMenu();
		
	}
	
	private void clientMenu() {
		c1.clientMenu();
		
	}
	
	
	private void itemMenu() {
		i1.itemMenu();
		
	}
	
	
}




