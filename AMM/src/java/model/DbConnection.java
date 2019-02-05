/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federicadessi
 */
public class DbConnection {
    private static DbConnection singleton;
    private DbConnection(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex)
        {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DbConnection getInstance(){
        if(singleton == null)
        {
            singleton =  new DbConnection();
        }
        return singleton;
    }
    
    public Connection getConnection()
    {
        Connection conn=null;
        String str_conn = "jdbc:mysql://ec2-52-47-198-123.eu-west-3.compute.amazonaws.com:443/fpw18_dessifederica";
        try
        {
            conn = DriverManager.getConnection(str_conn, "fpw18_dessifederica", "dessiFederica");
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
         return conn;
    }
}
