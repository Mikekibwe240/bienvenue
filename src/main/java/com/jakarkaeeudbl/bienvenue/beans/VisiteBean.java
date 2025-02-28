package com.jakarkaeeudbl.bienvenue.beans;


import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Named(value = "formulaireVisiteBean")
@RequestScoped
public class VisiteBean implements Serializable {
private Long idUtilisateur;
private Long idLieu;
private Date dateVisite;
private int tempsPasse;
private String observations;
private double depenses;
private boolean afficherFormulaireVisite;
public void afficherFormulaireVisite() {
afficherFormulaireVisite = true;
}
public void sauvegarderVisite() {
// Logique pour sauvegarder la visite
FacesContext.getCurrentInstance().addMessage(null, new
FacesMessage(FacesMessage.SEVERITY_INFO, "Visite enregistrée avec succès", null));
afficherFormulaireVisite = false;
}

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Long getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(Long idLieu) {
        this.idLieu = idLieu;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public int getTempsPasse() {
        return tempsPasse;
    }

    public void setTempsPasse(int tempsPasse) {
        this.tempsPasse = tempsPasse;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public double getDepenses() {
        return depenses;
    }

    public void setDepenses(double depenses) {
        this.depenses = depenses;
    }
public boolean isAfficherFormulaireVisite() {
return afficherFormulaireVisite;
}
}
