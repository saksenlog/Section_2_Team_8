/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.servlet;

import com.test.webapp.helper.Custodian;
import com.test.webapp.impl.CustodianLoginImpl;
import com.test.webapp.impl.DonorLoginImpl;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
        
        
        String userName = request.getParameter("UserName");
        String password = request.getParameter("Password");
        HttpSession session = request.getSession(false);
      //  if(session!=null) 
      //  session.setAttribute("name", userName);
        
        if(CustodianLoginImpl.validate(userName,password)){
            out.print("Welcome, "+userName); 
            session=request.getSession();  
         //   Custodian custodian = new Custodian();
         //               custodian.setCustodianUserName(userName);
         //               custodian.setCustodianUsPassword(password);
         //   session.setAttribute("custodian",custodian);
            session.setAttribute("name",userName);
            
            RequestDispatcher rd=request.getRequestDispatcher("/WelcomeCustodian.jsp");
            //out.print("Welcome, "+userName);  
            rd.forward(request,response);    
            
        }
        else{
            out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("/Custodian.jsp");
            rd.include(request,response);    
              
        }    
             
        out.close();
        
    }

    }
