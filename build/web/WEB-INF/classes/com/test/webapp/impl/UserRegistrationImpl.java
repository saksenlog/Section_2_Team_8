/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.impl;

import com.test.webapp.dbconnector.ConnectionManager;
import com.test.webapp.helper.RegisterUser;
import com.test.webapp.intf.UserRegistrationIntf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UserRegistrationImpl implements UserRegistrationIntf{
  
    public  int registerUser(RegisterUser regUser){
        
        Connection conn = null;
        ConnectionManager conMangerObj = new ConnectionManager();
        try {
              conn = conMangerObj.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRegistrationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StringBuffer sBufSelect = new StringBuffer(" ");
        
        sBufSelect.append(" SELECT MAX(USER_ID) AS USER_ID FROM USER");
        
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
                iMaxId = resultSet.getInt("USER_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRegistrationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        StringBuffer sBufQuery = new StringBuffer("");
        
        PreparedStatement stateObj = null;
        
        
        
        sBufQuery.append(" INSERT INTO USER(USER_ID,USER_NAME,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,PASSWORD");
        sBufQuery.append(",ADDRESS1,ADDRESS2,CITY,STATE,USER_ROLE,zip) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        
        try {
            stateObj = conn.prepareStatement(sBufQuery.toString());
        iMaxId++;
        int i = 1;    
        stateObj.setInt(i,iMaxId);i=i+1;
        stateObj.setString(i, regUser.getUserName());i=i+1;
        stateObj.setString(i, regUser.getFirstName());i=i+1;
        stateObj.setString(i, regUser.getLastName());i=i+1;
        stateObj.setString(i, regUser.getEmailId());i=i+1;
        stateObj.setString(i, regUser.getPassWord());i=i+1;
        stateObj.setString(i, regUser.getAddress1());i=i+1;
        stateObj.setString(i, regUser.getAddress2());i=i+1;
        stateObj.setString(i, regUser.getCity());i=i+1;
        stateObj.setString(i, regUser.getState());i=i+1;
        stateObj.setString(i, regUser.getUserRole());i=i+1;
        stateObj.setString(i, regUser.getZip());
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
    
    
}
