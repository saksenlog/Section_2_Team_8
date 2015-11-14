/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.dbutil;

/**
 *
 * @author erikbutler
 */
public interface IConnectionData {
    public String getDriver();
    public String getDBURL();
    public String getUser();
    public String getPass();
}
