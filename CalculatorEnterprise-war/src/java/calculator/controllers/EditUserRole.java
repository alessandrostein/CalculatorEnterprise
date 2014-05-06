/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.controllers;

import calculator.ejbs.entity.Role;
import calculator.ejbs.entity.User;
import calculator.ejbs.entity.UserRole;
import calculator.ejbs.interfaces.RoleFacadeLocal;
import calculator.ejbs.interfaces.UserFacadeLocal;
import calculator.ejbs.interfaces.UserRoleFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alessandro
 */
@WebServlet(name = "EditUserRole", urlPatterns = {"/EditUserRole"})
public class EditUserRole extends HttpServlet {

    @EJB
    UserRoleFacadeLocal userroleF;
    @EJB
    UserFacadeLocal userF;
    @EJB
    RoleFacadeLocal roleF;

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

        String userroleid = request.getParameter("userroleid");
        String userid = request.getParameter("userid");
        String roleid = request.getParameter("roleid");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet EditUserRole</title>");
        out.println("</head>");
        out.println("<body>");

        if (userid == null) {
            out.println("<form id=\"createForm\" name=\"createForm\" method=\"POST\">");
            out.println("<label>UserRole ID " + userroleid + "</label>");

            UserRole urf = userroleF.find(Integer.parseInt(userroleid));

            out.println("<label>User ID </label>");
            out.println("<input type=\"TEXT\" id=\"userid\" name=\"userid\" size=\"40\" value= " + urf.getUserid() + ">");
            out.println("<label>Regra ID </label>");
            out.println("<input type=\"TEXT\" id=\"roleid\" name=\"roleid\" size=\"40\" value= " + urf.getRoleid() + ">");
            out.println("<button type=\"submit\" name=\"btn\" value=\"val\">Enviar</button>");
            out.println("</form>");
            out.println("<a href=\"index.html\">Pagina Inicial</a>");

            out.println("<h1>Servlet EditUserRole at " + request.getContextPath() + "</h1>");
        } else {
            User u = userF.find(Integer.parseInt(userid));
            Role r = roleF.find(Integer.parseInt(roleid));

            if (u == null || r == null) {
                out.println("<h1> Dados incorretos</h1>");
                out.println("<a href=\"index.html\">Pagina Inicial</a>");
            } else {
                UserRole o = userroleF.find(Integer.parseInt(userroleid));
                o.setUserid(Integer.parseInt(userid));
                o.setRoleid(Integer.parseInt(roleid));
                userroleF.edit(o);
                response.sendRedirect("ListUserRole");
            }
        }

        out.println("</body>");
        out.println("</html>");

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
