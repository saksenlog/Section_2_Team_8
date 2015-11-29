/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.impl;

import com.test.webapp.dbconnector.ConnectionManager;
import com.test.webapp.helper.DeclareDonor;
import com.test.webapp.intf.DonorDeclarationIntf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class DonorDeclarationImpl implements DonorDeclarationIntf {

    @Override
    public int declareDonor(DeclareDonor decDonor) {
       
    Connection conn = null;
        ConnectionManager conMangerObj = new ConnectionManager();
        try {
              conn = conMangerObj.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DonorDeclarationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        StringBuffer sBufSelect = new StringBuffer(" ");
        
  
        
        Statement selStateObj = null;
        try {
            selStateObj = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DonorDeclarationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet resultSet = null;
        try {
            resultSet = selStateObj.executeQuery(sBufSelect.toString());
        } catch (SQLException ex) {
            Logger.getLogger(DonorDeclarationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
        StringBuffer sBufQuery = new StringBuffer("");
        
        PreparedStatement stateObj = null;
       
      //  HttpSession session=requrs
        
        // stateObj = conn.prepareStatement("select  from user where  and User_Role =?");
      
        
        sBufQuery.append(" INSERT INTO DONOR(User_id,Interest,Custodian1,Custodian_Email1,Custodian2,Custodian_Email2");
        sBufQuery.append(",Custodian3,Custodian_Email3,Custodian4,Custodian_Email4) VALUES(?,?,?,?,?,?,?,?,?,?)");
        
        try {
            stateObj = conn.prepareStatement(sBufQuery.toString());
        
        int i = 1;    
       
        stateObj.setString(i, decDonor.getUser_id());i=i+1;
        stateObj.setString(i, decDonor.getInterest());i=i+1;
        stateObj.setString(i, decDonor.getCustodian1());i=i+1;
        stateObj.setString(i, decDonor.getEmailId1());i=i+1;
        stateObj.setString(i, decDonor.getCustodian2());i=i+1;
        stateObj.setString(i, decDonor.getEmailId2());i=i+1;
        stateObj.setString(i, decDonor.getCustodian3());i=i+1;
        stateObj.setString(i, decDonor.getEmailId3());i=i+1;
        stateObj.setString(i, decDonor.getCustodian4());i=i+1;
        stateObj.setString(i, decDonor.getEmailId4());
        
        
                } catch (SQLException ex) {
            Logger.getLogger(DonorDeclarationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        int iRetValue = 0;
        
        try {
             iRetValue= stateObj.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonorDeclarationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return iRetValue;
    }
    
}
