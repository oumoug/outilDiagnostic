package org.ipanema.outildiagnostic.service.dto;

public class Parent{
    private String nom;
    private String prenom;
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}