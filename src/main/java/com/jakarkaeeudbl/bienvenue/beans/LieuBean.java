package com.jakarkaeeudbl.bienvenue.beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("lieuBean")
@SessionScoped
public class LieuBean implements Serializable {
    private String nom;
    private String description;
    private double latitude;
    private double longitude;
    private List<Lieu> listeLieux = new ArrayList<>();

    public void ajouterLieu() {
        Lieu lieu = new Lieu(nom, description, latitude, longitude);
        listeLieux.add(lieu);
        resetForm();
    }

    private void resetForm() {
        nom = "";
        description = "";
        latitude = 0;
        longitude = 0;
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public List<Lieu> getListeLieux() { return listeLieux; }
}
