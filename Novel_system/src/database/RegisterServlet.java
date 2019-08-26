package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

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
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		 response.setContentType("text/html;charset=UTF-8");// 设置响应的MIME类型。
         java.io.PrintWriter out = response.getWriter();
		 String user = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
         String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");  
         String age = request.getParameter("age");     
         String pwd = request.getParameter("password"); 
         String nwd = request.getParameter("newword"); 
         Connection conn = null;
         PreparedStatement pStmt;
         PreparedStatement tmt = null;
         try {
			conn = database.getSqlServerConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
         try {
			 pStmt = conn.prepareStatement("select * from Reader where rename = '" + user + "'");
			 ResultSet rs = pStmt.executeQuery();  
	           if(rs.next()){  
	               out.println("<script language='javascript'>alert('该用户已存在，请重新注册！');window.location.href='register.jsp';</script>");  
	           }
	           else{  
	        	   tmt = conn.prepareStatement("Insert into Reader values('" + user + "','" + sex + "','" + age + "','"  + pwd + "')");  
					int rst = tmt.executeUpdate();
					if (rst != 0){  
	                         out.println("<script language='javascript'>alert('用户注册成功！');window.location.href='index.jsp';</script>"); 
	                         }
					else{  
	                      out.println("<script language='javascript'>alert('用户注册失败！');window.location.href='register.jsp';</script>");    
	                }  
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
