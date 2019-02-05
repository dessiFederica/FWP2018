/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Articolo;
import model.ArticoloFactory;
import model.Utente;
import model.UtenteFactory;

/**
 *
 * @author federicadessi
 */
public class NewArticle extends HttpServlet {

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

        String username = request.getParameter("nuovo");
        if (username == null || username.equals("")) {
            username = request.getParameter("salva");
            Utente utente = UtenteFactory.getInstance().getUtenteByUsername(username);
            if (utente.getTipologiaUtente().equals("autore")) {
                Articolo nuovoArticolo = new Articolo();

                nuovoArticolo.setAutore(utente);
                nuovoArticolo.setCategoria(request.getParameter("cat"));
                nuovoArticolo.setContenuto(request.getParameter("testo"));
                nuovoArticolo.setDataPubblicazione(new Date());
                nuovoArticolo.setDidascalia(request.getParameter("didascalia"));
                nuovoArticolo.setImg(request.getParameter("immagine"));
                nuovoArticolo.setTitolo(request.getParameter("titolo"));
//                nuovoArticolo.setId(4);
                ArticoloFactory.getInstance().insertArticolo(nuovoArticolo);
                request.setAttribute("articolo", nuovoArticolo);
                request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);
            } else {
                request.setAttribute("errore", "Non sei un autore, non puoi accedere a questa pagina");
                request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            }
        }else{
            Utente utente = UtenteFactory.getInstance().getUtenteByUsername(username);
            if (!utente.getTipologiaUtente().equals("autore")) {
                request.setAttribute("errore", "Non sei un autore, non puoi accedere a questa pagina");
                request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            }else{
                request.setAttribute("username", username);
                request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);
            }
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
