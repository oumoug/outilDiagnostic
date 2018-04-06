package org.ipanema.outildiagnostic.service.dto;
public class Enfant{
   private String  systemInf;
    private String nom;
    private String prenom;
    private String identifiant;
    private String etablissement;
    private String dateEntree;
    private String dateSortie;
    
    /**
     * @return the systemInf
     */
    public String getSystemInf() {
        return systemInf;
    }
   /**
    * @return the identifiant
    */
   public String getIdentifiant() {
       return identifiant;
   }
    /**
     * @return the dateEntree
     */
    public String getDateEntree() {
        return dateEntree;
    }
    /**
     * @return the dateSortie
     */
    public String getDateSortie() {
        return dateSortie;
    }
    /**
     * @return the etablissement
     */
    public String getEtablissement() {
        return etablissement;
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
     * @param dateEntree the dateEntree to set
     */
    public void setDateEntree(String dateEntree) {
        this.dateEntree = dateEntree;
    }
    /**
     * @param dateSortie the dateSortie to set
     */
    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }
    /**
     * @param etablissement the etablissement to set
     */
    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }
    /**
     * @param identifiant the identifiant to set
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    /**
     * @param systemInf the systemInf to set
     */
    public void setSystemInf(String systemInf) {
        this.systemInf = systemInf;
    }
    public String toString(){
        return "Enfant{"+
            "systemInf='"+getSystemInf()+"'"+
            ",nom='"+getNom()+"'"+
            ",prenom='"+getPrenom()+"'}";
          
    }
    
}