/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.servlet;

import com.test.webapp.constants.CommonConstants;
import com.test.webapp.helper.DeclareDonor;
import com.test.webapp.helper.RegisterUser;
import com.test.webapp.impl.DonorDeclarationImpl;
import com.test.webapp.impl.UserRegistrationImpl;
import com.test.webapp.intf.DonorDeclarationIntf;
import com.test.webapp.intf.UserRegistrationIntf;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.Part;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author User
 */
public class DonorDeclarationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
       
        DeclareDonor decDonor =new DeclareDonor();
        
//        DeclareDonor decDonor = createDonorObj(request);
          decDonor.setInterest(request.getParameter("Interest"));
        decDonor.setCustodian1(request.getParameter("Custodian1Name"));
        decDonor.setEmailId1(request.getParameter("Custodian1Email"));
        decDonor.setCustodian2(request.getParameter("Custodian2Name"));
        decDonor.setEmailId2(request.getParameter("Custodian2Email"));
        decDonor.setCustodian3(request.getParameter("Custodian3Name"));
        decDonor.setEmailId3(request.getParameter("Custodian3Email"));
        decDonor.setCustodian4(request.getParameter("Custodian4Name"));
        decDonor.setEmailId4(request.getParameter("Custodian4Email"));
        decDonor.setUser_id(request.getParameter("User_id"));
        
        //email
        HttpSession session = request.getSession();
      String dname =  (String) session.getAttribute("name");
         String senderEmail = "organdonorlive@gmail.com";
    String Custodian1Email =request.getParameter("Custodian1Email"); //request.getParameter("Custodian1Email");
    String Custodian2Email = request.getParameter("Custodian2Email");
    String Custodian3Email = request.getParameter("Custodian3Email");
    String Custodian4Email = request.getParameter("Custodian4Email");
    if(Custodian2Email.isEmpty() || Custodian3Email.isEmpty() || Custodian1Email.isEmpty() || Custodian4Email.isEmpty()){
         request.setAttribute("DeclareValid", "false");
          RequestDispatcher dispatcherObj = request.getRequestDispatcher("/DonorDeclaration.jsp");
        dispatcherObj.forward(request, response);
    }
    else{
         DonorDeclarationIntf donDeclareIntf;
        donDeclareIntf = new DonorDeclarationImpl();
        int declareValid = donDeclareIntf.declareDonor(decDonor);
    
    String userMessage = "You have been assigned as a CUSTODIAN FOR Donor : "+request.getParameter("User_id");
String subject = dname+" has added you as custodian";
  String body1 = "Dear " + request.getParameter("Custodian1Name")  + ",\n\n" ;
           body1 += " <div>" ;
                 body1 +=   "<div>";
            body1 +=     "Greetings! from Organdonnorlive.com " ;
             body1 += " <div>" ;
                 body1 +=   "<div>";
              body1 +=   "You have been assigned as a Custodian of donor name "+" "+dname+"\n\n" ;
            body1 += " <div>" ;
                 body1 +=   "<div>";
              body1 +=     "Please Register yourself as a custodian in organdonorlive.com and while login please use this Donor id for reference"+" = "+request.getParameter("User_id")+"\n\n";
               body1 += " <div>" ;
                 body1 +=   "<div>";
          body1 +=     "Thanks ";
           body1 += " <div>" ;
                 body1 +=   "<div>";
               body1 +=          "organdonorlive.com";
                String body2 = "Dear " + request.getParameter("Custodian2Name")  + ",\n\n" ;
           body2 += " <div>" ;
                 body2 +=   "<div>";
            body2 +=     "Greetings! from Organdonnorlive.com " ;
             body2 += " <div>" ;
                 body2 +=   "<div>";
              body2 +=   "You have been assigned as a Custodian of donor name "+" "+dname+"\n\n" ;
            body2 += " <div>" ;
                 body2 +=   "<div>";
              body2 +=     "Please Register yourself as a custodian in organdonorlive.com and while login please use this Donor id for reference"+" = "+request.getParameter("User_id")+"\n\n";
               body2 += " <div>" ;
                 body2 +=   "<div>";
          body2 +=     "Thanks ";
           body2 += " <div>" ;
                 body2 +=   "<div>";
               body2 +=          "organdonorlive.com";
                String body3 = "Dear " + request.getParameter("Custodian3Name")  + ",\n\n" ;
           body3 += " <div>" ;
                 body3 +=   "<div>";
            body3 +=     "Greetings! from Organdonnorlive.com " ;
             body3 += " <div>" ;
                 body3 +=   "<div>";
              body3 +=   "You have been assigned as a Custodian of donor name "+" "+dname+"\n\n" ;
            body3 += " <div>" ;
                 body3 +=   "<div>";
              body3 +=     "Please Register yourself as a custodian in organdonorlive.com and while login please use this Donor id for reference"+" = "+request.getParameter("User_id")+"\n\n";
               body3 += " <div>" ;
                 body3 +=   "<div>";
          body3 +=     "Thanks ";
           body3 += " <div>" ;
                 body3 +=   "<div>";
               body3 +=          "organdonorlive.com";
                String body4 = "Dear " + request.getParameter("Custodian4Name")  + ",\n\n" ;
           body4 += " <div>" ;
                 body4 +=   "<div>";
            body4 +=     "Greetings! from Organdonnorlive.com " ;
             body4 += " <div>" ;
                 body4 +=   "<div>";
              body4 +=   "You have been assigned as a Custodian of donor name "+" "+dname+"\n\n" ;
            body4 += " <div>" ;
                 body4 +=   "<div>";
              body4 +=     "Please Register yourself as a custodian in organdonorlive.com and while login please use this Donor id for reference"+" = "+request.getParameter("User_id")+"\n\n";
               body4 += " <div>" ;
                 body4 +=   "<div>";
          body4 +=     "Thanks ";
           body4 += " <div>" ;
                 body4 +=   "<div>";
               body4 +=          "organdonorlive.com";
        boolean isBodyHTML = true;
        try {
            MailUtil.sendMail(Custodian1Email, senderEmail, subject, body1, isBodyHTML);
            MailUtil.sendMail(Custodian2Email, senderEmail, subject, body2, isBodyHTML);
            MailUtil.sendMail(Custodian3Email, senderEmail, subject, body3, isBodyHTML);
            MailUtil.sendMail(Custodian4Email, senderEmail, subject, body4, isBodyHTML);
        }
        catch(MessagingException e) {
            this.log(
                "Unable to send email. \n" +
                "You may need to configure your system as " +
                "Here is the email you tried to send: \n" +
                "=====================================\n" +
                "TO: " + Custodian1Email + "\n" +
                "FROM: " + senderEmail + "\n" +
                "SUBJECT: " + subject + "\n" +
                "\n" +
                body1 + "\n\n");
        }
        
        //email
        if(declareValid == CommonConstants.INT_SUCCESS){
            request.setAttribute("DeclareValid", CommonConstants.TRUE);
        }else{
            request.setAttribute("DeclareValid", "false");
        }
        
        RequestDispatcher dispatcherObj = request.getRequestDispatcher("/DonorDeclaration.jsp");
        dispatcherObj.forward(request, response);
    }}
private DeclareDonor createDonorObj(HttpServletRequest request){
        
        DeclareDonor decDonor = new DeclareDonor();
     //   String name = request.getRemoteUser();
     //   decDonor.setUser_id(request.getParameter("name"));
        
//        decDonor.setInterest(request.getParameter("Interest"));
//        decDonor.setCustodian1(request.getParameter("Custodian1Name"));
//        decDonor.setEmailId1(request.getParameter("Custodian1Email"));
//        decDonor.setCustodian2(request.getParameter("Custodian2Name"));
//        decDonor.setEmailId2(request.getParameter("Custodian2Email"));
//        decDonor.setCustodian3(request.getParameter("Custodian3Name"));
//        decDonor.setEmailId3(request.getParameter("Custodian3Email"));
//        decDonor.setCustodian4(request.getParameter("Custodian4Name"));
//        decDonor.setEmailId4(request.getParameter("Custodian4Email"));
//        decDonor.setUser_id(request.getParameter("User_id"));
          
      
        
       return decDonor;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(DonorDeclarationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(DonorDeclarationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
