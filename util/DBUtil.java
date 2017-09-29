package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
static	Connection con=null;
public static Connection getConnection()
{
	String url="jdbc:oracle:thin:@localhost:1521:orcl1";
	String uname="scott";
	String pwd="tiger";
	try {
		con=DriverManager.getConnection(url,uname,pwd);
		System.out.println("\nConnected");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	
}
}
