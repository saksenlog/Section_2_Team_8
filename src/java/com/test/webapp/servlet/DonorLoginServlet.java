/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.servlet;

import com.test.webapp.helper.Donor;
import com.test.webapp.helper.hospital;
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
public class DonorLoginServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        if(action.equals("login")){
        
        String userName = request.getParameter("UserName");
        String password = request.getParameter("Password");
        
     
      //  if(session!=null) 
      //  session.setAttribute("name", userName);
       
        String donor="DONOR";
        if(DonorLoginImpl.validate(userName,password,donor)){
            out.print("Welcome, "+userName); 
            session=request.getSession();  
            session.setAttribute("name",userName);

            RequestDispatcher rd=request.getRequestDispatcher("/welcomednr.jsp");
            rd.forward(request,response);    
            
         //   request.setAttribute("UserName",userName);
         //   request.setAttribute("Password",password);
         //  RequestDispatcher rd1 = request.getRequestDispatcher("DonorDeclarationServlet");
         //   rd1.forward(request,response);
            
        }
        else{
            out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("/Donor.jsp");
            rd.include(request,response);    
              
        }    
             
        
        out.close();
        
    }
        if(action.equals("SearchHospitals")){
            
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
              String uname =  (String) session.getAttribute("name");
              request.setAttribute("uname", uname);
                 RequestDispatcher rd=request.getRequestDispatcher("/welcomednr.jsp");
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
             getServletContext().getRequestDispatcher("/welcomednr.jsp").forward(request, response);
            }
            
            
        }
        if(action.equals("updatehospital")){
            
          String name =  request.getParameter("dname");
          String hname =request.getParameter("hname");
          int hid = Integer.parseInt(request.getParameter("hid"));
          if(DonorLoginImpl.updateuser(name, hname, hid)){
               String message ="Hospital Selected Sucessfully";
            request.setAttribute("message", message);
             RequestDispatcher rd=request.getRequestDispatcher("/hospitaldetailsdonor.jsp");
            rd.forward(request,response);
          }
          else{
              String message ="All selected";
            request.setAttribute("message", message);
             RequestDispatcher rd=request.getRequestDispatcher("/hospitaldetailsdonor.jsp");
            rd.forward(request,response);
          }
           
            
        }
    }

    }
