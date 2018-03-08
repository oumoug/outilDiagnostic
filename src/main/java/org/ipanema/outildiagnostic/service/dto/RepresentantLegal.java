package org.ipanema.outildiagnostic.service.dto;
import java.util.ArrayList;
import java.util.List;

public class RepresentantLegal{
    private String nomSiecle;
    private  String prenomSiecle;
    private  String etablissementSiecle;
    private  List<String>  identifiantEnfantSiecle;
    private  String  dateSortieSiecle;
    private  String  nomAaf;
    private  String  prenomAaf;
    private  String  identifiantAaf;
    private  String  etablissementAaf;
    private  String  nomAten;
    private  String  prenomAten;
    private  String identifiantAten;
    private  String  mailAten;
    private  String  etatcompteAten;
    private  String  lastConAten;
    private  List<String>  identifiantEnfantAten;
    private  String nomToutatice;
    private  String prenomToutatice;
    private  String identifiantToutatice;
    private  String mailToutatice;
    private  String etatCompteToutatice;
    private  String lastConToutatice;
    private   List<String> identifiantEnfantToutatice;
    private  String nomEduconnect;
    private  String  prenomEduconnect;
    private  String  identifiantEduconnect;
    private  String mailEduconnect;
    private  String  etatCompteEduconnect;
    private  String   lastConEduconnect;
    private   List<String> identifiantEnfantEduconnect;
    public RepresentantLegal(){
        this.identifiantEnfantAten=new ArrayList<String>();
        this.identifiantEnfantEduconnect=new ArrayList<String>();

    }
    /**
     * @return the dateSortieSiecle
     */
    public String getDateSortieSiecle() {
        return dateSortieSiecle;
    }
    /**
     * @return the etablissementAaf
     */
    public String getEtablissementAaf() {
        return etablissementAaf;
    }
    /**
     * @return the etablissementSiecle
     */
    public String getEtablissementSiecle() {
        return etablissementSiecle;
    }
    /**
     * @return the etatcompteAten
     */
    public String getEtatcompteAten() {
        return etatcompteAten;
    }
    /**
     * @return the etatCompteEduconnect
     */
    public String getEtatCompteEduconnect() {
        return etatCompteEduconnect;
    }
    /**
     * @return the etatCompteToutatice
     */
    public String getEtatCompteToutatice() {
        return etatCompteToutatice;
    }
    /**
     * @return the identifiantAaf
     */
    public String getIdentifiantAaf() {
        return identifiantAaf;
    }
    /**
     * @return the identifiantAten
     */
    public String getIdentifiantAten() {
        return identifiantAten;
    }
    /**
     * @return the identifiantEduconnect
     */
    public String getIdentifiantEduconnect() {
        return identifiantEduconnect;
    }
    /**
     * @return the identifiantEnfantAten
     */
    public List<String> getIdentifiantEnfantAten() {
        return identifiantEnfantAten;
    }
    /**
     * @return the identifiantEnfantEduconnect
     */
    public List<String> getIdentifiantEnfantEduconnect() {
        return identifiantEnfantEduconnect;
    }
    /**
     * @return the identifiantEnfantSiecle
     */
    public List<String> getIdentifiantEnfantSiecle() {
        return identifiantEnfantSiecle;
    }
    /**
     * @return the identifiantEnfantToutatice
     */
    public List<String> getIdentifiantEnfantToutatice() {
        return identifiantEnfantToutatice;
    }
    /**
     * @return the identifiantToutatice
     */
    public String getIdentifiantToutatice() {
        return identifiantToutatice;
    }
    /**
     * @return the lastConAten
     */
    public String getLastConAten() {
        return lastConAten;
    }
    /**
     * @return the lastConEduconnect
     */
    public String getLastConEduconnect() {
        return lastConEduconnect;
    }
    /**
     * @return the lastConToutatice
     */
    public String getLastConToutatice() {
        return lastConToutatice;
    }
    /**
     * @return the mailAten
     */
    public String getMailAten() {
        return mailAten;
    }
    /**
     * @return the mailEduconnect
     */
    public String getMailEduconnect() {
        return mailEduconnect;
    }
    /**
     * @return the mailToutatice
     */
    public String getMailToutatice() {
        return mailToutatice;
    }
    /**
     * @return the nomAaf
     */
    public String getNomAaf() {
        return nomAaf;
    }
    /**
     * @return the nomAten
     */
    public String getNomAten() {
        return nomAten;
    }
    /**
     * @return the nomEduconnect
     */
    public String getNomEduconnect() {
        return nomEduconnect;
    }
    /**
     * @return the nomSiecle
     */
    public String getNomSiecle() {
        return nomSiecle;
    }
    /**
     * @return the nomToutatice
     */
    public String getNomToutatice() {
        return nomToutatice;
    }
    /**
     * @return the prenomAaf
     */
    public String getPrenomAaf() {
        return prenomAaf;
    }
    /**
     * @return the prenomAten
     */
    public String getPrenomAten() {
        return prenomAten;
    }
    /**
     * @return the prenomEduconnect
     */
    public String getPrenomEduconnect() {
        return prenomEduconnect;
    }
    /**
     * @return the prenomSiecle
     */
    public String getPrenomSiecle() {
        return prenomSiecle;
    }
    /**
     * @return the prenomToutatice
     */
    public String getPrenomToutatice() {
        return prenomToutatice;
    }
    /**
     * @param dateSortieSiecle the dateSortieSiecle to set
     */
    public void setDateSortieSiecle(String dateSortieSiecle) {
        this.dateSortieSiecle = dateSortieSiecle;
    }
    /**
     * @param etablissementAaf the etablissementAaf to set
     */
    public void setEtablissementAaf(String etablissementAaf) {
        this.etablissementAaf = etablissementAaf;
    }

    /**
     * @param etablissementSiecle the etablissementSiecle to set
     */
    public void setEtablissementSiecle(String etablissementSiecle) {
        this.etablissementSiecle = etablissementSiecle;
    }
    /**
     * @param etatcompteAten the etatcompteAten to set
     */
    public void setEtatcompteAten(String etatcompteAten) {
        this.etatcompteAten = etatcompteAten;
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
     * @param identifiantEnfantAten the identifiantEnfantAten to set
     */
    public void setIdentifiantEnfantAten(List<String> identifiantEnfantAten) {
        this.identifiantEnfantAten = identifiantEnfantAten;
    }
    /**
     * @param identifiantEnfantEduconnect the identifiantEnfantEduconnect to set
     */
    public void setIdentifiantEnfantEduconnect(List<String> identifiantEnfantEduconnect) {
        this.identifiantEnfantEduconnect = identifiantEnfantEduconnect;
    }
    /**
     * @param identifiantEnfantSiecle the identifiantEnfantSiecle to set
     */
    public void setIdentifiantEnfantSiecle(List<String> identifiantEnfantSiecle) {
        this.identifiantEnfantSiecle = identifiantEnfantSiecle;
    }
    /**
     * @param identifiantEnfantToutatice the identifiantEnfantToutatice to set
     */
    public void setIdentifiantEnfantToutatice(List<String> identifiantEnfantToutatice) {
        this.identifiantEnfantToutatice = identifiantEnfantToutatice;
    }
    /**
     * @param identifiantToutatice the identifiantToutatice to set
     */
    public void setIdentifiantToutatice(String identifiantToutatice) {
        this.identifiantToutatice = identifiantToutatice;
    }
    /**
     * @param lastConAten the lastConAten to set
     */
    public void setLastConAten(String lastConAten) {
        this.lastConAten = lastConAten;
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
     * @param mailAten the mailAten to set
     */
    public void setMailAten(String mailAten) {
        this.mailAten = mailAten;
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
    
}