package org.ipanema.outildiagnostic.service.dto;
import java.util.ArrayList;
import java.util.List;

public class Eleve{
    private String nomSiecle;
    private String  prenomSiecle;
    private String  identifiantSiecle;
    private String dateNaissanceSiecle;
    private String etablissementSiecle;
    private List<String> representantLegalSiecle;
    private String nomAaf;
    private String prenomAaf;
    private String identifiantAaf;
    private String dateNaissanceAaf;
    private String etablissementAaf;
    private String classeAaf;
    private String nomToutatice;
    private String prenomToutatice;
    private String identifiantToutatice;
    private String mailToutatice;
    private String etatCompteToutatice;
    private String lastConToutatice;
    private String nomEduconnect;
    private String prenomEduconnect;
    private String identifiantEduconnect;
    private String mailEduconnect;
    private String etatCompteEduconnect;
    private String lastConEduconnect;
    private String nomAten;
    private String prenomAten;
    private String  identifiantAten;
    private String dateNaissanceAten;
    private String etablissementAten;
    private List<String> representantLegalAten;
    public Eleve(){
        this.representantLegalSiecle=new ArrayList<String>();
        this.representantLegalAten=new ArrayList<String>();
    }
    /**
     * @return the representantLegalAten
     */
    public List<String> getRepresentantLegalAten() {
        return representantLegalAten;
    }
    /**
     * @return the represantantLegalSiecle
     */
    public List<String> getRepresentantLegalSiecle() {
        return representantLegalSiecle;
    }
    /**
     * @return the prenomToutatice
     */
    public String getPrenomToutatice() {
        return prenomToutatice;
    }
    /**
     * @return the prenomSiecle
     */
    public String getPrenomSiecle() {
        return prenomSiecle;
    }
    /**
     * @return the prenomEduconnect
     */
    public String getPrenomEduconnect() {
        return prenomEduconnect;
    }
    /**
     * @return the prenomAten
     */
    public String getPrenomAten() {
        return prenomAten;
    }
    /**
     * @return the prenomAaf
     */
    public String getPrenomAaf() {
        return prenomAaf;
    }
    /**
     * @return the nomToutatice
     */
    public String getNomToutatice() {
        return nomToutatice;
    }
    /**
     * @return the nomSiecle
     */
    public String getNomSiecle() {
        return nomSiecle;
    }
    /**
     * @return the nomEduconnect
     */
    public String getNomEduconnect() {
        return nomEduconnect;
    }
    /**
     * @return the nomAten
     */
    public String getNomAten() {
        return nomAten;
    }
    /**
     * @return the nomAaf
     */
    public String getNomAaf() {
        return nomAaf;
    }
    /**
     * @return the mailToutatice
     */
    public String getMailToutatice() {
        return mailToutatice;
    }
    /**
     * @return the mailEduconnect
     */
    public String getMailEduconnect() {
        return mailEduconnect;
    }
    /**
     * @return the lastConToutatice
     */
    public String getLastConToutatice() {
        return lastConToutatice;
    }
    /**
     * @return the lastConEduconnect
     */
    public String getLastConEduconnect() {
        return lastConEduconnect;
    }
    /**
     * @return the identifiantToutatice
     */
    public String getIdentifiantToutatice() {
        return identifiantToutatice;
    }
    /**
     * @return the identifiantSiecle
     */
    public String getIdentifiantSiecle() {
        return identifiantSiecle;
    }
    /**
     * @return the identifiantEduconnect
     */
    public String getIdentifiantEduconnect() {
        return identifiantEduconnect;
    }
    /**
     * @return the identifiantAten
     */
    public String getIdentifiantAten() {
        return identifiantAten;
    }
    /**
     * @return the identifiantAaf
     */
    public String getIdentifiantAaf() {
        return identifiantAaf;
    }
    /**
     * @return the etatCompteToutatice
     */
    public String getEtatCompteToutatice() {
        return etatCompteToutatice;
    }
    /**
     * @return the etatCompteEduconnect
     */
    public String getEtatCompteEduconnect() {
        return etatCompteEduconnect;
    }
    /**
     * @return the etablissementSiecle
     */
    public String getEtablissementSiecle() {
        return etablissementSiecle;
    }
    /**
     * @return the etablissementAten
     */
    public String getEtablissementAten() {
        return etablissementAten;
    }
    /**
     * @return the etablissementAaf
     */
    public String getEtablissementAaf() {
        return etablissementAaf;
    }
    /**
     * @return the dateNaissanceSiecle
     */
    public String getDateNaissanceSiecle() {
        return dateNaissanceSiecle;
    }
    /**
     * @return the dateNaissanceAten
     */
    public String getDateNaissanceAten() {
        return dateNaissanceAten;
    }
    /**
     * @return the classeAaf
     */
    public String getClasseAaf() {
        return classeAaf;
    }
    /**
     * @return the dateNaissanceAaf
     */
    public String getDateNaissanceAaf() {
        return dateNaissanceAaf;
    }
    /**
     * @param classeAaf the classeAaf to set
     */
    public void setClasseAaf(String classeAaf) {
        this.classeAaf = classeAaf;
    }
    /**
     * @param dateNaissanceAaf the dateNaissanceAaf to set
     */
    public void setDateNaissanceAaf(String dateNaissanceAaf) {
        this.dateNaissanceAaf = dateNaissanceAaf;
    }
    /**
     * @param dateNaissanceAten the dateNaissanceAten to set
     */
    public void setDateNaissanceAten(String dateNaissanceAten) {
        this.dateNaissanceAten = dateNaissanceAten;
    }
    /**
     * @param dateNaissanceSiecle the dateNaissanceSiecle to set
     */
    public void setDateNaissanceSiecle(String dateNaissanceSiecle) {
        this.dateNaissanceSiecle = dateNaissanceSiecle;
    }
    /**
     * @param etablissementAaf the etablissementAaf to set
     */
    public void setEtablissementAaf(String etablissementAaf) {
        this.etablissementAaf = etablissementAaf;
    }
    /**
     * @param etablissementAten the etablissementAten to set
     */
    public void setEtablissementAten(String etablissementAten) {
        this.etablissementAten = etablissementAten;
    }
    /**
     * @param etablissementSiecle the etablissementSiecle to set
     */
    public void setEtablissementSiecle(String etablissementSiecle) {
        this.etablissementSiecle = etablissementSiecle;
    }
    /**
     * @param etatCompteEduconnect the etatCompteEduconnect to set
     */
    public void setEtatCompteEduconnect(String etatCompteEduconnect) {
        this.etatCompteEduconnect = etatCompteEduconnect;
    }
    /**
     * @param etatCompteToutatice the etatCompteToutatice to set
     */
    public void setEtatCompteToutatice(String etatCompteToutatice) {
        this.etatCompteToutatice = etatCompteToutatice;
    }
    /**
     * @param identifiantAaf the identifiantAaf to set
     */
    public void setIdentifiantAaf(String identifiantAaf) {
        this.identifiantAaf = identifiantAaf;
    }
    /**
     * @param identifiantAten the identifiantAten to set
     */
    public void setIdentifiantAten(String identifiantAten) {
        this.identifiantAten = identifiantAten;
    }
    /**
     * @param identifiantEduconnect the identifiantEduconnect to set
     */
    public void setIdentifiantEduconnect(String identifiantEduconnect) {
        this.identifiantEduconnect = identifiantEduconnect;
    }
    /**
     * @param identifiantSiecle the identifiantSiecle to set
     */
    public void setIdentifiantSiecle(String identifiantSiecle) {
        this.identifiantSiecle = identifiantSiecle;
    }
    /**
     * @param identifiantToutatice the identifiantToutatice to set
     */
    public void setIdentifiantToutatice(String identifiantToutatice) {
        this.identifiantToutatice = identifiantToutatice;
    }
    /**
     * @param lastConEduconnect the lastConEduconnect to set
     */
    public void setLastConEduconnect(String lastConEduconnect) {
        this.lastConEduconnect = lastConEduconnect;
    }
    /**
     * @param lastConToutatice the lastConToutatice to set
     */
    public void setLastConToutatice(String lastConToutatice) {
        this.lastConToutatice = lastConToutatice;
    }
    /**
     * @param mailEduconnect the mailEduconnect to set
     */
    public void setMailEduconnect(String mailEduconnect) {
        this.mailEduconnect = mailEduconnect;
    }
    /**
     * @param mailToutatice the mailToutatice to set
     */
    public void setMailToutatice(String mailToutatice) {
        this.mailToutatice = mailToutatice;
    }
    /**
     * @param nomAaf the nomAaf to set
     */
    public void setNomAaf(String nomAaf) {
        this.nomAaf = nomAaf;
    }
    /**
     * @param nomAten the nomAten to set
     */
    public void setNomAten(String nomAten) {
        this.nomAten = nomAten;
    }
    /**
     * @param nomEduconnect the nomEduconnect to set
     */
    public void setNomEduconnect(String nomEduconnect) {
        this.nomEduconnect = nomEduconnect;
    }
    /**
     * @param nomSiecle the nomSiecle to set
     */
    public void setNomSiecle(String nomSiecle) {
        this.nomSiecle = nomSiecle;
    }
    /**
     * @param nomToutatice the nomToutatice to set
     */
    public void setNomToutatice(String nomToutatice) {
        this.nomToutatice = nomToutatice;
    }
    /**
     * @param prenomAaf the prenomAaf to set
     */
    public void setPrenomAaf(String prenomAaf) {
        this.prenomAaf = prenomAaf;
    }
    /**
     * @param prenomAten the prenomAten to set
     */
    public void setPrenomAten(String prenomAten) {
        this.prenomAten = prenomAten;
    }
    /**
     * @param prenomEduconnect the prenomEduconnect to set
     */
    public void setPrenomEduconnect(String prenomEduconnect) {
        this.prenomEduconnect = prenomEduconnect;
    }
    /**
     * @param prenomSiecle the prenomSiecle to set
     */
    public void setPrenomSiecle(String prenomSiecle) {
        this.prenomSiecle = prenomSiecle;
    }
    /**
     * @param prenomToutatice the prenomToutatice to set
     */
    public void setPrenomToutatice(String prenomToutatice) {
        this.prenomToutatice = prenomToutatice;
    }
    /**
     * @param represantantLegalSiecle the represantantLegalSiecle to set
     */
    public void setRepresentantLegalSiecle(List<String> represantantLegalSiecle) {
        this.representantLegalSiecle = represantantLegalSiecle;
    }
    /**
     * @param representantLegalAten the representantLegalAten to set
     */
    public void setRepresentantLegalAten(List<String> representantLegalAten) {
        this.representantLegalAten = representantLegalAten;
    }
    
}