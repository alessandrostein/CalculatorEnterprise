/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.controllers;

import calculator.ejbs.entity.Role;
import calculator.ejbs.interfaces.RoleFacadeLocal;
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
@WebServlet(name = "RemoveRole", urlPatterns = {"/RemoveRole"})
public class RemoveRole extends HttpServlet {

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

        String roleid = request.getParameter("roleid");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ListUser</title>");
        out.println("</head>");
        out.println("<body>");
        if (roleid == null) {
            out.println("<form id=\"createForm\" name=\"createForm\" method=\"POST\">");
            out.println("<label>ID Regra</label>");
            out.println("<input type=\"TEXT\" id=\"roleid\" name=\"roleid\" size=\"40\" />");
            out.println("<button type=\"submit\" name=\"btn\" value=\"val\">Enviar</button>");
            out.println("</form>");
            out.println("<a href=\"index.html\">Pagina Inicial</a>");
        } else {
            Role o = roleF.find(Integer.parseInt(roleid));

            if (o == null) {
                out.println("<h1>Regra incorreta.</h1>");
                out.println("<a href=\"index.html\">Pagina Inicial</a>");
            } else {
                roleF.remove(o);
                out.println("<h1>Regra removida: " + o.getName() + "</h1>");
                response.sendRedirect("ListRole");
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
