/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.impl;

import com.test.webapp.dbconnector.ConnectionManager;
import com.test.webapp.helper.RegisterUser;
import com.test.webapp.helper.hospital;
import com.test.webapp.helper.organs;
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

public class HospitalLoginImpl {
  
    public static boolean validate(String userName, String password) {    
        
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
            pst = conn.prepareStatement("select * from hospital where userName=? and password=?");
            
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
    
  
    public static RegisterUser getlogindetails(String donorid) throws ClassNotFoundException, SQLException{
       RegisterUser db = new RegisterUser();
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/organ","root", "");
    String query = "select user_name,First_name,Last_Name,Email_address,Address1,Address2,City,State from user where user_id='"+donorid+"'";
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
    
     public static boolean validatedonorid(String donorid) {    
        
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
            pst = conn.prepareStatement("select * from user where user_id=?");
            
            pst.setString(1, donorid);
        
            
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
     public static boolean validateorgan(String organ) {    
        
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
            pst = conn.prepareStatement("select * from organs where organ_name=?");
            
            pst.setString(1, organ);
        
            
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
      public static int registerhospital(hospital hos){
        
        Connection conn = null;
        ConnectionManager conMangerObj = new ConnectionManager();
        try {
              conn = conMangerObj.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRegistrationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StringBuffer sBufSelect = new StringBuffer(" ");
        
        sBufSelect.append(" SELECT MAX(hospital_id) AS hospital_id FROM hospital");
        
        Statement selStateObj = null;
        try {
            selStateObj = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserRegistrationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet resultSet = null;
        try {
            resultSet = selStateObj.executeQuery(sBufSelect.toString());
        } catch (SQLException ex) {
            Logger.getLogger(UserRegistrationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int iMaxId = 0;
        try {
            while(resultSet.next()){
                iMaxId = resultSet.getInt("hospital_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRegistrationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        StringBuffer sBufQuery = new StringBuffer("");
        
        PreparedStatement stateObj = null;
        
        
        
        sBufQuery.append(" INSERT INTO hospital(hospital_id,userName,hosp_name,address,city,state");
        sBufQuery.append(",zip,email,password) VALUES(?,?,?,?,?,?,?,?,?)");
        
        try {
            stateObj = conn.prepareStatement(sBufQuery.toString());
        iMaxId++;
        int i = 1;    
        stateObj.setInt(i,iMaxId);i=i+1;
        stateObj.setString(i, hos.getUsername());i=i+1;
        stateObj.setString(i, hos.getHospitalName());i=i+1;
        stateObj.setString(i, hos.getAddress());i=i+1;
        stateObj.setString(i, hos.getCity());i=i+1;
        stateObj.setString(i, hos.getState());i=i+1;
        stateObj.setString(i, hos.getZip());i=i+1;
        stateObj.setString(i, hos.getEmail());i=i+1;
        stateObj.setString(i, hos.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(UserRegistrationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        int iRetValue = 0;
        
        try {
             iRetValue= stateObj.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserRegistrationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return iRetValue;
    }
     public static ArrayList<hospital> getallhospital() throws ClassNotFoundException, SQLException{
       ArrayList<hospital> hs =new ArrayList();
       
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/organ","root", "");
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
     public static ArrayList<organs> getallorgans() throws ClassNotFoundException, SQLException{
       ArrayList<organs> or =new ArrayList();
       
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/organ","root", "");
    String query = "select * from organs";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    
    while (rs.next())
    {
       organs db = new organs(); 
     db.setDonorid(rs.getString("donor_id"));
     db.setOrganid(rs.getString("organ_id"));
     db.setOrganname(rs.getString("organ_name"));
     db.setBloodgroup(rs.getString("bloodgroup"));
     db.setHospid(rs.getString("hospital_id"));
     db.setAvail(rs.getString("availabilty"));
    or.add(db);
    }
   
       return or; 
     }


    
}
