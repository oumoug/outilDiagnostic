package org.ipanema.outildiagnostic.service.dto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Eleve{
    private String systemeInf;
    private Map<String, List<String>>  eleveResume;
    private Map<String, List<String>>  eleveDetaille;
    private List<Parent> representant;
    public Eleve(){
        this.eleveDetaille=new HashMap<String, List<String>>();
        this.eleveResume=new HashMap<String, List<String>>();
        this.representant=new ArrayList<Parent>();

    }
    /**
     * @return the representant
     */
    public List<Parent> getRepresentant() {
        return representant;
    }
    /**
     * @return the eleveResume
     */
    public Map<String, List<String>> getEleveResume() {
        return eleveResume;
    }
    /**
     * @return the systemeInf
     */
    public String getSystemeInf() {
        return systemeInf;
    }
    /**
     * @return the eleveDetaille
     */
    public Map<String, List<String>> getEleveDetaille() {
        return eleveDetaille;
    }
    /**
     * @param eleveDetaille the eleveDetaille to set
     */
    public void setEleveDetaille(Map<String, List<String>> eleveDetaille) {
        this.eleveDetaille = eleveDetaille;
    }
    /**
     * @param eleveResume the eleveResume to set
     */
    public void setEleveResume(Map<String, List<String>> eleveResume) {
        this.eleveResume = eleveResume;
    }
    /**
     * @param systemeInf the systemeInf to set
     */
    public void setSystemeInf(String systemeInf) {
        this.systemeInf = systemeInf;
    }
    /**
     * @param representant the representant to set
     */
    public void setRepresentant(List<Parent> representant) {
        this.representant = representant;
    }
    public String toString(){
        return " Eleve{"+
        "systemeInf='"+getSystemeInf()+"'"+
        ",eleveResume="+getEleveResume()+
        ",eleveDetaille="+getEleveDetaille()+
        ",representant="+getRepresentant()+"}";

    }
    
}