package org.ipanema.outildiagnostic.service.dto;

import java.util.ArrayList;
import java.util.List;

public class RecordResponsable{
    private List<Responsable> responsables;
    private List<String> menus;
    public RecordResponsable(){
        this.menus=new ArrayList<String>();
        this.responsables=new ArrayList<Responsable>();

    }
    /**
     * @return the resultat
     */
    public List<Responsable> getResponsables() {
        return responsables;
    }
    /**
     * @return the menu
     */
    public List<String> getMenus() {
        return menus;
    }
    /**
     * @param menus the menu to set
     */
    public void setMenus(List<String> menu) {
        this.menus = menu;
    }
    /**
     * @param resultat the resultat to set
     */
    public void setResponsables(List<Responsable> resultat) {
        this.responsables = resultat;
    }
    public String toString(){
        return "RecordResponsable{"+
        "responsables="+getResponsables()+
        ",menus="+getMenus()+"}";
    }
}