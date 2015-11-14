/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.impl;

import com.test.webapp.dbconnector.ConnectionManager;
import com.test.webapp.helper.Donor;
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

public class DonorLoginImpl {
    
    public static boolean validate(String userName,String password ,String donor) {    
        
        boolean status = false;
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        ConnectionManager conMangerObj = new ConnectionManager();
        try {
              conn = conMangerObj.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DonorLoginImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            
          //  String str="select * from user where user_name='userName'";
            pst = conn.prepareStatement("select * from user where user_name=? and Password=? and User_Role =?");
            
            pst.setString(1, userName);
            pst.setString(2, password); 
            pst.setString(3, donor);
            
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
    public static boolean updateuser(String name,String hname,int hid)
  {
      
          boolean status = false;
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        ConnectionManager conMangerObj = new ConnectionManager();
        try {
              conn = conMangerObj.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DonorLoginImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    try
    {
     
      // create the java mysql update preparedstatement
      String query = "update user set Desired_Hospital = ?, Desired_Hospital_ID = ? where user_name = ?";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString(1, hname);
      preparedStmt.setInt(2, hid);
      preparedStmt.setString(3, name);
 
              // execute the java preparedstatement
              int executeUpdate = preparedStmt.executeUpdate();
          if(executeUpdate == 1){
              status = true;
              
          }
          else{
              status = false;
          }
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    return status;
  }
    
}
