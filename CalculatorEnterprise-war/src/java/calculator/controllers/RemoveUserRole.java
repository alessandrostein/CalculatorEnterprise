/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.controllers;

import calculator.ejbs.entity.UserRole;
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
@WebServlet(name = "RemoveUserRole", urlPatterns = {"/RemoveUserRole"})
public class RemoveUserRole extends HttpServlet {

    @EJB
    UserRoleFacadeLocal userroleF;

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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Remove User Role</title>");
        out.println("</head>");
        out.println("<body>");
        if (userroleid == null) {
            out.println("<form id=\"createForm\" name=\"createForm\" method=\"POST\">");
            out.println("<label>ID UserRole</label>");
            out.println("<input type=\"TEXT\" id=\"userroleid\" name=\"userroleid\" size=\"40\" />");
            out.println("<button type=\"submit\" name=\"btn\" value=\"val\">Enviar</button>");
            out.println("</form>");
            out.println("<a href=\"index.html\">Pagina Inicial</a>");
            //out.println("<h1>Adicione o ID do usuario na url. Ex: RemoveUserRole?userroleid=IDDOUSERROLE</h1>");
        } else {
            UserRole o = new UserRole();
            o.setId(Integer.parseInt(userroleid));
            userroleF.remove(o);
            out.println("<h1>Removido Usuario da Regra " + o.toString() + "</h1>");
            response.sendRedirect("ListUserRole");
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
