package form;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/register")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,    // 10 MB
                 maxFileSize = 1024 * 1024 * 50,          // 50 MB
                 maxRequestSize = 1024 * 1024 * 100)      // 100 MB
public class form extends HttpServlet {

    private static final String INSERT_QUERY = "INSERT INTO CASES (CASE_ID, DESCRIPTION, NUM_FILES) VALUES (?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        String caseId = req.getParameter("caseId");
        String description = req.getParameter("description");
        int numFiles = Integer.parseInt(req.getParameter("numFiles"));

        // Process file upload
        for (Part part : req.getParts()) {
            if (part.getName().equals("files")) {
                String fileName = extractFileName(part);
                String savePath = "C:/uploads/" + fileName;  // You should change this to your desired directory
                part.write(savePath);
            }
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql:///firstdb", "root", "root");
             PreparedStatement ps = con.prepareStatement(INSERT_QUERY)) {

            ps.setString(1, caseId);
            ps.setString(2, description);
            ps.setInt(3, numFiles);

            int count = ps.executeUpdate();
            if (count == 0) {
                pw.println("Record not stored in the database");
            } else {
                pw.println("Record stored in the database");
            }
        } catch (SQLException se) {
            pw.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            pw.println(e.getMessage());
            e.printStackTrace();
        }

        pw.close();
    }

    // Extracts file name from HTTP header content-disposition
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
