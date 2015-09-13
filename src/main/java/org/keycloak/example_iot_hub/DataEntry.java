package org.keycloak.example_iot_hub;

import java.util.Date;

public class DataEntry {
    private Date time;
    private String value;
    
    public DataEntry(Date time, String value){
        this.time = time;
        this.value = value;
    }
    
    public Date getTime(){
        return time;
    }
    
    public String getValue(){
        return value;
    }
}
