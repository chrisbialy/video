package VideoRenatal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMySQLConnection 
{
	//static reference to itself jdbcdb
    private static JDBCMySQLConnection instance = new JDBCMySQLConnection();
    public static final String URL = "jdbc:mysql://comp-hons.uhi.ac.uk/pe14002792";
    public static final String USER = "0000";
    public static final String PASSWORD = "0000";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
     
    //private constructor
    private JDBCMySQLConnection() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() 
{
 
        Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER,PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
     
    public static Connection getConnection() 
    {
        return instance.createConnection();
    }
}
