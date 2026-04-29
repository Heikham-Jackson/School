package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class studentdetails
 */
@WebServlet("/studentdetails")
public class studentdetails extends HttpServlet 
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

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id =request.getParameter("student_id");//
		
		boolean found=false;
		
		try {
			pstmt=con.prepareStatement("SELECT * FROM students WHERE id=?");
			pstmt.setString(1,id);	
			res=pstmt.executeQuery();
			
			while(res.next()==true) {
				found=true;
				id=res.getString(1);
				name=res.getString(2);
				address=res.getString(3);
				
				
				
				PrintWriter pw= response.getWriter();
				pw.println(id+" "+name+" "+address);
			}
			if(!found) {
				PrintWriter pw=response.getWriter();
				pw.println("No found of this id");
				
			}
						
		}			
		catch(Exception e){
			e.printStackTrace();
		}
		
}
	

}
