

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;


/**
 * Servlet implementation class authClass
 */
@WebServlet("/registerUser")
public class registerClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i = request.getParameter("email");
		String j = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.println("Info " + i + j);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("Hiii");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "password@123");
			if(con != null)
			{
				System.out.println("Connection successful !");
			}
			
			String sql = "INSERT INTO emp (email, password) VALUES(?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, i);
			stmt.setString(2, j);
			
		    int rowInserted =  stmt.executeUpdate();
			
			if(rowInserted > 0)
			{
				System.out.println("Inserted Successfuly...");
				response.sendRedirect("/FoodDeliverSystem/frontendProject/home.html");  
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
