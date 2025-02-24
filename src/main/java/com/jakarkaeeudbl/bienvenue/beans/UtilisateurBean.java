package com.jakarkaeeudbl.bienvenue.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;

@Named("utilisateurBean")  // Permet à JSF d'utiliser #{utilisateurBean} dans le XHTML
@RequestScoped  // Gère l'état du bean uniquement pendant la requête
public class UtilisateurBean implements Serializable {

    private String username;
    private String email;
    
    @NotBlank(message="Le mot de passe ne peut pas être vide")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
             message = "Le mot de passe doit contenir au moins une majuscule, un chiffre et un caractère spécial.")
    private String password;
    
    @NotBlank(message="Veuillez confirmer votre mot de passe")
    private String confirmPassword;  // Ajout pour la confirmation
    private String description;
    
    public void ajouterUtilisateur() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        // Vérifier si les mots de passe correspondent
        if (!password.equals(confirmPassword)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Les mots de passe ne correspondent pas", null));
            return;
        }
        
        // Ajout du message de succès si le mot de passe respecte les critères
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Utilisateur ajouté avec succès", null));

        System.out.println("Utilisateur ajouté : " + username + " - " + email);
       
        // Réinitialisation des champs
        username = "";
        email = "";
        password = "";
        description = "";
    }

    // Getters et Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
