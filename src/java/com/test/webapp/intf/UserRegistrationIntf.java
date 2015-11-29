/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.intf;

import com.test.webapp.helper.RegisterUser;

import java.io.Serializable;

/**
 *
 * @author User
 */
public interface UserRegistrationIntf extends Serializable{
    
    public int registerUser(RegisterUser regUser);
     
    
    }
