package Download_list;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import database.database;

import Bean.add_delete_change_query;

public class Download_list extends HttpServlet {

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
		doGet(request, response);
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
		String noname="";
		String auname="";
		String amount="";
		add_delete_change_query aq = new add_delete_change_query();
		List<Model> list = new ArrayList<Model>();
        Model model = new Model();
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs = null;
		try {
			conn = database.getSqlServerConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String sql = "select noname,auname,downloads from Download_list order by Downloads desc;";//order by Downloads desc
		try {
			conn = database.getSqlServerConnection();
	        stmt = (Statement) conn.createStatement();
	        rs = stmt.executeQuery(sql);
		            while(rs.next()){

				noname=rs.getString(1);
				auname=rs.getString(2);
				amount=rs.getString(3);
				
				model=new Model();
		        model.setNoname(noname);
		        model.setAuname(auname);
		        model.setAmount(amount);
		        list.add(model);
			}
			 request.setAttribute("list",list);
			 request.getRequestDispatcher("Download_list.jsp").forward(request,response);
		            
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
