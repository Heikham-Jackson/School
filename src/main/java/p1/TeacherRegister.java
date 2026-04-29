/*	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			id=request.getParameter("teacher_id");
			name=request.getParameter("teacher_name");
			department=request.getParameter("teacher_department");
			address=request.getParameter("teacher_address");
			qualification=request.getParameter("teacher_qualification");
			
			pstmt=con.prepareStatement("INSERT INTO teacher VALUES(?,?,?,?,?)");
			
			pstmt.setString(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,address);
			pstmt.setString(4,department);
			pstmt.setString(5,qualification);
			
			int row=pstmt.executeUpdate();
			//System.out.println("Data insert success");
			
			response.sendRedirect("success.html");
		}
		catch(Exception e)
		{
			response.sendRedirect("fail.html");
		}
	}
}
*/