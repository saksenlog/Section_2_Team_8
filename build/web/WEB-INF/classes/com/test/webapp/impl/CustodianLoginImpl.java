/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.impl;

import com.test.webapp.dbconnector.ConnectionManager;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author User
 */

public class CustodianLoginImpl {
    
    public static boolean validate(String userName, String password) {    
        
        boolean status = false;
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        ConnectionManager conMangerObj = new ConnectionManager();
        try {
              conn = conMangerObj.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustodianLoginImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            pst = conn.prepareStatement("select * from user where user_name=? and Password=?");
            
            pst.setString(1, userName);
            pst.setString(2, password); 
            
            rs = pst.executeQuery();  
            status = rs.next();
        } catch(Exception e) {
            System.out.println(e);
                    }
        finally{
            if(conn != null){
                try{
                    conn.close();                 
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
            if(pst != null){
                try{
                    pst.close();                 
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(rs != null){
                try{
                    rs.close();                 
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        
     return status;   
        
        
    }
    
}
