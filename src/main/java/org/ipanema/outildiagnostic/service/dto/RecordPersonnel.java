package org.ipanema.outildiagnostic.service.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecordPersonnel{
    private List<Personnel> personnels;
    private List<String> menus;
    public RecordPersonnel(){
        this.menus=new ArrayList<String>();
        this.personnels=new ArrayList<Personnel>();

    }
    /**
     * @return the resultat
     */
    public List<Personnel> getPersonnels() {
        return personnels;
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
    public void setPersonnels(List<Personnel> resultat) {
        this.personnels = resultat;
    }
    public String toString(){
        return "RecordPersonnel{"+
        "resultat='"+getPersonnels()+"'"+
        ",menus='"+getMenus()+"'}";
    }
}