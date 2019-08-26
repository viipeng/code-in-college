package Reader_authority_Servlet;

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

public class Reader_Novel_query extends HttpServlet {

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
//		PrintWriter out = response.getWriter();
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String noname1="";
		String start_time1="";
		String finish_time1="";
		String auname1="";
		add_delete_change_query aq = new add_delete_change_query();
		
		String sql = "select * from Novel where noname ='" + name +"'";
		try {
			ResultSet Novel = aq.query(sql);
			if(Novel.next()){
				
				noname1=Novel.getString("noname");
				start_time1=Novel.getString("start_time");
				finish_time1=Novel.getString("finish_time");
				auname1=Novel.getString("auname");
				
				request.setAttribute("noname", noname1);
				request.setAttribute("start_time", start_time1);
				request.setAttribute("finish_time", finish_time1);
				request.setAttribute("auname", auname1);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/Reader_authority/Novel_query1.jsp");
                dispatcher .forward(request, response);
				
			}
			else{
	             JOptionPane.showMessageDialog(null, "²éÑ¯Ê§°Ü", "³ö´íÀ²", JOptionPane.ERROR_MESSAGE);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/Reader_authority/Novel_query.jsp");
	             dispatcher .forward(request, response);
			}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
