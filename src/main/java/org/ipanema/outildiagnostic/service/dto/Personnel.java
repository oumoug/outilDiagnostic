package org.ipanema.outildiagnostic.service.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class Personnel{
    private String systemeInf;
    private Map<String, List<String>>  personnelResume;
    private Map<String, List<String>>  personnelDetaille;
   
   public  Personnel(){
       this.personnelDetaille=new HashMap<String,List<String>>();
       this.personnelResume=new HashMap<String,List<String>>();

   }
    
    /**
     * @return the systemeInf
     */
    public String getSystemeInf() {
        return systemeInf;
    }
    /**
     * @return the personnelResume
     */
    public Map<String, List<String>> getPersonnelResume() {
        return personnelResume;
    }
    /**
     * @return the personnelDetaille
     */
    public Map<String, List<String>> getPersonnelDetaille() {
        return personnelDetaille;
    }
    /**
     * @param personnelDetaille the personnelDetaille to set
     */
    public void setPersonnelDetaille(Map<String, List<String>> personnelDetaille) {
        this.personnelDetaille = personnelDetaille;
    }
    /**
     * @param personnelResume the personnelResume to set
     */
    public void setPersonnelResume(Map<String, List<String>> personnelResume) {
        this.personnelResume = personnelResume;
    }
    /**
     * @param systemeInf the systemeInf to set
     */
    public void setSystemeInf(String systemeInf) {
        this.systemeInf = systemeInf;
    }
    public String toString(){
        return " Personnel{"+
        "systemeInf='"+getSystemeInf()+"'"+
        ",personnelResume='"+getPersonnelResume()+"'"+
        ", personnelDetaille='"+getPersonnelDetaille()+"'}";
    }

    
}