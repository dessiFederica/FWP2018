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
public class Login extends HttpServlet {

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
        try{       
            HttpSession session = request.getSession(false);
            
            /**
             * Controllo se l'utente
             * è loggato
             */
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
                request.setAttribute("isLogged", false);
                request.getRequestDispatcher("Utente").forward(request, response);
                return;
            }
            else 
             /**
             *Caso in cui l'utente 
             * non è loggato
             */
            {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                UtenteFactory factory_utente = UtenteFactory.getInstance();
                Utente user = factory_utente.getUtenteByUsername(username);
                
                if (username != null &&
                    password != null &&
                    factory_utente.login(username, password)
                    )
                {
                    //email e password esistono e sono validi:
                    int userId = user.getId();
                    session.setAttribute("userId", userId);
                    session.setAttribute("loggedIn", true);
                    request.setAttribute("isLogged", true);
                    session.setAttribute("username", user.getUsername());
                    List<Articolo> listaArticoli = ArticoloFactory.getInstance().getAll();
                    request.setAttribute("listaArticoli", listaArticoli);
                    
//                    request.getRequestDispatcher("User").forward(request, response);
                        
                    request.getRequestDispatcher("notizia.jsp").forward(request, response);
                    return;
                }
                else if(username != null &&
                        password != null)
                {
                    /**
                     * Dati inseriti 
                     * non validi
                     */
                    request.setAttribute("invalidData", true);
                    request.setAttribute("isLogged", false);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
            }
            

            //Invia i dati alla JSP
            request.getRequestDispatcher("notizia.jsp").forward(request, response);
            }catch(Exception e){
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
    }

    
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
}
