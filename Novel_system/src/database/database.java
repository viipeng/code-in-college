package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class database {

	private static Connection conn;// 数据库连接对象
	public static Connection getSqlServerConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	    String url = "jdbc:sqlserver://localhost:1433; DatabaseName = Novel_system";  
	    String username = "sa";  
	    String password = "11111";  
	    Class.forName(driverClass);//这步错可能是因为.jar包导入问题  
	    Connection conn = DriverManager.getConnection(url,username,password);//这步错可能是因为数据库属性安全中的名、密码不对或SQL的IP端口不是‘1433’  
	    /*PreparedStatement pStmt = conn.prepareStatement("select * from Reader");  
	           ResultSet rs = pStmt.executeQuery();  
	                while(rs.next()){
	                			System.out.println("读者名： " + rs.getString(1)   
	                            + " 密码： " + rs.getString(4));  
	                }  */
	                System.out.println("数据库连接成功！");
//	     rs.close();  
//	     pStmt.close();   
//	     conn.close();  
	     return conn;
    }
	 public void dbClose() {//关闭连接
	        try {
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}

