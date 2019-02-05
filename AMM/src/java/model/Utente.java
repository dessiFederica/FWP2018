/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author federicadessi
 */
public class Utente {
    
    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String password;
    private String urlProfImg;
    private String tipologiaUtente;

   
    
    
    public Utente(){
        this.id = 0;
        this.nome = " ";
        this.cognome = " ";
        this.username = " ";
        this.email = " ";
        this.password = " ";
        this.urlProfImg = " ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlProfImg() {
        return urlProfImg;
    }

    public void setUrlProfImg(String urlProfImg) {
        this.urlProfImg = urlProfImg;
    }
    
    public String getTipologiaUtente() {
        return tipologiaUtente;
    }

    public void setTipologiaUtente(String tipologiaUtente) {
        this.tipologiaUtente = tipologiaUtente;
    }
    
}
