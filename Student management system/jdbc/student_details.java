package jdbc;
//TODO Auto-generated method stub
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
		import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
       public class student_details {
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
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_1","root","");
			//object=class .method  (API:dataBase:/server name:Port Number/DB-Name,username,password) 
			if(con!=NULL)//Connection checking
			{
				System.out.println("Connection successful");
			}
			else
			{
			System.out.println("Check Your Connection");
			}
			Scanner s=new Scanner(System.in);
			System.out.println("1) insert");
			System.out.println("2) Display ");
			System.out.println("Enter the operation");
			int c=s.nextInt();
			switch(c)
			{
			case 1:
			System.out.println("Enter firstname");
			String first=s.next();
			System.out.println("Enter the REG_NO");
			int id=s.nextInt();
			System.out.println("Enter the Department");
			String dep=s.next();
			System.out.println("Enter the Year");
			int year=s.nextInt();
			System.out.println("Enter the address");
			String add=s.next();
			PreparedStatement st= con.prepareStatement("insert into" +" student(NAME,REG_NO,DEPARTMENT,YEAR,ADDRESS) values(?,?,?,?,?);");
			st.setString(1,first);
			st.setInt(2, id);
			st.setString(3, dep);
			st.setInt(4, year);
			st.setString(5,add);
			st.executeUpdate();
			System.out.println("Insert successful");
			
			
			//5)Closing the connection
			con.close();
			break;
			case 2:
				Statement s1=(Statement) con.createStatement();
				ResultSet r=s1.executeQuery("select * from student");
				while(r.next())
				{
					System.out.println(r.getString(1)+" "+r.getInt(2)+" "+r.getString(3)+" "+r.getInt(4)+" "+r.getString(5)+" ");
				}
				con.close();
		}
		
	}
       }


