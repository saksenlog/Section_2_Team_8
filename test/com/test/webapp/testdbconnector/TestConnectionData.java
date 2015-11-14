/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.testdbconnector;

/**
 *
 * @author erikbutler
 */
public class TestConnectionData implements IConnectionData {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/organ";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    


    public String getDriver(){
        return DRIVER;
    }
    
    public String getDBURL(){
        return DBURL;
    }
    
    public String getUser(){
        return USER;
    }
    
    public String getPass(){
        return PASSWORD;
    }
}
