/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federicadessi
 */
public class UtenteFactory {

    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
    private static UtenteFactory singleton;

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    private UtenteFactory() {
        //Utente Autore
        Utente u1 = new Utente();
        u1.setId(0);
        u1.setNome("Federica");
        u1.setCognome("Dessì");
        u1.setUsername("f.dessi025");
        u1.setEmail("f.dessi025@gmail.com");
        u1.setPassword("12345");
        u1.setTipologiaUtente("autore");

        //Utente Lettore
        Utente u2 = new Utente();
        u2.setId(1);
        u2.setNome("Andrea");
        u2.setCognome("Visca");
        u2.setUsername("a.visca");
        u2.setEmail("a.visca@gmail.com");
        u2.setPassword("54321");
        u2.setTipologiaUtente("lettore");

        //Utente Ospite
        Utente u3 = new Utente();
        u3.setId(2);
        u3.setNome("Patrizio");
        u3.setCognome("Marras");
        u3.setUsername("p.marras");
        u3.setEmail("p.marras@gmail.com");
        u3.setPassword("12444");
        u3.setTipologiaUtente("ospite");

        listaUtenti.add(u1);
        listaUtenti.add(u2);
        listaUtenti.add(u3);
    }

    public Utente getUtenteById(int idUser) {
        for (Utente user : listaUtenti) {
            if (user.getId() == idUser) {
                return user;
            }
        }
        return null;
    }

    public Utente getUtenteByUsername(String username) {
         try {
            Connection conn = DbConnection.getInstance().getConnection();
             String sql = "select * from utente where username = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet set = stmt.executeQuery();
            Utente user =  new Utente();
            // ciclo sulle righe restituite
            while (set.next()) {
                user.setId(set.getInt("id"));
                user.setNome(set.getString("nome"));
                user.setCognome(set.getString("cognome"));
                user.setUsername(set.getString("username"));
                user.setEmail(set.getString("email"));
                user.setPassword(set.getString("password"));
                user.setTipologiaUtente(set.getString("tipologia"));
                user.setUrlProfImg(set.getString("img"));
            }
            stmt.close();
            conn.close();
            return user;
        } catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
//        for (Utente user : listaUtenti) {
//            if (user.getUsername().equals(username)) {
//                return user;
//            }
//        }
        return null;
    }

    public boolean login(String username, String password) throws SQLException {
        boolean is_logged = false;
        try {
            Connection conn = DbConnection.getInstance().getConnection();
            String sql = "select * from utente where username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                is_logged = true;
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return is_logged;
//        for (Utente user : listaUtenti) {
//            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//                return true;
//            }
//        }
//        return false;
    }
}
