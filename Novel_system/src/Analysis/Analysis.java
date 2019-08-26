package Analysis;

import java.io.IOException;
import java.io.PrintWriter;
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

import Bean.add_delete_change_query;
import Download_list.Model;
import database.database;

public class Analysis extends HttpServlet {

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
		String result1 = new String(request.getParameter("result1"));//.getBytes("ISO-8859-1"),"UTF-8")
		String result2 = new String(request.getParameter("result2"));
		String result3 = new String(request.getParameter("result3"));
		String result4 = new String(request.getParameter("result4"));
		String condition1 = new String(request.getParameter("condition1").getBytes("ISO-8859-1"),"UTF-8");
		String condition2 = new String(request.getParameter("condition2").getBytes("ISO-8859-1"),"UTF-8");
		String condition3 = new String(request.getParameter("condition3").getBytes("ISO-8859-1"),"UTF-8");
		String condition4 = new String(request.getParameter("condition4").getBytes("ISO-8859-1"),"UTF-8");
		String condition5 = new String(request.getParameter("condition5").getBytes("ISO-8859-1"),"UTF-8");
		String condition6 = new String(request.getParameter("condition6").getBytes("ISO-8859-1"),"UTF-8");
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs = null;
        
		try {
			conn = database.getSqlServerConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "select ";
		int i = 0;
		
		if(!result1.equals("")){
			sql=sql+result1;
			i++;
		}	
		if(!result2.equals("")){
			if(i!=0)
				sql=sql+",";
			sql=sql+result2;
			i++;
		}	
		if(!result3.equals("")){
			if(i!=0)
				sql=sql+",";
			sql=sql+result3;
			i++;
		}
		if(!result4.equals("")){
			if(i!=0)
				sql=sql+",";
			sql=sql+result4;
			i++;
		}
		
		sql=sql+" from Analysis where ";
		boolean j = false;
		
		if(!condition1.equals("")){
			sql=sql+condition1;
			j=true;
		}
		if(!condition2.equals("")){
			if(j==true)
				sql=sql+" and ";
			sql=sql+condition2;
			j=true;
		}
		if(!condition3.equals("")){
			if(j==true)
				sql=sql+" and ";
			sql=sql+condition3;
			j=true;
		}
		if(!condition4.equals("")){
			if(j==true)
				sql=sql+" and ";
			sql=sql+condition4;
			j=true;
		}
		if(!condition5.equals("")){
			if(j==true)
				sql=sql+" and ";
			sql=sql+condition5;
			j=true;
		}
		if(!condition6.equals("")){
			if(j==true)
				sql=sql+" and ";
			sql=sql+condition6;
			j=true;
		}
		
		sql=sql+";";
		try {
			conn = database.getSqlServerConnection();
			stmt = (Statement) conn.createStatement();
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		String str = null;
		try {
			while(rs.next()){
				for(int l=1 ; l<=i ; l++){
					str=rs.getString(l);
					list2.add(str);
				}
				list1.add(list2);
				list2 = new ArrayList();
			}
			request.setAttribute("list",list1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Analysis/Query1.jsp");
			dispatcher .forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				/*noname1=Novel.getString("noname");
				start_time1=Novel.getString("start_time");
				finish_time1=Novel.getString("finish_time");
				auname1=Novel.getString("auname");
				
				request.setAttribute("noname", noname1);
				request.setAttribute("start_time", start_time1);
				request.setAttribute("finish_time", finish_time1);
				request.setAttribute("auname", auname1);
*/
		
				
		/*if(sql.equals("select ")){ 
	             JOptionPane.showMessageDialog(null, "²éÑ¯Ê§°Ü", "³ö´íÀ²", JOptionPane.ERROR_MESSAGE);
				 RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Novel/Novel_query.jsp");
	             dispatcher1 .forward(request, response);
		}*/
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
