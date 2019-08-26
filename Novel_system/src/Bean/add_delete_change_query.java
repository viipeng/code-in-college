package Bean;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import database.database;

public class add_delete_change_query {


    Connection conn=null;
    Statement stmt=null;
    
    public int add(String s) throws ClassNotFoundException{
        try {
        	conn = database.getSqlServerConnection();
            stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(s);
            System.out.print("--添加语句:"+s+"\n");
            return 1;
        } catch (SQLException e) {
            System.out.print("--添加语句:"+s+"\n");
            JOptionPane.showMessageDialog(null, "添加失败", "出错啦", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int delete(String s) throws ClassNotFoundException{
        try {
        	conn = database.getSqlServerConnection();
            stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(s);
            return 1;
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "删除失败", "出错啦", JOptionPane.ERROR_MESSAGE);
        	return 0;
        }
    }
    
    public int change(String s) throws SQLException, ClassNotFoundException {
    	conn = database.getSqlServerConnection();
        stmt = (Statement) conn.createStatement();
        System.out.println("--更新语句:"+s+"\n");
        try {
            stmt.executeUpdate(s);
            return 1;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "更新失败", "出错啦", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public ResultSet query(String s) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
    	conn = database.getSqlServerConnection();
        stmt = (Statement) conn.createStatement();
        System.out.print("--查询语句:"+s+"\n");
        try {
            rs = stmt.executeQuery(s);
        } catch (Exception ex) {
        	System.out.println("查询失败！");
        }
        return rs;
    }

    public void close() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
    }
/*	//执行插入     
    public void doInsert(String sql) {     
     try {      
         stmt = (Statement) conn.createStatement();
         int i = stmt.executeUpdate(sql);     
     } catch(SQLException sqlexception) {     
         System.err.println("db.executeInset:" + sqlexception.getMessage());     
     }finally{     
              
     }     
 }     
 //执行删除     
 public void doDelete(String sql) {     
     try {     
         stmt = conn.createStatement();     
         int i = stmt.executeUpdate(sql);     
     } catch(SQLException sqlexception) {     
         System.err.println("db.executeDelete:" + sqlexception.getMessage());     
     }     
 }     
 //执行更新     
 public void doUpdate(String sql) {     
     try {     
         stmt = conn.createStatement();     
         int i = stmt.executeUpdate(sql);     
     } catch(SQLException sqlexception) {     
         System.err.println("db.executeUpdate:" + sqlexception.getMessage());     
     }     
 }     
 //查询结果集     
 public ResultSet doSelect(String sql) {     
     try {  
         conn=DriverManager.getConnection(url,user,password);  
         stmt = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);       
         rs = stmt.executeQuery(sql);   
         System.out.println("取得结果集");  
     } catch(SQLException sqlexception) {     
         System.err.println("db.executeQuery: " + sqlexception.getMessage());     
     }     
     return rs;     
 }*/
}
