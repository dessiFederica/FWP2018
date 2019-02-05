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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federicadessi
 */
public class ArticoloFactory {

    private static ArticoloFactory singleton;
    private ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
    private Date today = new Date();

    public static ArticoloFactory getInstance() {
        if (singleton == null) {
            singleton = new ArticoloFactory();
        }
        return singleton;
    }

//    private ArticoloFactory() {
//        Articolo n1 = new Articolo();
//        n1.setId(0);
//        n1.setTitolo("Scrive per sbaglio 'Incluso nel prezzo' su una pagina del sito : licenziato dipendente Apple");
//        n1.setContenuto("CUPERTINO Non l'ho fatto apposta, mi  scappato!Sono queste le prime parole pronunciate dall'ormai ex dipendente della Apple,  \n"
//                + "                            John Honest, dopo aver aggiunto per sbaglio, mentre compilava  la descrizione di un prodotto sul sito,  \n"
//                + "                            una frase che mai ci si sarebbe immaginato di leggere  associata a un prodotto della mela: Included in the price.  \n"
//                + "                            Il ragazzo, intervistato mentre friggeva patatine nella cucina di un McDonald's nella periferia di Detroit,  \n"
//                + "                            ha comunque mostrato di non serbare rancore verso i suoi ex colleghi di lavoro:  \n"
//                + "                            Per Natale ho anche mandato loro in regalo decine di Samsung Galaxy S7.");
//        UtenteFactory utFactory = UtenteFactory.getInstance();
//        Utente autore = utFactory.getUtenteById(0);
//        n1.setAutore(autore);
//        n1.setCategoria("Apple");
//        n1.setDataPubblicazione(today);
//        n1.setImg("apple-logo.gif");
//        n1.setDidascalia("Licenziato dipendente Apple");
//
//        Articolo n2 = new Articolo();
//        n2.setId(1);
//        n2.setTitolo("Lavoro, Amazon lancia la formulaAll You Can Work: stipendio fisso e lavori finchè puoi");
//        n2.setContenuto("STRAORDINA (RI) I nostri dipendenti sono entusiasti, sono queste le parole di Adolfa Stacanova,  \n"
//                + "                            direttrice del personale di Amazon Italia e ideatrice di un'innovativa metodologia applicata al mondo del lavoro  \n"
//                + "                            che ora sta spopolando nelle start-up e nelle aziende di tutta Italia.Soddisfatti anche i sindacati, che hanno approvato  \n"
//                + "                            all'unanimità  questa nuova forma contrattuale che apporta un miglioramento considerevole delle condizioni del lavoratore  \n"
//                + "                            rispetto al Jobs Act e pone l'Italia all'inseguimento dello standard cinese. Adesso il nuovo trend sembra aver contagiato  \n"
//                + "                            anche altre aziende, tra cui la Slavery Srl, che promette di fare ancora di più: lo stipendio sarà  infatti sostituito con  \n"
//                + "                            dei Gratta&Vinci, che daranno ogni mese la possibilità  agli impiegati di sognare a occhi aperti.");
//        n2.setAutore(autore);
//        n2.setCategoria("Amazon");
//        n2.setDataPubblicazione(today);
//        n2.setImg("o.451651.jpg");
//        n2.setDidascalia("All You Can Work Amazon");
//
//        Articolo n3 = new Articolo();
//        n3.setId(2);
//        n3.setTitolo("Facebook, Mark Zuckerberg rimuove i senatori USA dagli amici");
//        n3.setContenuto("WASHINGTON  \"È in momenti come questi che avrei preferito rubare l'idea di Google Plus!\" deve aver pensato \n"
//                + "                            Mark Zuckerberg al cospetto del Congresso degli Stati Uniti per chiarire la posizione di Facebook nello scandalo Cambridge Analytica.\n"
//                + "                            Il CEO del social più famoso del mondo, in un elegante completo giacca, cravatta e ciabatte da doccia, ha dovuto rispondere soprattutto \n"
//                + "                            al modo in cui si sia entrati in possesso dei dati di 87 milioni di persone e di come siano stati utilizzati: \"Be',\n"
//                + "                            ce li hanno dati loro spontaneamente, chi pensava che volessero tenerli nascosti?\".");
//        n3.setAutore(autore);
//        n3.setCategoria("Facebook");
//        n3.setDataPubblicazione(today);
//        n3.setImg("zuck-senato.jpg");
//        n3.setDidascalia("Mark Zuckerberg davanti al Senato");
//
//        listaArticoli.add(n1);
//        listaArticoli.add(n2);
//        listaArticoli.add(n3);
//    }

    public Articolo getNotiziaById(int id) {
        for (Articolo articoli : listaArticoli) {
            if (articoli.getId() == id) {
                return articoli;
            }
        }
        return null;
    }

    public ArrayList<Articolo> getListaNewsByAutore(Utente autore) {
        ArrayList<Articolo> listabyAutore = new ArrayList<Articolo>();
        for (Articolo articoli : listaArticoli) {
            if (articoli.getAutore().getId() == autore.getId()) {
                listabyAutore.add(articoli);
            }
        }
        return listabyAutore;
    }

    public ArrayList<Articolo> getAll() {
        try
        {
            listaArticoli = new ArrayList<Articolo>();
            //Prevenire sql injection con i PreparedStatement
            Connection conn = DbConnection.getInstance().getConnection();
            String sql ="Select * from notizia";
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);
            while(set.next())
            {
                int id = set.getInt("id");
                String titolo = set.getString("titolo");
                String contenuto = set.getString("contenuto");
                String img = set.getString("img");
                int id_autore = set.getInt("autore");
                Utente u = UtenteFactory.getInstance().getUtenteById(id_autore);
                String categoria = set.getString("categoria");
                
                Articolo articolo = new Articolo();
                articolo.setId(id);
                articolo.setAutore(u);
                articolo.setCategoria(categoria);
                articolo.setImg(img);
                articolo.setTitolo(titolo);
                articolo.setContenuto(contenuto);
                
                listaArticoli.add(articolo);           
            }
            
            stmt.close();
            conn.close();
        }catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaArticoli;
    }

    public Articolo insertArticolo(Articolo articolo) {
        try {
            Connection conn = DbConnection.getInstance().getConnection();
            String sql = "insert into app.notizia values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "default");
            stmt.setString(2, articolo.getTitolo());
            stmt.setString(3, articolo.getContenuto());
            stmt.setString(4, articolo.getDidascalia());
            stmt.setString(5, articolo.getImg());
            stmt.setInt(6, articolo.getAutore().getId());
            stmt.setString(7, articolo.getCategoria());
            java.sql.Date sqlDate = new java.sql.Date(articolo.getDataPubblicazione().getTime());
            stmt.setDate(8, sqlDate);
            stmt.executeUpdate();
          

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
