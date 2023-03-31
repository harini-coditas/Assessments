import sun.security.jgss.HttpCaller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/AdminProfileServlet")
public class AdminProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h3>AdminProfileServlet</h3>");
        out.println("<h1>All Details</h1>");

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javajdbc", "root", "81189149@hH");
                st = con.createStatement();
                rs = st.executeQuery("select * from evaluation7");

                while (rs.next()) {
                    out.println("id: " + rs.getString(1) + "<br>");
                    out.println("uname: " + rs.getString(2) + "<br>");
                    out.println("email: " + rs.getString(3) + "<br>");
                    out.println("password: " + rs.getString(4) + "<br>");
                    out.println("city: " + rs.getString(5) + "<br>");
                    out.println("phone: " + rs.getString(6) + "<br>");
                }



            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

}
