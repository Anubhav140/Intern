package pnb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
        String EID = request.getParameter("eid1");
        String password = request.getParameter("pass1");

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","As240618.");

            PreparedStatement stmt = conn.prepareStatement("select * from login where EID = ? AND password = ?");
            stmt.setString(1, EID);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
               RequestDispatcher rd=request.getRequestDispatcher("/hi.jsp");
               rd.forward(request, response);
            } else {
            	response.setContentType("text/html");
            	out.print("<h3>EID/Password didn't matched</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.include(request, response);
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
    }
}

