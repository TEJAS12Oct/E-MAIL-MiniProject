package Project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class Home extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		pw.println("<html><body style=\"background-image:url('https://i.pinimg.com/originals/ca"
				+ "/dc/7a/cadc7aaef2627a75d8744be36ab4275f.jpg')\"><center>");
		pw.println("<h1>Home Page</h1>");
		pw.println("<img src=\"https://t4.ftcdn.net/jpg/03/41/47/73/360_F_341477352_FPo"
				+ "RvWnWWqdzVFnIWn3on34gYWaSEX2K.jpg\" alt=\"Sample Image\" height=\"300\"></img>");

		pw.println("<h2>SignUp for new User...!!!</h2>");
		pw.println("<form action='register' method='GET'>");
		pw.println("<input type='Submit' value='Sign UP'/> </form>");

		pw.println("<h2>SignIn for old User...!!!</h2>");
		pw.println("<form action='Login' method='GET'>");
		pw.println("<input type='Submit' value='Sign IN'/></form> ");

		pw.println("</center>");
		pw.println("</body></html>");
	}

}
