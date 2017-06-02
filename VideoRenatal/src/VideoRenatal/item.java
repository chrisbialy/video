package VideoRenatal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class item {
	
	
	private String title;
	private int status;
	private int iid;
	
	
	// dodawanie nowego tytulu do bazy danych
	
		public void addTitle()
		{
			
			
			Scanner kboard = new Scanner(System.in);
			System.out.println("Podaj tytul filmu");
			String title = kboard.next();
			
			
			System.out.print("Podaj status filmu: 1");
			int status = kboard.nextInt();
			
			if (status ==1)
			{
				  Connection connection = null;
				    Statement statement = null; 
				    String query1="";
				  
				  
				    	query1 = "insert into item(title,status) values ('"+title+"',"+status+");";

				    	try {           
				            connection = JDBCMySQLConnection.getConnection();
				            statement = connection.createStatement();
				            statement.executeUpdate(query1);
				        
				            
				            System.out.println("Dodano nowy tytul: "+title+" "+status );
				     		} catch (SQLException e) 
				     	{
				    	 e.printStackTrace();
				     	} 
				
			}
			else
			{
				item.this.addTitle();
			}
		
		}
		

		
		// odczytywanie bazy danych z klientami
		
		public void retrieveTitle()
		{
			ResultSet rs = null;
		    Connection connection = null;
		    Statement statement = null;
		    String query="";
		  
	    
		    query = "select * from item";
		    
		    try {           
		        connection = JDBCMySQLConnection.getConnection();
		        statement = connection.createStatement();
		        rs = statement.executeQuery(query);
		        
		        String Str = new String("ID Tytu³ Status\n");
		        System.out.println(Str.toUpperCase() );
		        while (rs.next())
		        {
		        	
		        	   int iid = rs.getInt("iid");
		               String title = rs.getString("title");
		               int status = rs.getInt("status");
		              
		               // print the results
		               System.out.format("%s  %s  %s\n", iid, title, status);
		        	
		        	
		        	
		        }// koniec while
		        connection.close();
		        //System.out.println("\nClient Retrieved");
		        
		 		} //koniec try
		    catch (SQLException e) 
		 	{
			 e.printStackTrace();
		 	} 
	 }//koniec funkcji retrieveClient
		
		
		public void itemMenu()
		{
			
			
			int choice=0;
			Scanner kboard = new Scanner(System.in);
			//this.retrieveClient();
			System.out.println("\nMENU FILM");
			System.out.println("\n1. Dodaj nowy tytu³ \n2. Lista filmów \n3. Powrót");
			choice = kboard.nextInt();
			while (choice != 3)
			{
				switch(choice)
				{
				case 1: this.addTitle();			break;
				case 2: this.retrieveTitle();		break;
				}
				System.out.println("\nMENU FILM");
				System.out.println("\n1. Dodaj nowy tytu³ \n2. Lista filmów \n3. Powrót");
				choice = kboard.nextInt();
			}
			
		}
	

}
