package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/studentregistration")
public class studentregistration extends HttpServlet 
{
	String id=null;
	String name=null;
	String address=null;
	ResultSet res=null;
	PreparedStatement pstmt=null;
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/school";
	String username="root";
	String password="system";
	
	public void init()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver load success");
		}
		catch(Exception e)
		{
			System.out.println("Driver load failed");
		}
		
		try
		{
			con=DriverManager.getConnection(url,username,password);
			System.out.println("Connection success");
		}
		catch(Exception e)
		{
			System.out.println("Connection failed");
		}
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			id=request.getParameter("student_id");
			name=request.getParameter("student_name");
			address=request.getParameter("student_address");
			
			pstmt=con.prepareStatement("INSERT INTO STUDENTS VALUES(?,?,?)");
			
			pstmt.setString(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,address);
			
			int row=pstmt.executeUpdate();
			//System.out.println("Data insert success");
			
			response.sendRedirect("Success.html");
		}
		catch(Exception e)
		{
			response.sendRedirect("Fail.html");
		}
	}
}