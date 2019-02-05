/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Articolo;
import model.ArticoloFactory;
import model.Utente;
import model.UtenteFactory;

/**
 *
 * @author federicadessi
 */
public class NewsDetail extends HttpServlet {

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
        int idArticolo = Integer.parseInt(request.getParameter("articolo"));
       
            HttpSession session = request.getSession(false);
            
             request.setAttribute("isLogged", false);

            if (request.getParameter("logout") != null)
            {
                session.invalidate();
                request.setAttribute("isLogged", false);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
            
             /**
             *Caso in cui l'utente è
             * è loggato
             */
            if (session.getAttribute("loggedIn") != null &&
                session.getAttribute("loggedIn").equals(true))
            {
                String username = request.getParameter("data-value");
                session.setAttribute("loggedIn", true);
                request.setAttribute("isLogged", true);
                Articolo articoloDetail = ArticoloFactory.getInstance().getNotiziaById(idArticolo);

            request.setAttribute("articoloDetail", articoloDetail);
            request.setAttribute("username", username);
            request.getRequestDispatcher("notiziaDetail.jsp").forward(request, response);
            return;
            }
            else 
             /**
             *Caso in cui l'utente 
             * non è loggato
             */
            {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
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
