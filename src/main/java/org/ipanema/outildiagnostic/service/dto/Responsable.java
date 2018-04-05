package org.ipanema.outildiagnostic.service.dto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Responsable{
    private String systemeInf;
    private Map<String, List<String>>  responsableResume;
    private Map<String, List<String>>  responsableDetaille;
    
   
   public  Responsable(){
       this.responsableDetaille=new HashMap<String,List<String>>();
       this.responsableResume=new HashMap<String,List<String>>();

   }
   /**
    * @return the responsableDetaille
    */
   public Map<String, List<String>> getResponsableDetaille() {
       return responsableDetaille;
   }
   /**
    * @return the responsableResume
    */
   public Map<String, List<String>> getResponsableResume() {
       return responsableResume;
   }
   /**
    * @return the systemeInf
    */
   public String getSystemeInf() {
       return systemeInf;
   }
   /**
    * @param responsableDetaille the responsableDetaille to set
    */
   public void setResponsableDetaille(Map<String, List<String>> responsableDetaille) {
       this.responsableDetaille = responsableDetaille;
   }
   /**
    * @param responsableResume the responsableResume to set
    */
   public void setResponsableResume(Map<String, List<String>> responsableResume) {
       this.responsableResume = responsableResume;
   }
   /**
    * @param systemeInf the systemeInf to set
    */
   public void setSystemeInf(String systemeInf) {
       this.systemeInf = systemeInf;
   }
   public String  toString(){
        return " Responsable{"+
       "systemeInf='"+getSystemeInf()+"'"+
       "responsableResume="+getResponsableResume()+
       ", responsableDetaille="+getResponsableDetaille()+"}";
   }


   
}