/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.helper;

/**
 *
 * @author User
 */
public class Donor {
    String donorUserName;
      String donorUsPassword;
      
      public Donor ()
      {
      }

    public String getDonorUserName() {
        return donorUserName;
    }

    public void setDonorUserName(String donorUserName) {
        this.donorUserName = donorUserName;
    }

    public String getDonorUsPassword() {
        return donorUsPassword;
    }

    public void setDonorUsPassword(String donorUsPassword) {
        this.donorUsPassword = donorUsPassword;
    }
    
}
