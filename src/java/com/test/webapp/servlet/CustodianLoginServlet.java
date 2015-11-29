/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.servlet;

import com.test.webapp.constants.CommonConstants;
import com.test.webapp.helper.Custodian;
import com.test.webapp.helper.RegisterUser;
import com.test.webapp.helper.hospital;
import com.test.webapp.helper.organs;
import com.test.webapp.impl.CustodianLoginImpl;
import com.test.webapp.impl.DonorLoginImpl;
import com.test.webapp.impl.HospitalLoginImpl;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class CustodianLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DonorLoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DonorLoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
     //   processRequest(request, response);
         String action = request.getParameter("action");
        if(action.equals("id")){
            
             int id= Integer.parseInt(request.getParameter("hid"));
            try {             
                ArrayList<hospital> hos = HospitalLoginImpl.getallhospital("product");
                for(hospital h:hos){
                 if(id==(h.getHid())){
                     request.setAttribute("detailsh", h);
                     RequestDispatcher rd=request.getRequestDispatcher("/ParticipatingHospitalsCust.jsp");
            rd.forward(request,response);    
                 }
                    
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
             
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
    //    processRequest(request, response);
        
        response.setContentType("text/html");    
         String action =request.getParameter("action");
         
        if(action.equals("login")){
            
        String userName = request.getParameter("UserName");
        String password = request.getParameter("Password");
         String donorid = request.getParameter("ID");
         String custodian="CUSTODIAN";
        HttpSession session = request.getSession();
      //  if(session!=null) 
      //  session.setAttribute("name", userName);
    
        if(CustodianLoginImpl.validate(userName,password,custodian)){
            try {
               RegisterUser details =  CustodianLoginImpl.getlogindetails(userName);
               
               String email = details.getEmailId();
               if(CustodianLoginImpl.validatedonorid(email, donorid)){
                     out.print("Welcome, "+userName);
                session=request.getSession();
                //   Custodian custodian = new Custodian();
                //               custodian.setCustodianUserName(userName);
                //               custodian.setCustodianUsPassword(password);
                //   session.setAttribute("custodian",custodian);
                session.setAttribute("name",userName);
              RegisterUser user =   CustodianLoginImpl.getlogindetailsdonor(donorid);
              
                ArrayList<organs> o = new ArrayList<>();
                ArrayList<String> organ = new ArrayList<>();
                   try {
                      ArrayList<organs> or;
                or = HospitalLoginImpl.getallorgans();
                for(organs org:or){
                    if(donorid.equals(org.getDonorid())){
                       o.add(org);
                       organ.add(org.getOrganname());
                       org =new organs();
                    }
                    
                }
                session.setAttribute("organsl", organ);
                      session.setAttribute("organs", o);
                      session.setAttribute("donor", user);
                session.setAttribute("donorid", donorid);
                int hid = user.getDesiredHospital();
                hospital hosp =new hospital();
                 ArrayList<hospital> hos = HospitalLoginImpl.getallhospital("product");
                  for(hospital h:hos){
                 if(hid==(h.getHid())){
                   hosp = h;
                     
                 }  
                }
                    session.setAttribute("hospital", hosp);
                      try {
                      ArrayList<hospital> hs;
                hs = HospitalLoginImpl.getallhospital("product");
                      session.setAttribute("hdetails", hs);
                  } catch (ClassNotFoundException | SQLException ex) {
                      Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                  }
                        RequestDispatcher rd=request.getRequestDispatcher("/WelcomeCustodian1.jsp");
                rd.forward(request,response);
              
                  } catch (ClassNotFoundException | SQLException ex) {
                      Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                  }
                             
               }
               else{
                   String message = "donor id is not correct";
                   request.setAttribute("message", message);
           RequestDispatcher rd=request.getRequestDispatcher("/Custodian.jsp");
                rd.forward(request,response);
                  
               }
              
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CustodianLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{ 
            String message = "Sorry username or password error";
             request.setAttribute("message", message);  
                RequestDispatcher rd=request.getRequestDispatcher("/Custodian.jsp");
                rd.forward(request,response);
              
        }    
        }
          if(action.equals("SearchHospital")){
            String zip = request.getParameter("search");
            ArrayList<hospital> a = new ArrayList();
            HttpSession session1 = request.getSession();
            if(CustodianLoginImpl.validatezip(zip)){
                try {             
                ArrayList<hospital> hos = CustodianLoginImpl.getallhospital();
                for(hospital h:hos){
                 if(zip.equals(h.getZip())){
                     a.add(h);
                         h = new hospital();
                 }
                    
                }
                request.setAttribute("zipvalue", zip);
                request.setAttribute("zip", a);
                 RequestDispatcher rd=request.getRequestDispatcher("/WelcomeCustodian1.jsp");
            rd.forward(request,response); 
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else{
                 String message ="No hospital exist";
            request.setAttribute("message", message);
             getServletContext().getRequestDispatcher("/WelcomeCustodian1.jsp").forward(request, response);
            }
            
        }   
            if(action.equals("id")){
            
             int id= Integer.parseInt(request.getParameter("hid"));
            try {             
                ArrayList<hospital> hos = CustodianLoginImpl.getallhospital();
                for(hospital h:hos){
                 if(id==(h.getHid())){
                     request.setAttribute("detailsh", h);
                     RequestDispatcher rd=request.getRequestDispatcher("/ParticipatingHospitalsCust.jsp");
            rd.forward(request,response);    
                 }
                    
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
    }

    }
