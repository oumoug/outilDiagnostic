package org.ipanema.outildiagnostic.service.dto;

import java.util.List;
import java.util.Map;

public class Record{
private String id;
private String source;
private Map<String,List<String>> propriétes;
/**
 * @return the id
 */
public String getId() {
    return id;
}
/**
 * @return the propriétes
 */
public Map<String, List<String>> getPropriétes() {
    return propriétes;
}
/**
 * @return the source
 */
public String getSource() {
    return source;
}
/**
 * @param id the id to set
 */
public void setId(String id) {
    this.id = id;
}
/**
 * @param propriétes the propriétes to set
 */
public void setPropriétes(Map<String, List<String>> propriétes) {
    this.propriétes = propriétes;
}
/**
 * @param source the source to set
 */
public void setSource(String source) {
    this.source = source;
}

}