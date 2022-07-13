package Project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class SignUp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String Name = request.getParameter("Name");
		String LName = request.getParameter("LName");
		String DOB = request.getParameter("DOB");
		String Gender = request.getParameter("gender");
		String Contact = request.getParameter("Contact");
		String UserName = request.getParameter("UserName");
		String Password = request.getParameter("Password");

		DAO dao = new DAO();
		dao.addUser(Name, LName, DOB, Gender, Contact, UserName, Password);
		pw.println("<h1>User Add Succesfully...!!!</h1>");

		pw.println("<html><body> ");
		pw.println("<form action= 'Home.html'>");
		pw.println("<input type=\"submit\" name = \"HOME\" value=\" HOME \" />");
		pw.println("</form></body></html> ");

		pw.close();

	}

}
