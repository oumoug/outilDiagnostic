package org.ipanema.outildiagnostic.service.dto;

import java.util.ArrayList;
import java.util.List;

public class RecordEleve{
    private List<Eleve> eleves;
    private List<String> menus;
    public RecordEleve(){
        this.menus=new ArrayList<String>();
        this. eleves=new ArrayList<Eleve>();

    }
    /**
     * @return the resultat
     */
    public List<Eleve> getEleves() {
        return eleves;
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
    public void setEleves(List<Eleve> resultat) {
        this.eleves = resultat;
    }
    public String toString(){
        return "RecordEleve{"+
        "eleves="+getEleves()+
        ",menus="+getMenus()+"}";
    }
}