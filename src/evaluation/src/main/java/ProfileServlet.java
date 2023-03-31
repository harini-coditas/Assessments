import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h3>StudentProfileServlet</h3>");
        out.println("<h1>Student Details</h1>");

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String user = req.getParameter("email");
        String pwd = req.getParameter("password");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javajdbc", "root", "81189149@hH");
            out.println("jdbc connection done");
            st = con.createStatement();
            rs = st.executeQuery("select id,uname,email,password,city,phone from evaluation7");


           while(rs.next()) {
               String un = rs.getString(3);
               String up = rs.getString(4);
               if (un.equals(user) && up.equals(pwd)) {

                   out.println("id: " + rs.getString(1) + "<br>");
                   out.println("uname: " + rs.getString(2) + "<br>");
                   out.println("email: " + rs.getString(3) + "<br>");
                   out.println("password: " + rs.getString(4) + "<br>");
                   out.println("city: " + rs.getString(5) + "<br>");
                   out.println("phone: " + rs.getString(6) + "<br>");
                   break;
               }
           }

           out.println("<br> <br>");
            out.println("<a href='EditServlet'>Edit</a> <br>");
            out.println("<a href='DeleteServlet'>Delete</a> <br>");
            out.println("<a href='AddServlet'>Add</a> <br>");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

