package org.ipanema.outildiagnostic.service.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecordPersonnel{
    private List<Personnel> resultat;
    private List<String> menu;
    public RecordPersonnel(){
        this.menu=new ArrayList<String>();
        this.resultat=new ArrayList<Personnel>();

    }
    /**
     * @return the resultat
     */
    public List<Personnel> getResultat() {
        return resultat;
    }
    /**
     * @return the menu
     */
    public List<String> getMenu() {
        return menu;
    }
    /**
     * @param menu the menu to set
     */
    public void setMenu(List<String> menu) {
        this.menu = menu;
    }
    /**
     * @param resultat the resultat to set
     */
    public void setResultat(List<Personnel> resultat) {
        this.resultat = resultat;
    }
    public String toString(){
        return "RecordPersonnel{"+
        "resultat='"+getResultat()+"'"+
        ",menu='"+getMenu()+"'}";

    }
}