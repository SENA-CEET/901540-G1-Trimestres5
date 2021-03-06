/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo6.negocio.servlets;

import edu.co.sena.ejemplo6.integracion.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hernando
 */
@WebServlet(name = "LogueoServlet", urlPatterns = {"/LogueoServlet"})
public class LogueoServlet extends HttpServlet {

    @Inject
    private edu.co.sena.ejemplo6.negocio.ejbs.UsuarioFacadeLocal ejbUsuario;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogueoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            try {
            Usuario usuario = ejbUsuario.findByPk(request.getParameter("tipoDocumento"),
                    request.getParameter("numeroDocumento"));
            if (usuario != null) {
                if (request.getParameter("password").equals(usuario.getPass())) {
                     HttpSession session = request.getSession();
                     ServletContext application=getServletContext();
                    // primera opcion pasar por la interface de session
                    //request.getSession().setAttribute("usuario", usuario);
                    //response.sendRedirect("Servlet2");
                    
                    //segunda opcion agregar un objero por el RequestDispachet
                    //request.setAttribute("usuario", usuario);
                    //request.getRequestDispatcher("Servlet2").forward(request, response);
                    
                    //tercera opcion
                    application.setAttribute("usuario", usuario);
                    response.sendRedirect("Servlet2");
                }else{
                    out.println("la contraseña es incorrecta");
                }
            } else {
            out.print("por aqui estamos");
            }
            } catch (Exception e) {
                 out.println("el usuario no existe"+ e.getMessage());
            }
            
            

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
