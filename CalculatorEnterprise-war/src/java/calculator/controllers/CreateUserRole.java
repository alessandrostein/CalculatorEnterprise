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
@WebServlet(name = "CreateUserRole", urlPatterns = {"/CreateUserRole"})
public class CreateUserRole extends HttpServlet {

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

        String userid = request.getParameter("userid");
        String roleid = request.getParameter("roleid");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Create role for user </title>");
        out.println("</head>");
        out.println("<body>");

        if (userid == null || roleid == null) {
            out.println("<form id=\"createForm\" name=\"createForm\" method=\"POST\">");
            out.println("<label>ID Usuario</label>");
            out.println("<input type=\"TEXT\" id=\"userid\" name=\"userid\" size=\"40\" />");
            out.println("<label>ID Regra</label>");
            out.println("<input type=\"TEXT\" id=\"roleid\" name=\"roleid\" size=\"40\" />");
            out.println("<button type=\"submit\" name=\"btn\" value=\"val\">Enviar</button>");
            out.println("</form>");
            out.println("<a href=\"index.html\">Pagina Inicial</a>");
        } else {
            User u = userF.find(Integer.parseInt(userid));
            Role r = roleF.find(Integer.parseInt(roleid));

            if (u == null || r == null) {
                out.println("<h1> Dados incorretos</h1>");
                out.println("<a href=\"index.html\">Pagina Inicial</a>");
            } else {
                UserRole o = new UserRole();
                o.setUserid(Integer.parseInt(userid));
                o.setRoleid(Integer.parseInt(roleid));
                userroleF.create(o);
                out.println("<h1>Regra adicionado ao usuario: </h1>");
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
