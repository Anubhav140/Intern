<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String age = request.getParameter("age");

    // Database connection parameters
    String dbURL = "jdbc:mysql://localhost:3306/yourdatabase";
    String dbUser = "root";
    String dbPass = "password";

    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        String sql = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setInt(3, Integer.parseInt(age));

        int rows = stmt.executeUpdate();

        if (rows > 0) {
            out.println("Data has been stored successfully.");
        } else {
            out.println("Failed to store data.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
%>
