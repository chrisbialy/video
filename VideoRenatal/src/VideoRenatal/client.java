package VideoRenatal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class client extends NewClient {

	
	
	
	
	
	// dodawanie nowego klienta do bazy danych
	
	public void addClient()
	{
		
		
		Scanner kboard = new Scanner(System.in);
		System.out.println("Podaj Imie klienta");
		String name = kboard.next();
		System.out.println("Podaj nazwisko klienta");
		String surname = kboard.next();
		
	
	    Connection connection = null;
	    Statement statement = null; 
	    String query1="";
	  
	  
	    	query1 = "insert into client(name,surname) values ('"+name+"','"+surname+"');";

	    	try {           
	            connection = JDBCMySQLConnection.getConnection();
	            statement = connection.createStatement();
	            statement.executeUpdate(query1);
	        
	            
	            System.out.println("Dodano nowego klienta: "+name+" "+surname );
	     		} catch (SQLException e) 
	     	{
	    	 e.printStackTrace();
	     	} 
	}
	
	
	// odczytywanie bazy danych z klientami
	
	public void retrieveClient()
	{
		ResultSet rs = null;
	    Connection connection = null;
	    Statement statement = null;
	    String query="";
	  
    
	    query = "select * from client";
	    
	    try {           
	        connection = JDBCMySQLConnection.getConnection();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(query);
	        
	        //adding each record back into the data structures
	        String Str = new String("ID Imiê   Nazwisko\n");
	        System.out.println(Str.toUpperCase() );
	        
	        while (rs.next())
	        {
	        	
	        	   int cid = rs.getInt("cid");
	               String name = rs.getString("name");
	               String surname = rs.getString("surname");
	              
	               // print the results
	               System.out.format("%s  %s   %s\n", cid, name, surname);
	        	
	        	
	        	
	        }// koniec while
	        connection.close();
	        //System.out.println("\nClient Retrieved");
	        
	 		} //koniec try
	    catch (SQLException e) 
	 	{
		 e.printStackTrace();
	 	} 
 }//koniec funkcji retrieveClient
	
	
	public void clientMenu()
	{
		
		String string;
		int choice=0;
		Scanner kboard = new Scanner(System.in);
		//this.retrieveClient();
		System.out.println("\nMENU KLIENT");
		System.out.println("\n1. Dodaj nowego klienta \n2. Lista Klientow \n3. Powrót");
		choice = kboard.nextInt();
		while (choice != 3)
		{
			switch(choice)
			{
			case 1: this.addClient();			break;
			case 2: this.retrieveClient();		break;
			}
			System.out.println("\nMENU KLIENT");
			System.out.println("\n1. Dodaj nowego klienta \n2. Lista Klientow \n3. Powrót");
			choice = kboard.nextInt();
			
		}
		
	}
	
	
	
	
	
	
	
	//Dodawanie nowego klienta - BEZ bazy danych
	
	
	/*public client()
	{
		name = this.getName();
		surname = this.getSurName();
	
	}
	
	
	public client(String Fname, String Sname)
	{
		name = Fname;
		surname = Sname;
		 
	}
	
	
	public String getName()
	{
	Scanner kboard = new Scanner(System.in);
	String name;
	System.out.println("Podaj imie klienta");
	name = kboard.nextLine();
	return (name);
	}
	
	
	
	public String returnName()
	{
		System.out.println("Imie klienta " +name);
		return(name);
	}
	
	
	public String getSurName()
	{
	Scanner kboard = new Scanner(System.in);
	String surname;
	System.out.println("Podaj nazwisko klienta");
	surname = kboard.nextLine();
	return (surname);
	}
	
	
	
	public String returnSurName()
	{
		System.out.println("Nazwisko klienta " +surname);
		return(surname);
	}
	
	
	
	
	public void display()
	{
	System.out.print("Nowy klient potwirdzenie:");										
	System.out.print("\nImie: "+name+" \nNazwisko: "+surname+" \n");	
	}
*/

}
