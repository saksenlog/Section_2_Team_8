/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.unittest;

import com.test.webapp.dbutil.IConnectionData;
import com.test.webapp.testdbconnector.TestConnectionData;
import com.test.webapp.testdbconnector.connectionUtil;
import com.test.webapp.impl.HospitalLoginImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author erikbutler
 */
public class donorDetailsTest {

    IConnectionData connectionData;
    Connection connection;
    Statement statement;
    private HospitalLoginImpl hosp;
    boolean donors;
    
    public donorDetailsTest() {
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
     //   connectionData = new TestConnectionData();
        connection = null;
        statement = null;
        String updateSQL1 = null;
        String updateSQL2 = null;
        String updateSQL3 = null;
        ResultSet rs = null;
        String updateCheck = null;

        updateSQL1 = "INSERT INTO user (USER_ID,USER_NAME,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,PASSWORD,ADDRESS1,ADDRESS2,CITY,STATE,USER_ROLE,zip)"
                + "VALUES (1,'D1','test','test','test@1','test','test','test','test','test','test','test')";
        updateSQL2 = "INSERT INTO user (USER_ID,USER_NAME,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,PASSWORD,ADDRESS1,ADDRESS2,CITY,STATE,USER_ROLE,zip)"
                + "VALUES (2,'D2','test','test','test@2','test','test','test','test','test','test','test')";
        updateSQL3 = "INSERT INTO user (USER_ID,USER_NAME,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,PASSWORD,ADDRESS1,ADDRESS2,CITY,STATE,USER_ROLE,zip)"
                + "VALUES (3,'D3','test','test','test@3','test','test','test','test','test','test','test')";

      //  connection = connectionUtil.getConnection(connectionData);

        try {
            statement = connection.createStatement();
            statement.executeUpdate(updateSQL1);
            statement.executeUpdate(updateSQL2);
            statement.executeUpdate(updateSQL3);

            rs = statement.executeQuery("SELECT * FROM user");
            updateCheck = null;

            System.out.print("SET UP - DONORS STORED IN DATABASE: ");
            while (rs.next()) {
                updateCheck = rs.getString("USER_ID");
                System.out.print(updateCheck + ", ");
            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown() {
     //   connectionData = new TestConnectionData();
        connection = null;
        statement = null;
        ResultSet rs = null;
        String command = null;

      //  connection = connectionUtil.getConnection(connectionData);

        try {
            statement = connection.createStatement();

            command = "TRUNCATE user";
            statement.executeUpdate(command);

            command = "DELETE FROM user";
            statement.executeUpdate(command);

            rs = statement.executeQuery("SELECT * FROM user");

            if (rs.next()) {
                System.out.println("TEAR DOWN - TABLE DATA UNSUCCESSFULLY CLEARED");
            } else {
                System.out.println("TEAR DOWN - TABLE DATA SUCCESSFULLY CLEARED");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void matchDonor() {
    //    donors = hosp.validatedonorid("1", "test");
        assertTrue(donors);
    }
    @Test
    public void noMatchDonor() {
      //  donors = hosp.validatedonorid("5", "test");
        assertFalse(donors);
    }
}
