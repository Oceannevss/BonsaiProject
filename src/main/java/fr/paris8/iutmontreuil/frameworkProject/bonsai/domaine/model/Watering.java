package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model;

import java.util.Date;
import java.util.UUID;

public class Watering {

    private UUID id;
    private Date wateringDate;
    private UUID bonsai_id;

    public Watering() {
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

    public void setWatering_date(Date wateringDate) {
        this.wateringDate = wateringDate;
    }

    public UUID getBonsai_id() {
        return bonsai_id;
    }

    public void setBonsai_id(UUID bonsai_id) {
        this.bonsai_id = bonsai_id;
    }
}
