package servlet;

import database.MySQLConn;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementation class UpdateDb
 */
@WebServlet(asyncSupported = false, name = "UpdateDb", urlPatterns = {"/UpdateDb"})
public class UpdateDb extends HttpServlet {

    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDb() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     *
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String tescoId = request.getParameter("tescoId");
        String tescoName = request.getParameter("tescoName");
        String tescoBranch = request.getParameter("tescoBranch");
        String tescoLoc = request.getParameter("tescoLoc");

        try {
            Connection con = (Connection) MySQLConn.getMySQLConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into tescoepping(tescoId, tescoName, tescoBranch, tescoLoc) values(?,?,?,?)");
            ps.setString(1, tescoId);
            ps.setString(2, tescoName);
            ps.setString(3, tescoBranch);
            ps.setString(4, tescoLoc);

            int i = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateDb.class.getName()).log(Level.SEVERE, null, ex);
        }        
        response.sendRedirect(request.getContextPath());
    }
}
