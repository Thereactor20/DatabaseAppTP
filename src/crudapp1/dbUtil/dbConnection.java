/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudapp1.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author krijan
 */
public class dbConnection {
    private Connection conn= null;
    private PreparedStatement stmt= null;
    
    public void connect()throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/krijan", "root", "");
    }
    
    public PreparedStatement iniStatement(String sql)throws SQLException{
        stmt=conn.prepareStatement(sql);
        return stmt;
    }
    
    public int executeUpdate() throws SQLException{
        return stmt.executeUpdate();
    }
    
   public ResultSet executeQuery() throws SQLException{
       return stmt.executeQuery();
   }
    
    public void close()throws SQLException{
        if(conn!=null && !conn.isClosed()){
            conn.close();
            conn=null;
        }
    }
}
