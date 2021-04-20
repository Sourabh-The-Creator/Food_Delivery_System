import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginUser
 */
@WebServlet("/verifyUser")
public class loginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i = request.getParameter("email");
		String j = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.println("Info " + i + j);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "password@123");
			if(con != null)
			{
				System.out.println("Connection successful !");
			}
			
			
			
			java.sql.Statement stmt = con.createStatement();

		String sql = String.format("SELECT email FROM emp WHERE email=\"%s\" AND password=\"%s\"", i,j);
		  
		
		
		ResultSet res =  stmt.executeQuery(sql);
		
		
			if(res.next())
			{
				System.out.println("Verified User");
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
