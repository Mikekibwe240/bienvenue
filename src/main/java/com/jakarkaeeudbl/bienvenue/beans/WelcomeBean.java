/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jakarkaeeudbl.bienvenue.beans;

import com.jakarkaeeudbl.bienvenue.business.SessionManager;
import com.jakarkaeeudbl.bienvenue.business.UtilisateurEntrepriseBean;
import com.jakarkaeeudbl.bienvenue.entities.Utilisateur;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author MIKE KIBWE
 */
@Named("welcomeBean")
@RequestScoped

public class WelcomeBean {
    private String nom;
    private String message;
    private String email;
    private String password;
    @Inject
    UtilisateurEntrepriseBean utilisateurEntrepriseBean;
    
    @Inject
    private SessionManager sessionManager;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void afficherMessage()
    {
        if (nom != null && !nom.trim().isEmpty()) {
            message = "Selamat dating, " + nom + "!";
        } else {
            message = "";
        } 
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
    
    public String sAuthentifier() {
        Utilisateur utilisateur = utilisateurEntrepriseBean.authentifier(email, password);
        FacesContext context = FacesContext.getCurrentInstance();
        if (utilisateur != null) {
            sessionManager.createSession("user", email);
            return "/home?faces-redirect=true";
        } else {
            this.message="Email ou mots de passe incorrect.";
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return null;
        }
    }
    
    // Méthode pour se déconnecter
    public String deconnecter() {
        // Invalider la session
        sessionManager.invalidateSession();
        // Rediriger vers la page d'accueil
        return "/index?faces-redirect=true";
    }
    
    
}
