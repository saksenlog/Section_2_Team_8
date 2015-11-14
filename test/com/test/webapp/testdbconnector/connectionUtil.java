/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.testdbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author erikbutler
 */
public class connectionUtil {
    
    public static Connection getConnection(IConnectionData connectionData){
        Connection connection = null;
        Class.forName(connectionData.getDriver());
        connection = DriverManager.getConnection(
                connectionData.getDBURL(),
                connectionData.getUser(),
                connectionData.getPass());
        return connection;
    }
    
}
