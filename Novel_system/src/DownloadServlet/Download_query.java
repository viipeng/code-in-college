package DownloadServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Bean.add_delete_change_query;

public class Download_query extends HttpServlet {

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
		String nname = new String(request.getParameter("nname").getBytes("ISO-8859-1"),"UTF-8");
		String rname = new String(request.getParameter("rname").getBytes("ISO-8859-1"),"UTF-8");
		String noname1="";
		String rename1="";
		add_delete_change_query aq = new add_delete_change_query();
		
		String sql = "select * from Download where noname ='" + nname +"' and rename = '"+rname+"';";
		try {
			ResultSet Download = aq.query(sql);
			if(Download.next()){
				
				noname1=Download.getString("noname");
				rename1=Download.getString("rename");
				
				request.setAttribute("noname", noname1);
				request.setAttribute("rename", rename1);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/Download/Download_query1.jsp");
                dispatcher .forward(request, response);
				
			}
			else{
	             JOptionPane.showMessageDialog(null, "²éÑ¯Ê§°Ü", "³ö´íÀ²", JOptionPane.ERROR_MESSAGE);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/Download/Download_query.jsp");
	             dispatcher .forward(request, response);
			}
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
