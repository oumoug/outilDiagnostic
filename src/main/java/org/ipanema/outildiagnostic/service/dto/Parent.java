package org.ipanema.outildiagnostic.service.dto;

public class Parent{
    private String systemInf;
    private String nom;
    private String prenom;
    /**
     * @return the systemInf
     */
    public String getSystemInf() {
        return systemInf;
    }
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
    /**
     * @param systemInf the systemInf to set
     */
    public void setSystemInf(String systemInf) {
        this.systemInf = systemInf;
    }
    public String toString(){
        return "Parent{"+
            "systemInf='"+getSystemInf()+"'"+
            ",nom='"+getNom()+"'"+
            ",prenom='"+getPrenom()+"'}";

    }
}