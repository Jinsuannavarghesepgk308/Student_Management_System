package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagement {
	private static Connection NULL;
	/* Steps to connect a Java Application to Database
	 1)Load and Register the Driver
	 2)Create a connection
	 3)create a Statement
	 4)ResultSet or Execute the query
	 5)closing the connection*/
	 

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
//1)Register the Driver.
Class.forName("com.mysql.jdbc.Driver");//register a driver//Class.forName() method used to load the driver class;
	Connection con=null;//Connection object
//2)Create a Connection
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Connection","root","");
	//object=class .method  (API:dataBase:/server name:Port Number/DB-Name,username,password) 
	if(con!=NULL)//Connection checking
	{
		System.out.printf("Connection successful");
	}
	else
	{
	System.out.println("Check Your Connection");
	}
	//5)Closing the connection
	con.close();
}
}
