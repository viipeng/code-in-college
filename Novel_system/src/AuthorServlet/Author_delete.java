package AuthorServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Bean.add_delete_change_query;

public class Author_delete extends HttpServlet {

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
		String auname = new String(request.getParameter("auname").getBytes("ISO-8859-1"),"UTF-8");
		add_delete_change_query aq = new add_delete_change_query();
		int a = 0;
		
		String sql1 = "delete from Novel where auname = '"+auname+"';";
		String sql2 = "delete from Author where auname ='"+auname+"';";
		try {
			aq.add(sql1);
			a=aq.add(sql2);
			if(a==1)
			out.println("<script language='javascript'>alert('É¾³ý³É¹¦£¡');window.location.href='Author/Author_delete.jsp';</script>");
			else{
	            JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü", "³ö´íÀ²", JOptionPane.ERROR_MESSAGE);
				request.getRequestDispatcher("/Author/Author_delete.jsp").forward(request, response);
			}
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
