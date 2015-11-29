/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.dbconnector;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ConnectionManager {
    
Connection conn = null;

// Returns the database connection object
public Connection getConnection() throws ClassNotFoundException{
    
    
    
    Connection conn = null;
try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/organ","root", "");
    System.out.println("Database connected!");
} catch (SQLException e) {
    throw new IllegalStateException("Cannot connect the database!", e);
}catch(ClassNotFoundException erClassNotFnd){
    //Logger.getLogger("")
}
        
    
    
    return conn;
}
   

}
