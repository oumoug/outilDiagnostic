package org.ipanema.outildiagnostic.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Personnel implements Serializable{
    private String nomSirhen;
    private String prenomSirhen;
    private String dateNaissanceSirhen;
    private String positionSirhen;
    private String libelleSirhen;
    private String nomEpp;
    private String prenomEpp;
    private String  dateNaissanceEpp;
    private String libelleEpp;
    private String positionEpp;
    private List<String> infoCompEpp;
    private String gradeEpp;
    private String numenEpp;
    private String fonctionEpp;
    private String nomEppPrive;
    private String prenomEppPrive;
    private String dateNaissanceEppPrive;
    private String positionEppPrive;
    private String libelleEppPrive;
    private List<String> infoCompEppPrive;
    private String gradeEppPrive;
    private String numenEppPrive;
    private String nomAaf;
    private String  prenomAaf;
    private String dateNaissanceAaf;
    private String identifiantAaf;
    private String etablissementAaf;
    private String fonctionAaf;
    private String villeAaf;
    private String disciplineAaf;
    private String baseGestionAaf;
    private String nomAgora;
    private String prenomAgora;
    private String dateNaissanceAgora;
    private String positionAgora;
    private String libelleAgora;
    private List<String> infoCompAgora;
    public Personnel(){
        this.infoCompAgora=new ArrayList<String>();
        this.infoCompEpp=new ArrayList<String>();
        this.infoCompEppPrive=new ArrayList<String>();
    }
    /**
     * @param positionEpp the positionEpp to set
     */
    public void setPositionEpp(String positionEpp) {
        this.positionEpp = positionEpp;
    }

    /**
     * @return the positionEpp
     */
    public String getPositionEpp() {
        return positionEpp;
    }
    /**
     * @return the fonctionEpp
     */
    public String getFonctionEpp() {
        return fonctionEpp;
    }
    /**
     * @return the gradeEpp
     */
    public String getGradeEpp() {
        return gradeEpp;
    }
    /**
     * @return the numenEpp
     */
    public String getNumenEpp() {
        return numenEpp;
    }
    /**
     * @param fonctionEpp the fonctionEpp to set
     */
    public void setFonctionEpp(String fonctionEpp) {
        this.fonctionEpp = fonctionEpp;
    }
    /**
     * @param gradeEpp the gradeEpp to set
     */
    public void setGradeEpp(String gradeEpp) {
        this.gradeEpp = gradeEpp;
    }
    /**
     * @param numenEpp the numenEpp to set
     */
    public void setNumenEpp(String numenEpp) {
        this.numenEpp = numenEpp;
    }
    /**
     * @return the infoCompAgora
     */
    public List<String> getInfoCompAgora() {
        return infoCompAgora;
    }
    /**
     * @param infoCompAgora the infoCompAgora to set
     */
    public void setInfoCompAgora(List<String> infoCompAgora) {
        this.infoCompAgora = infoCompAgora;
    }
    /**
     * @return the gradeEppPrive
     */
    public String getGradeEppPrive() {
        return gradeEppPrive;
    }
    /**
     * @return the infoCompEpp
     */
    public List<String> getInfoCompEpp() {
        return infoCompEpp;
    }
    /**
     * @return the infoCompEppPrive
     */
    public List<String> getInfoCompEppPrive() {
        return infoCompEppPrive;
    }
    /**
     * @return the numenEppPrive
     */
    public String getNumenEppPrive() {
        return numenEppPrive;
    }
    /**
     * @param gradeEppPrive the gradeEppPrive to set
     */
    public void setGradeEppPrive(String gradeEppPrive) {
        this.gradeEppPrive = gradeEppPrive;
    }
    /**
     * @param infoCompEpp the infoCompEpp to set
     */
    public void setInfoCompEpp(List<String> infoCompEpp) {
        this.infoCompEpp = infoCompEpp;
    }
    /**
     * @param infoCompEppPrive the infoCompEppPrive to set
     */
    public void setInfoCompEppPrive(List<String> infoCompEppPrive) {
        this.infoCompEppPrive = infoCompEppPrive;
    }
    /**
     * @param numenEppPrive the numenEppPrive to set
     */
    public void setNumenEppPrive(String numenEppPrive) {
        this.numenEppPrive = numenEppPrive;
    }
    
    /**
     * @return the baseGestionAaf
     */
    public String getBaseGestionAaf() {
        return baseGestionAaf;
    }
    /**
     * @return the dateNaissanceAaf
     */
    public String getDateNaissanceAaf() {
        return dateNaissanceAaf;
    }
    /**
     * @return the dateNaissanceEpp
     */
    public String getDateNaissanceEpp() {
        return dateNaissanceEpp;
    }
    /**
     * @return the dateNaissanceAgora
     */
    public String getDateNaissanceAgora() {
        return dateNaissanceAgora;
    }
    /**
     * @return the dateNaissanceEppPrive
     */
    public String getDateNaissanceEppPrive() {
        return dateNaissanceEppPrive;
    }
    /**
     * @return the dateNaissanceSirhen
     */
    public String getDateNaissanceSirhen() {
        return dateNaissanceSirhen;
    }
    /**
     * @return the disciplineAaf
     */
    public String getDisciplineAaf() {
        return disciplineAaf;
    }
    /**
     * @return the etablissementAaf
     */
    public String getEtablissementAaf() {
        return etablissementAaf;
    }
    /**
     * @return the fonctionAaf
     */
    public String getFonctionAaf() {
        return fonctionAaf;
    }
    /**
     * @return the identifiantAaf
     */
    public String getIdentifiantAaf() {
        return identifiantAaf;
    }
    /**
     * @return the libelleAgora
     */
    public String getLibelleAgora() {
        return libelleAgora;
    }
    /**
     * @return the libelleEpp
     */
    public String getLibelleEpp() {
        return libelleEpp;
    }
    /**
     * @return the libelleEppPrive
     */
    public String getLibelleEppPrive() {
        return libelleEppPrive;
    }
    /**
     * @return the libelleSirhen
     */
    public String getLibelleSirhen() {
        return libelleSirhen;
    }
    /**
     * @return the nomAaf
     */
    public String getNomAaf() {
        return nomAaf;
    }
    /**
     * @return the nomAgora
     */
    public String getNomAgora() {
        return nomAgora;
    }
    /**
     * @return the nomEpp
     */
    public String getNomEpp() {
        return nomEpp;
    }
    /**
     * @return the nomEppPrive
     */
    public String getNomEppPrive() {
        return nomEppPrive;
    }
    /**
     * @return the nomSirhen
     */
    public String getNomSirhen() {
        return nomSirhen;
    }
    /**
     * @return the positionAgora
     */
    public String getPositionAgora() {
        return positionAgora;
    }
    /**
     * @return the positionEppPrive
     */
    public String getPositionEppPrive() {
        return positionEppPrive;
    }
    /**
     * @return the positionSirhen
     */
    public String getPositionSirhen() {
        return positionSirhen;
    }
    /**
     * @return the prenomAaf
     */
    public String getPrenomAaf() {
        return prenomAaf;
    }
    /**
     * @return the prenomAgora
     */
    public String getPrenomAgora() {
        return prenomAgora;
    }
    /**
     * @return the prenomEpp
     */
    public String getPrenomEpp() {
        return prenomEpp;
    }
    /**
     * @return the prenomEppPrive
     */
    public String getPrenomEppPrive() {
        return prenomEppPrive;
    }
    /**
     * @return the prenomSirhen
     */
    public String getPrenomSirhen() {
        return prenomSirhen;
    }
    /**
     * @return the villeAaf
     */
    public String getVilleAaf() {
        return villeAaf;
    }
    /**
     * @param baseGestionAaf the baseGestionAaf to set
     */
    public void setBaseGestionAaf(String baseGestionAaf) {
        this.baseGestionAaf = baseGestionAaf;
    }
    /**
     * @param dateNaissanceAaf the dateNaissanceAaf to set
     */
    public void setDateNaissanceAaf(String dateNaissanceAaf) {
        this.dateNaissanceAaf = dateNaissanceAaf;
    }
    /**
     * @param dateNaissanceAgora the dateNaissanceAgora to set
     */
    public void setDateNaissanceAgora(String dateNaissanceAgora) {
        this.dateNaissanceAgora = dateNaissanceAgora;
    }
    /**
     * @param dateNaissanceEpp the dateNaissanceEpp to set
     */
    public void setDateNaissanceEpp(String dateNaissanceEpp) {
        this.dateNaissanceEpp = dateNaissanceEpp;
    }
    /**
     * @param dateNaissanceEppPrive the dateNaissanceEppPrive to set
     */
    public void setDateNaissanceEppPrive(String dateNaissanceEppPrive) {
        this.dateNaissanceEppPrive = dateNaissanceEppPrive;
    }
    /**
     * @param dateNaissanceSirhen the dateNaissanceSirhen to set
     */
    public void setDateNaissanceSirhen(String dateNaissanceSirhen) {
        this.dateNaissanceSirhen = dateNaissanceSirhen;
    }
    /**
     * @param disciplineAaf the disciplineAaf to set
     */
    public void setDisciplineAaf(String disciplineAaf) {
        this.disciplineAaf = disciplineAaf;
    }
    /**
     * @param etablissementAaf the etablissementAaf to set
     */
    public void setEtablissementAaf(String etablissementAaf) {
        this.etablissementAaf = etablissementAaf;
    }
    /**
     * @param fonctionAaf the fonctionAaf to set
     */
    public void setFonctionAaf(String fonctionAaf) {
        this.fonctionAaf = fonctionAaf;
    }
    /**
     * @param identifiantAaf the identifiantAaf to set
     */
    public void setIdentifiantAaf(String identifiantAaf) {
        this.identifiantAaf = identifiantAaf;
    }
    /**
     * @param libelleAgora the libelleAgora to set
     */
    public void setLibelleAgora(String libelleAgora) {
        this.libelleAgora = libelleAgora;
    }
    /**
     * @param libelleEpp the libelleEpp to set
     */
    public void setLibelleEpp(String libelleEpp) {
        this.libelleEpp = libelleEpp;
    }
    /**
     * @param libelleEppPrive the libelleEppPrive to set
     */
    public void setLibelleEppPrive(String libelleEppPrive) {
        this.libelleEppPrive = libelleEppPrive;
    }
    /**
     * @param libelleSirhen the libelleSirhen to set
     */
    public void setLibelleSirhen(String libelleSirhen) {
        this.libelleSirhen = libelleSirhen;
    }
    /**
     * @param nomAaf the nomAaf to set
     */
    public void setNomAaf(String nomAaf) {
        this.nomAaf = nomAaf;
    }
    /**
     * @param nomAgora the nomAgora to set
     */
    public void setNomAgora(String nomAgora) {
        this.nomAgora = nomAgora;
    }
    /**
     * @param nomEpp the nomEpp to set
     */
    public void setNomEpp(String nomEpp) {
        this.nomEpp = nomEpp;
    }
    /**
     * @param nomEppPrive the nomEppPrive to set
     */
    public void setNomEppPrive(String nomEppPrive) {
        this.nomEppPrive = nomEppPrive;
    }
    /**
     * @param nomSirhen the nomSirhen to set
     */
    public void setNomSirhen(String nomSirhen) {
        this.nomSirhen = nomSirhen;
    }
    /**
     * @param positionAgora the positionAgora to set
     */
    public void setPositionAgora(String positionAgora) {
        this.positionAgora = positionAgora;
    }
    /**
     * @param positionEppPrive the positionEppPrive to set
     */
    public void setPositionEppPrive(String positionEppPrive) {
        this.positionEppPrive = positionEppPrive;
    }
    /**
     * @param positionSirhen the positionSirhen to set
     */
    public void setPositionSirhen(String positionSirhen) {
        this.positionSirhen = positionSirhen;
    }
    /**
     * @param prenomAaf the prenomAaf to set
     */
    public void setPrenomAaf(String prenomAaf) {
        this.prenomAaf = prenomAaf;
    }
    /**
     * @param prenomAgora the prenomAgora to set
     */
    public void setPrenomAgora(String prenomAgora) {
        this.prenomAgora = prenomAgora;
    }
    /**
     * @param prenomEpp the prenomEpp to set
     */
    public void setPrenomEpp(String prenomEpp) {
        this.prenomEpp = prenomEpp;
    }
    /**
     * @param prenomEppPrive the prenomEppPrive to set
     */
    public void setPrenomEppPrive(String prenomEppPrive) {
        this.prenomEppPrive = prenomEppPrive;
    }
    /**
     * @param prenomSirhen the prenomSirhen to set
     */
    public void setPrenomSirhen(String prenomSirhen) {
        this.prenomSirhen = prenomSirhen;
    }
    /**
     * @param villeAaf the villeAaf to set
     */
    public void setVilleAaf(String villeAaf) {
        this.villeAaf = villeAaf;
    }
    @Override
    public String toString() {
        return "Personnel{"+
        "nomSirhen='"+getNomSirhen()+"'"+
        ",prenomSirhen="+getPrenomSirhen()+
    ",dateNaissanceSirhen='"+getDateNaissanceSirhen()+"'"+
    ",positionSirhen='"+getPositionSirhen()+"'"+
    ",libelleSirhen='"+getLibelleSirhen()+"'"+
     ",nomEpp='"+getNomEpp()+"'"+
    ",prenomEpp='"+getPrenomEpp()+"'"+
    ",dateNaissanceEpp='"+getDateNaissanceEpp()+"'"+
    ",libelleEpp='"+getLibelleEpp()+"'"+
    ",positionEpp='"+getPositionEpp()+"'"+
    ",infoCompEpp='"+getInfoCompEpp()+"'"+
     ",gradeEpp='"+getGradeEpp()+"'"+
    ",numenEpp='"+getNumenEpp()+"'"+
   ",fonctionEpp='"+getFonctionEpp()+"'"+
    ",nomEppPrive='"+getNomEppPrive()+"'"+
    ",prenomEppPrive='"+getPrenomEppPrive()+"'"+
    ",dateNaissanceEppPrive='"+getDateNaissanceEppPrive()+"'"+
    ",positionEppPrive='"+getPositionEppPrive()+"'"+
    ",libelleEppPrive='"+getLibelleEppPrive()+"'"+
    ",infoCompEppPrive='"+getInfoCompEppPrive()+"'"+
    ",gradeEppPrive='"+getGradeEppPrive()+"'"+
    ",numenEppPrive='"+getNumenEppPrive()+"'"+
    ",nomAaf='"+getNomAaf()+"'"+
    ",prenomAaf='"+getPrenomAaf()+"'"+
    ",dateNaissanceAaf='"+getDateNaissanceAaf()+"'"+
    ",identifiantAaf='"+getIdentifiantAaf()+"'"+
    ",etablissementAaf='"+getEtablissementAaf()+"'"+
    ",fonctionAaf='"+getFonctionAaf()+"'"+
    ",villeAaf='"+getVilleAaf()+"'"+
    ",disciplineAaf='"+getDisciplineAaf()+"'"+
   ",baseGestionAaf='"+getBaseGestionAaf()+"'"+
    ",nomAgora='"+getNomAgora()+"'"+
    ",prenomAgora='"+getPrenomAgora()+"'"+
    ",dateNaissanceAgora='"+getDateNaissanceAgora()+"'"+
   ",positionAgora='"+getPositionAgora()+"'"+
   ",libelleAgora='"+getLibelleAgora()+
   ",infoCompAgora='"+getInfoCompAgora()+"'}";
    }


    public JSONObject PersonnelToJson() throws JSONException{
        JSONObject entity = new JSONObject();
        entity.put("nomSirhen",getNomSirhen());
        entity.put("prenomSirhen",getPrenomSirhen());
        entity.put("dateNaissanceSirhen",getDateNaissanceSirhen());
        entity.put("positionSirhen",getPositionSirhen());
        entity.put("libelleSirhen",getLibelleSirhen());
        entity.put("nomEpp",getNomEpp());
        entity.put("dateNaissanceEpp",getDateNaissanceEpp());
        entity.put("libelleEpp=",getLibelleEpp());
        entity.put("nomEppPrive",getNomEppPrive());
        entity.put("prenomEppPrive",getPrenomEppPrive());
        entity.put("dateNaissanceEppPrive",getDateNaissanceEppPrive());
        entity.put("positionEppPrive",getPositionEppPrive());
        entity.put("libelleEppPrive",getLibelleEppPrive());
        entity.put("nomAaf",getNomAaf());
        entity.put("nomAaf",getNomAaf());
        entity.put("prenomAaf",getPrenomAaf());
        entity.put("dateNaissanceAaf",getDateNaissanceAaf());
        entity.put("identifiantAaf",getIdentifiantAaf());
        entity.put("etablissementAaf",getEtablissementAaf());
        entity.put("fonctionAaf",getFonctionAaf());
        entity.put("villeAaf",getVilleAaf());
        entity.put("disciplineAaf",getDisciplineAaf());
        entity.put("baseGestionAaf",getBaseGestionAaf());
        entity.put("nomAgora",getNomAgora());
        entity.put( "prenomAgora",getPrenomAgora());
        entity.put("dateNaissanceAgora",getDateNaissanceAgora());
        entity.put("positionAgora",getPositionAgora());
        entity.put("libelleAgora",getLibelleAgora());

        return entity;
    }
    

}