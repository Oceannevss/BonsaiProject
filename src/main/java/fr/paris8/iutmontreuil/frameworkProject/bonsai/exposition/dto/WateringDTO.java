package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import java.util.Date;
import java.util.UUID;

public class WateringDTO {

    private UUID id;
    private Date wateringDate;


    public WateringDTO(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getWateringDate() {
        return wateringDate;
    }

    public void setWateringDate(Date wateringDate) {
        this.wateringDate = wateringDate;
    }

}
