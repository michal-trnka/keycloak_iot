package org.keycloak.example_iot_hub;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DataHolder {
    private LinkedList<DataEntry> temperatures = new LinkedList<DataEntry>();
    private LinkedList<DataEntry> movements = new LinkedList<DataEntry>();
    
    public void addTemperature(double temperature){
        temperatures.addFirst(new DataEntry(new Date(), Double.toString(temperature)));
        if(temperatures.size()>30){
            temperatures.removeLast();
        }
    }
    
    public List<DataEntry> getTemperatures(){
        return temperatures;
    }
    
    public void addMovement(String sensorID){
        movements.addFirst(new DataEntry(new Date(), sensorID));
        if(movements.size()>30){
            movements.removeLast();
        }
    }
    
    public List<DataEntry> getMovements(){
        return movements;
    }
}
