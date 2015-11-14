/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.unittest;

import com.test.webapp.testdbconnector.TestConnectionData;
import com.test.webapp.testdbconnector.connectionUtil;
import com.test.webapp.dbutil.IConnectionData;
import com.test.webapp.impl.HospitalLoginImpl;
import com.test.webapp.helper.hospital;
import java.sql.Array;
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

/**
 *
 * @author erikbutler
 */
public class getallhospitalsTest {

    IConnectionData connectionData;
    Connection connection;
    Statement statement;
    private HospitalLoginImpl hosp;
    ArrayList<hospital> hs;
    String[] hospArray;

    public getallhospitalsTest() {
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
        hs = new ArrayList();
        hospArray = new String[3];
     //   connectionData = new TestConnectionData();
        connection = null;
        statement = null;
        String updateSQL1 = null;
        String updateSQL2 = null;
        String updateSQL3 = null;
        ResultSet rs = null;
        String updateCheck = null;

        updateSQL1 = "INSERT INTO hospital (userName, hospital_id, hosp_name, address, city, state, zip, email, password) "
                + "VALUES ('name1', 1, 'hosp1', 'test', 'test', 'test', 28117, 'test', 'test')";

        updateSQL2 = "INSERT INTO hospital (userName, hospital_id, hosp_name, address, city, state, zip, email, password) "
                + "VALUES ('name2', 2, 'hosp2', 'test', 'test', 'test', 28117, 'test', 'test')";

        updateSQL3 = "INSERT INTO hospital (userName, hospital_id, hosp_name, address, city, state, zip, email, password) "
                + "VALUES ('name3', 3, 'hosp3', 'test', 'test', 'test', 23112, 'test', 'test')";

    //    connection = connectionUtil.getConnection(connectionData);

        try {
            statement = connection.createStatement();
            statement.executeUpdate(updateSQL1);
            statement.executeUpdate(updateSQL2);
            statement.executeUpdate(updateSQL3);

            rs = statement.executeQuery("SELECT * FROM hospital");
            updateCheck = null;

            System.out.print("SET UP - HOSPITALS STORED IN DATABASE: ");
            while (rs.next()) {
                updateCheck = rs.getString("hosp_name");
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

     //   connection = connectionUtil.getConnection(connectionData);

        try {
            statement = connection.createStatement();

            command = "TRUNCATE hospital";
            statement.executeUpdate(command);

            command = "DELETE FROM hospital";
            statement.executeUpdate(command);

            rs = statement.executeQuery("SELECT * FROM hospital");

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
    public void gethospitals() throws ClassNotFoundException, SQLException {
     //   hs = hosp.getallhospital("test");
        //System.out.println(hs.size());
        int i = 0;
        for (hospital h : hs) {
            hospArray[i] = h.getHospitalName();
            i++;
        }
        
        //checking to see if correct hospital names were returned 
        //and if all hospitals in db were returned
        assertEquals("hosp1", hospArray[0]);
        assertEquals("hosp2", hospArray[1]);
        assertEquals("hosp3", hospArray[2]);
        assertEquals(3, hs.size());

    }
}
