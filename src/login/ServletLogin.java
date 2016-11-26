package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.out;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/LoginServlet" })
public class ServletLogin extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("in servlet");
        //get request parameters for userID and password
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        //out.println("username is:  "+uname+"Yout pass is : " +"   "+pass);
        //response.sendRedirect("../LoginSuccess.jsp");
        try {
           // System.out.println("In Login Try");
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/servletdb",
                            "postgres", "123456");
            PreparedStatement pstate = c.prepareStatement("SELECT * FROM registerdb WHERE uname=? AND pass=?");
            pstate.setString(1,uname);
            pstate.setString(2,pass);
            ResultSet rs = pstate.executeQuery();
            //System.out.println("Search Function   "+rs);
            if(rs.next()){
                out.println("Welcome"+uname);
                response.sendRedirect("../LoginSuccess.jsp");
            }
            else
                response.sendRedirect("../login/index.jsp");
            c.close();

        }
        catch(Exception e){
            out.println(e);}







    }

}
