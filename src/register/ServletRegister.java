package register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.System.out;

/**
 * Created by Mojgan on 16/11/26.
 */
@WebServlet(urlPatterns = { "/RegisterServlet" })
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        System.out.println("username is:  "+uname+"Yout pass is : " +"   "+pass);
        // response.sendRedirect("LoginSuccess.jsp");
        try {
            //System.out.println("in try for register");

            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/servletdb",
                            "postgres", "123456");
            PreparedStatement pstate = c.prepareStatement("INSERT INTO registerdb VALUES(?,?,?,?)");
            pstate.setString(1,name);
            pstate.setString(2,email);
            pstate.setString(3,uname);
            pstate.setString(4,pass);
            boolean B =  pstate.execute();
            if(B == false){
//                out.println("Welcome"+uname);
                response.sendRedirect("login/index.jsp");
            }
            else
                out.println("one or more field is/are not correct!");
            c.close();
        }
        catch(Exception e){
            out.println(e);}
    }


}
