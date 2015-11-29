/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.impl;

import com.test.webapp.dbconnector.ConnectionManager;
import com.test.webapp.helper.RegisterUser;
import com.test.webapp.helper.hospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author User
 */

public class CustodianLoginImpl {
    
    public static boolean validate(String userName, String password,String donor) {    
        
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
    public static boolean validatedonorid(String email,String donorid) throws ClassNotFoundException, SQLException{
        int count =0;
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/organ","root", "");
    String query = "select * from donor where User_id='"+donorid+"' and (Custodian_Email1='"+email+"' or Custodian_Email2='"+email+"' or Custodian_Email3='"+email+"' or Custodian_Email4='"+email+"')";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    
    while (rs.next())
    {
    count ++;
    }
  
    if(count>0){
        return true;
    }else{
        return false;
    }
        
        
        }
     public static RegisterUser getlogindetails(String username) throws ClassNotFoundException, SQLException{
       RegisterUser db = new RegisterUser();
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/organ","root","");
    String query = "select user_name,First_name,Last_Name,Email_address,Address1,Address2,City,State from user where user_name='"+username+"'";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    
    while (rs.next())
    {
     db.setUserName(rs.getString("user_name"));
     db.setFirstName(rs.getString("First_name"));
     db.setLastName(rs.getString("Last_Name"));
     db.setEmailId(rs.getString("Email_address"));
     db.setAddress1(rs.getString("Address1"));
     db.setAddress2(rs.getString("Address2"));
     db.setCity(rs.getString("City"));
     db.setState(rs.getString("State"));
    }
  
       return db; 
        
        
        }
      public static RegisterUser getlogindetailsdonor(String donorid) throws ClassNotFoundException, SQLException{
       RegisterUser db = new RegisterUser();
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/organ","root","");
    String query = "select user_name,First_name,Last_Name,Email_address,Address1,Address2,City,State,zip,Desired_Hospital_ID from user where user_id='"+donorid+"'";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    
    while (rs.next())
    {
     db.setUserName(rs.getString("user_name"));
     db.setFirstName(rs.getString("First_name"));
     db.setLastName(rs.getString("Last_Name"));
     db.setEmailId(rs.getString("Email_address"));
     db.setAddress1(rs.getString("Address1"));
     db.setAddress2(rs.getString("Address2"));
     db.setCity(rs.getString("City"));
     db.setState(rs.getString("State"));
     db.setZip(rs.getString("zip"));
     db.setDesiredHospital(rs.getInt("Desired_Hospital_ID"));
    }
  
       return db; 
        
        
        }
       public static boolean validatezip(String zip) {    
        
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
            pst = conn.prepareStatement("select * from hospital where zip=?");
            
            pst.setString(1, zip);
        
            
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
        public static ArrayList<hospital> getallhospital() throws ClassNotFoundException, SQLException{
       ArrayList<hospital> hs =new ArrayList();
       
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/organ","root","");
    String query = "select * from hospital";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    
    while (rs.next())
    {
       hospital db = new hospital(); 
     db.setHospitalName(rs.getString("hosp_name"));
     db.setAddress(rs.getString("address"));
     db.setCity(rs.getString("city"));
     db.setState(rs.getString("state"));
     db.setZip(rs.getString("zip"));
     db.setEmail(rs.getString("email"));
     db.setHid(Integer.parseInt(rs.getString("hospital_id")));
    hs.add(db);
    }
   
       return hs; 
        
        
        }
}
