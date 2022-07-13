package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class SignIn extends HttpServlet {
	HashMap<String, String> h1 = new HashMap<String, String>();

	@Override
	public void init() throws ServletException {

		DAO dao = new DAO();
		ResultSet rs = dao.getRows("select * from login");

		try {
			while (rs.next()) {
				String name = rs.getString(6);
				String pass = rs.getString(7);
				System.out.println("name and pass: " + name + "  : " + pass);
				h1.put(name, pass);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.println("<html><body style=\"background-image:url('https://www.bird-wittenbergdental.com/wp-content/"
				+ "uploads/2017/01/top-line-management-login-background-1.jpg');"
				+ "background-repeat:no-repeat;background-attachment: fixed;background-size:cover;\"> ");
		pw.println("<form  method='POST'>");
		pw.println("<center><br/><br/><br/><br/><br/><br/><br/><br/><h1>LOGIN PAGE</h1>");
		pw.println("<br/><b>Username : <b/><input type='text' name='name' />");
		pw.println("<br/><br/><b>Password : </b><input type='text' name='pass' />");
		pw.println("<br/><br/><input type='submit' name='show' name='Login' />");
		pw.println("</form></center></body></html>");

		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		pw.println("<html><body>");
		System.out.println(name);
		System.out.println(pass);

		if (h1.containsKey(name) && h1.containsValue(pass)) {
			pw.println("<h1>Successfully Login...!!!</h1>");
//			RequestDispatcher RD = request.getRequestDispatcher("Home.html");
//			RD.forward(request, response);

		} else {
			pw.println("<h1>Login Failed...!!!</h1>");
			 // RequestDispatcher RD = request.getRequestDispatcher("Login");
			// RD.forward(request, response);
		}
		pw.println("<form action= 'Home' method='GET'>");
		pw.println("<input type=\"submit\" name = \"HOME\" value=\" HOME \" />");
		pw.println("</form></body></html> ");

		pw.close();
	}

}