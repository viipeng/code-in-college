package Servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.add_delete_change_query;

public class Reader_add extends HttpServlet {

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
        java.io.PrintWriter out = response.getWriter();
		String rename = new String(request.getParameter("rename").getBytes("ISO-8859-1"),"UTF-8");
		String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		String age = new String(request.getParameter("age"));
		String password = new String(request.getParameter("password"));
		add_delete_change_query aq = new add_delete_change_query();
		int a = 0;
		
		String sql = "insert into Reader values('"+rename+"' , '"+sex+"' , '"+age+"' , '" +password+"');";
		try {
			a=aq.add(sql);
			if(a==1)
			out.println("<script language='javascript'>alert('Ìí¼Ó³É¹¦£¡');window.location.href='Reader/Reader_add.jsp';</script>");
			else
			request.getRequestDispatcher("/Reader/Reader_add.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
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
