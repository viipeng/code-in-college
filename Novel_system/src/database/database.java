package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class database {

	private static Connection conn;// ���ݿ����Ӷ���
	public static Connection getSqlServerConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	    String url = "jdbc:sqlserver://localhost:1433; DatabaseName = Novel_system";  
	    String username = "sa";  
	    String password = "11111";  
	    Class.forName(driverClass);//�ⲽ���������Ϊ.jar����������  
	    Connection conn = DriverManager.getConnection(url,username,password);//�ⲽ���������Ϊ���ݿ����԰�ȫ�е��������벻�Ի�SQL��IP�˿ڲ��ǡ�1433��  
	    /*PreparedStatement pStmt = conn.prepareStatement("select * from Reader");  
	           ResultSet rs = pStmt.executeQuery();  
	                while(rs.next()){
	                			System.out.println("�������� " + rs.getString(1)   
	                            + " ���룺 " + rs.getString(4));  
	                }  */
	                System.out.println("���ݿ����ӳɹ���");
//	     rs.close();  
//	     pStmt.close();   
//	     conn.close();  
	     return conn;
    }
	 public void dbClose() {//�ر�����
	        try {
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}

