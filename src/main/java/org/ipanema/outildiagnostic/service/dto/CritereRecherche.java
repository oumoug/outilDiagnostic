package org.ipanema.outildiagnostic.service.dto;

public class CritereRecherche{
    private String nom;
    private String prenom;
    private String mail;
    private String profil;
    private String etablissement;

    public String  getNom(){
        return this.nom;
    }
    public void  setNom(String nom){
        this.nom=nom;
    }

    public String  getPrenom(){
        return this.prenom;
    }
    public void  setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void  setMail(String mail){
        this.mail=mail;
    }
    
    public String  getMail(){
        return this.mail;
    }
    public String  getProfil(){
        return this.profil;
    }
    public void  setProfil(String profil){
        this.profil=profil;
    }
    public String  getEtablissement(){
        return this.etablissement;
    }
    public void  setEtablissement(String etablissement){
       this.etablissement=etablissement;
    }


}