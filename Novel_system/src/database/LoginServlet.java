package database;

import java.io.IOException;



import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
        super();
    }
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
            Connection conn = null;
			try {
				conn = database.getSqlServerConnection();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            Statement stmt;
            String user = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");    
            String pwd = request.getParameter("pwd");  
            try {
                stmt = (Statement) conn.createStatement();
                String sql = "select * from Reader where rename = '" + user + "' and password = '" + pwd + "'";// 表名Reader
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()){  
                	if(user.equals("易鹏")){
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
                        dispatcher .forward(request, response);
                	}
                	else{
              			 request.getRequestDispatcher("main1.jsp").forward(request,response);
                	}
                }else{  
                    response.sendRedirect("index.jsp?errNo");//密码不对返回到登陆    
                }  
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
