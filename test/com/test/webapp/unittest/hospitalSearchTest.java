/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.unittest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.test.webapp.testdbconnector.connectionUtil;
import com.test.webapp.dbutil.IConnectionData;
import com.test.webapp.testdbconnector.TestConnectionData;
import com.test.webapp.impl.HospitalLoginImpl;

/**
 *
 * @author erikbutler
 */
public class hospitalSearchTest {
    
    Boolean hospitalMatch;
    HospitalLoginImpl hosp;

    
    public hospitalSearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        hosp = new HospitalLoginImpl();
     //   IConnectionData connectionData = new TestConnectionData();
        Connection connection = null;
        Statement statement = null;
        String updateSQL1 = null;
        String updateSQL2 = null;
        String updateSQL3 = null;
        ResultSet rs = null;
        String updateCheck = null;
        
        updateSQL1 = "INSERT INTO hospital (userName, hospital_id, hosp_name, address, city, state, zip, email, password) "
                + "VALUES ('name1', 1, 'hosp1-28117', 'test', 'test', 'test', 28117, 'test', 'test')";
        
        updateSQL2 = "INSERT INTO hospital (userName, hospital_id, hosp_name, address, city, state, zip, email, password) "
                + "VALUES ('name2', 2, 'hosp2-28117', 'test', 'test', 'test', 28117, 'test', 'test')";
        
        updateSQL3 = "INSERT INTO hospital (userName, hospital_id, hosp_name, address, city, state, zip, email, password) "
                + "VALUES ('name3', 3, 'hosp3-23112', 'test', 'test', 'test', 23112, 'test', 'test')";
        
      //  connection = connectionUtil.getConnection(connectionData);
        
        try {
            statement = connection.createStatement();
            statement.executeUpdate(updateSQL1);
            statement.executeUpdate(updateSQL2);
            statement.executeUpdate(updateSQL3);
            
            rs = statement.executeQuery("SELECT * FROM hospital");
            updateCheck = null;
            
            System.out.print("HOSPITALS STORED IN DATABASE: ");
            while(rs.next()){
               updateCheck = rs.getString("hosp_name");
               System.out.print(updateCheck + ", ");
            }
            System.out.println();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown() {
    //    IConnectionData connectionData = new TestConnectionData();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String command = null;
        String updateCheck = null;
        
        
     //   connection = connectionUtil.getConnection(connectionData);
        
        try {
            statement = connection.createStatement();
            
            command = "TRUNCATE hospital";
            statement.executeUpdate(command);
            
            command = "DELETE FROM hospital";
            statement.executeUpdate(command);
            
            rs = statement.executeQuery("SELECT * FROM hospital");
            updateCheck = null;
            
            if(rs.next()){
               updateCheck = rs.getString("zip");
             }
            else
            updateCheck = "none";
            
            System.out.println("HOSPITAL DATA REMAINING: " + updateCheck);
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void zipMatch() {
     //    hospitalMatch = hosp.validatezip("28117", "test");
         assertTrue(hospitalMatch);
     }
     
     @Test
     public void zipNoMatch(){
      //   hospitalMatch = hosp.validatezip("55555", "test");
         assertFalse(hospitalMatch);
     }
    
}
