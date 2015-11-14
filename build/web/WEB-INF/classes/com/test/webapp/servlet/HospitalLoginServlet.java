/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.servlet;

import com.test.webapp.constants.CommonConstants;
import com.test.webapp.helper.RegisterUser;
import com.test.webapp.helper.hospital;
import com.test.webapp.helper.organs;
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
public class HospitalLoginServlet extends HttpServlet {

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
                ArrayList<hospital> hos = HospitalLoginImpl.getallhospital();
                for(hospital h:hos){
                 if(id==(h.getHid())){
                     request.setAttribute("detailsh", h);
                     RequestDispatcher rd=request.getRequestDispatcher("/ParticipatingHospitals.jsp");
            rd.forward(request,response);    
                 }
                    
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
          if(action.equals("donorhos")){
            
             int id= Integer.parseInt(request.getParameter("hid"));
           String dname =  request.getParameter("name");
            try {             
                ArrayList<hospital> hos = HospitalLoginImpl.getallhospital();
                for(hospital h:hos){
                 if(id==(h.getHid())){
                     request.setAttribute("detailsh", h);
                     request.setAttribute("dname", dname);
                     RequestDispatcher rd=request.getRequestDispatcher("/hospitaldetailsdonor.jsp");
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
        String action =request.getParameter("action");
    //    processRequest(request, response);
        
        response.setContentType("text/html");    
        
        if(action.equals("login")){
              String userName = request.getParameter("UserName");
        String password = request.getParameter("Password");
        HttpSession session = request.getSession();
      //  if(session!=null) 
      //  session.setAttribute("name", userName);
        
        if(HospitalLoginImpl.validate(userName,password)){
            out.print("Welcome, "+userName); 
            session=request.getSession();  
            session.setAttribute("name",userName);
                  try {
                      ArrayList<hospital> hs;
                hs = HospitalLoginImpl.getallhospital();
                      session.setAttribute("hdetails", hs);
                  } catch (ClassNotFoundException | SQLException ex) {
                      Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                  }
            RequestDispatcher rd=request.getRequestDispatcher("/welcomehospital1.jsp");
            rd.forward(request,response);    
            
        }
        else{
            out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("/Donor.jsp");
            rd.include(request,response);    
              
        }    
             
        out.close();
        }
        if(action.equals("hospitalregister")){
            hospital hos = new hospital();
            hos.setHospitalName(request.getParameter("HospitalName"));
            hos.setUsername(request.getParameter("userName"));
            hos.setPassword(request.getParameter("pwd"));
            hos.setAddress(request.getParameter("address"));
            hos.setCity(request.getParameter("city"));
            hos.setState(request.getParameter("state"));
            hos.setZip(request.getParameter("zip"));
            hos.setEmail(request.getParameter("emailId"));
            
           int registerValid =  HospitalLoginImpl.registerhospital(hos);
           if(registerValid == CommonConstants.INT_SUCCESS){
            request.setAttribute("registerValid", CommonConstants.TRUE);
        }else{
            request.setAttribute("registerValid", "false");
        }
        
        RequestDispatcher dispatcherObj = request.getRequestDispatcher("/hospitalRegister.jsp");
        dispatcherObj.forward(request, response);
            
            
            
        }
        if(action.equals("SearchHospital")){
            String zip = request.getParameter("search");
            ArrayList<hospital> a = new ArrayList();
            HttpSession session1 = request.getSession();
            if(HospitalLoginImpl.validatezip(zip)){
                try {             
                ArrayList<hospital> hos = HospitalLoginImpl.getallhospital();
                for(hospital h:hos){
                 if(zip.equals(h.getZip())){
                     a.add(h);
                         h = new hospital();
                 }
                    
                }
                request.setAttribute("zipvalue", zip);
                request.setAttribute("zip", a);
                 RequestDispatcher rd=request.getRequestDispatcher("/welcomehospital1.jsp");
            rd.forward(request,response); 
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else{
                 String message ="hospital does not exist";
            request.setAttribute("message1", message);
             getServletContext().getRequestDispatcher("/welcomehospital1.jsp").forward(request, response);
            }
            
        }
      if(action.equals("SearchDonor")){
          String donorid =request.getParameter("search");
          if(HospitalLoginImpl.validatedonorid(donorid)){
               try {
                RegisterUser details = HospitalLoginImpl.getlogindetails(donorid);
                request.setAttribute("donor", details);
                request.setAttribute("donorid", donorid);
                RequestDispatcher rd=request.getRequestDispatcher("/DonorDetails.jsp");
            rd.include(request,response); 
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
          else{
               String message ="Donor does not exist";
            request.setAttribute("message", message);
             getServletContext().getRequestDispatcher("/welcomehospital1.jsp").forward(request, response);
          }
           
          
          
      }
      if(action.equals("Searchorgans")){
          String organ =request.getParameter("searchorgan");
          ArrayList<organs> o = new ArrayList();
          if(HospitalLoginImpl.validateorgan(organ)){
              try {
                      ArrayList<organs> or;
                or = HospitalLoginImpl.getallorgans();
                for(organs org:or){
                    if(organ.equals(org.getOrganname())){
                       o.add(org);
                       org =new organs();
                    }
                    
                }
                      request.setAttribute("organdtls", o);
                  } catch (ClassNotFoundException | SQLException ex) {
                      Logger.getLogger(HospitalLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                  }
            RequestDispatcher rd=request.getRequestDispatcher("/welcomehospital1.jsp");
            rd.forward(request,response);   
        }
          else{
               String message ="No match found!!";
            request.setAttribute("message2", message);
             getServletContext().getRequestDispatcher("/welcomehospital1.jsp").forward(request, response);
          }
           
          
          
      }
    }

    }
