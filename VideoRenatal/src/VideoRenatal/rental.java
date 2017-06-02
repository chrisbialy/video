package VideoRenatal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class rental {
	
	private int clientID;
	private int titleID;
	String dummy;
	
	//Menu m1 = new Menu();
	
	public void registerRental()
	{
		
		
		Scanner kboard = new Scanner(System.in);
		
		System.out.print("Podaj ID klienta\n ");
		int clientID = kboard.nextInt();
		//dummy = kboard.nextLine();
		System.out.println("\nPodaj ID filmu");
		int titleID = kboard.nextInt();
		//dummy = kboard.nextLine();
		
		
		
		if ((titleID >0) && (clientID > 0))
		{
			  Connection connection = null;
			    Statement statement = null; 
			    String query1="";
			  
			  
			    	query1 = "insert into rental(cid,iid) values ("+clientID+","+titleID+");";

			    	try {           
			            connection = JDBCMySQLConnection.getConnection();
			            statement = connection.createStatement();
			            statement.executeUpdate(query1);
			        
			            
			            System.out.println("Rejestracja zakonczona : Numer klienta: "+clientID+" Numer filmu "+titleID );
			     		} catch (SQLException e) 
			     	{
			    	 e.printStackTrace();
			     	} 
			
		}
		else
		{
			rental.this.registerRental();
		}
	
	}
	
	
	// odczytywanie bazy danych z klientami
	
			public void retrieveRental()
			{
				ResultSet rs = null;
			    Connection connection = null;
			    Statement statement = null;
			    String query="";
			  
		    
			    query = "select rental.rid, client.cid, client.name, client.surname, item.title from rental join client on"
			    		+ " client.cid = rental.cid join item on item.iid = rental.iid order by client.surname";
			    
			    try {           
			        connection = JDBCMySQLConnection.getConnection();
			        statement = connection.createStatement();
			        rs = statement.executeQuery(query);
			        
			        String Str = new String("No. Wyp.  No. klienta  	  Nazwisko  	Imiê    	Tytu³\n");
			        System.out.println(Str.toUpperCase() );
			        
			        while (rs.next())
			        {
			        	
			        	   int rid = rs.getInt("rid");
			        	   int cid = rs.getInt("cid");
			        	   String name = rs.getString("name");
			               String surname = rs.getString("surname");
			               String title = rs.getString("title");
			           
			              
			               // print the results
			               System.out.format("%s		%s	  %s	 	%s		%s\n", rid, cid, surname,name,title);
			        	
			        	
			        	
			        }// koniec while
			        connection.close();
			        
			        
			 		} //koniec try
			    catch (SQLException e) 
			 	{
				 e.printStackTrace();
			 	} 
		 }//koniec funkcji retrieveRental
	
	
			public void rentalMenu()
			{
				
				
				int choice=0;
				Scanner kboard = new Scanner(System.in);
				//this.retrieveClient();
				System.out.println("\nMENU REJESTRACJA");
				System.out.println("\n1. Rejestracja wypozyczenia \n2. Lista wypo¿yczeñ \n3. Powrót");
				choice = kboard.nextInt();
				while (choice != 3)
				{
					switch(choice)
					{
					case 1: this.registerRental();			break;
					case 2: this.retrieveRental();			break;
					}
					System.out.println("\nMENU REJESTRACJA");
					System.out.println("\n1. Rejestracja wypozyczenia \n2. Lista wypo¿yczeñ \n3. Powrót");
					choice = kboard.nextInt();
				}
				
			}	
			
			
	
			
}
