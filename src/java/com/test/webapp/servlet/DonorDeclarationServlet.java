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
            throws ServletException, IOException {
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
        
        DonorDeclarationIntf donDeclareIntf;
        
        
       
        
        donDeclareIntf = new DonorDeclarationImpl();
        int declareValid = donDeclareIntf.declareDonor(decDonor);
        //email
         String senderEmail = "organdonorlive@gmail.com";
    String Custodian1Email =request.getParameter("Custodian1Email"); //request.getParameter("Custodian1Email");
    String Custodian2Email = request.getParameter("Custodian2Email");
    String Custodian3Email = request.getParameter("Custodian3Email");
    String Custodian4Email = request.getParameter("Custodian4Email");
    String userMessage = "You have been assigned as a CUSTODIAN FOR Donor : "+request.getParameter("User_id");

          /*  */
       final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
       // Get a Properties object
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
         props.setProperty("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.auth", "true");
         props.put("mail.debug", "true");
         props.setProperty("mail.smtp.socketFactory.port", "465");
         props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.setProperty("mail.smtp.socketFactory.fallback", "false");
         props.setProperty("mail.smtp.port", "465");
         
         
        
         props.put("mail.store.protocol", "pop3");
         
         final String email = "organdonorlive@gmail.com";
         final String pass = "organdonor";
            try{
               Session sessionuser = Session.getDefaultInstance(props, 
               new Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(email, pass);
                             }
                });

                // -- Create a new message --
                Message message = new MimeMessage(sessionuser);

               // -- Set the FROM and TO fields --
                message.setFrom(new InternetAddress(senderEmail));
                message.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(Custodian1Email,false));
//                message.setRecipients(Message.RecipientType.TO, 
//                      InternetAddress.parse(Custodian2Email,false));
                
                message.setSubject("SMTP email Test");
                message.setText(userMessage);
                message.setSentDate(new Date());
                
                Session session_mail = sessionuser.getInstance(props,null);
                Transport transport = session_mail.getTransport("smtps");
                transport.connect("smtp.gmail.com", 465, email, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();   
                
                Transport.send(message);
                System.out.println("Message sent.");
            }
            catch (MessagingException e)
            { 
                System.out.println("ERROR: " + e);
            }
       //         getServletContext().getRequestDispatcher("/DonorDeclaration.jsp").forward(request, response); 
             
      
        
       
        
        //email
        if(declareValid == CommonConstants.INT_SUCCESS){
            request.setAttribute("DeclareValid", CommonConstants.TRUE);
        }else{
            request.setAttribute("DeclareValid", "false");
        }
        
        RequestDispatcher dispatcherObj = request.getRequestDispatcher("/DonorDeclaration.jsp");
        dispatcherObj.forward(request, response);
    }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
