/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.unittest;

import com.test.webapp.dbconnector.IConnectionData;
import com.test.webapp.dbconnector.TestConnectionData;
import com.test.webapp.dbconnector.connectionUtil;

import com.test.webapp.impl.HospitalLoginImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.test.webapp.helper.organs;

/**
 *
 * @author erikbutler
 */
public class organSearchTest {

    IConnectionData connectionData;
    Connection connection;
    Statement statement;
    private HospitalLoginImpl hosp;
    boolean organs;

    public organSearchTest() {
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
        connectionData = new TestConnectionData();
        connection = null;
        statement = null;
        String updateSQL1 = null;
        String updateSQL2 = null;
        String updateSQL3 = null;
        ResultSet rs = null;
        String updateCheck = null;

        updateSQL1 = "INSERT INTO organs (donor_id, organ_id, organ_name, hospital_id, availabilty) "
                + "VALUES (01, 01, 'heart', 01, 'test')";
        updateSQL2 = "INSERT INTO organs (donor_id, organ_id, organ_name, hospital_id, availabilty) "
                + "VALUES (02, 02, 'appendix', 02, 'test')";
        updateSQL3 = "INSERT INTO organs (donor_id, organ_id, organ_name, hospital_id, availabilty) "
                + "VALUES (03, 03,'appendix', 03, 'test')";

        connection = connectionUtil.getConnection(connectionData);

        try {
            statement = connection.createStatement();
            statement.executeUpdate(updateSQL1);
            statement.executeUpdate(updateSQL2);
            statement.executeUpdate(updateSQL3);

            rs = statement.executeQuery("SELECT * FROM organs");
            updateCheck = null;

            System.out.print("SET UP - ORGANS STORED IN DATABASE: ");
            while (rs.next()) {
                updateCheck = rs.getString("organ_name");
                System.out.print(updateCheck + ", ");
            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        connectionData = new TestConnectionData();
        connection = null;
        statement = null;
        ResultSet rs = null;
        String command = null;

        connection = connectionUtil.getConnection(connectionData);

        try {
            statement = connection.createStatement();

            command = "TRUNCATE organs";
            statement.executeUpdate(command);

            command = "DELETE FROM organs";
            statement.executeUpdate(command);

            rs = statement.executeQuery("SELECT * FROM organs");

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
    public void organMatch() throws ClassNotFoundException, SQLException {
        organs = hosp.validateorgan("appendix", "test");
        assertTrue(organs);
    }

    @Test
    public void organNoMatch() throws ClassNotFoundException, SQLException {
        organs = hosp.validateorgan("liver", "test");
        assertFalse(organs);
    }
}
