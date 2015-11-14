/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webapp.servlet;

import com.test.webapp.constants.CommonConstants;
import com.test.webapp.helper.RegisterUser;
import com.test.webapp.impl.UserRegistrationImpl;
import com.test.webapp.intf.UserRegistrationIntf;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
/**
 *
 * @author User
 */
public class UserRegistrationServlet extends HttpServlet {

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
            out.println("<title>Servlet UserRegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserRegistrationServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, resp
        
        RegisterUser regUser = createUserObj(request);
        if(!(regUser.getUserRole().equals("SELECT VALUES"))){
            
            UserRegistrationIntf userRegIntf;
        
        userRegIntf = new UserRegistrationImpl();
        int registerValid = userRegIntf.registerUser(regUser);
        if(registerValid == CommonConstants.INT_SUCCESS){
            request.setAttribute("registerValid", CommonConstants.TRUE);
        }else{
            request.setAttribute("registerValid", "false");
        }
        
        RequestDispatcher dispatcherObj = request.getRequestDispatcher("/Register.jsp");
        dispatcherObj.forward(request, response);
            
            
        }
        else{
             request.setAttribute("registerValid", "false");
             RequestDispatcher dispatcherObj = request.getRequestDispatcher("/Register.jsp");
        dispatcherObj.forward(request, response);
            
        }
        
          
    }
    
    
    private RegisterUser createUserObj(HttpServletRequest request){
        
        RegisterUser regUser = new RegisterUser();
       
        regUser.setFirstName(request.getParameter("firstName"));
        regUser.setLastName(request.getParameter("lastName"));
        regUser.setUserName( request.getParameter("userName"));
        regUser.setEmailId( request.getParameter("emailId"));
        regUser.setAddress1( request.getParameter("address1"));
        regUser.setAddress2(request.getParameter("address2"));
        regUser.setCity(request.getParameter("city"));
        regUser.setState(request.getParameter("state"));
        regUser.setPassWord(request.getParameter("pwd"));
        regUser.setUserRole(request.getParameter("User_Role"));
        regUser.setZip(request.getParameter("zip"));
        
        return regUser;
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
