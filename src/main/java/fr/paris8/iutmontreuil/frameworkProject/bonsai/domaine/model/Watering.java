package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model;

import java.util.Date;
import java.util.UUID;

public class Watering {

    private UUID id;
    private Date wateringDate;
    private Bonsai bonsai_id;

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

    public Bonsai getBonsai_id() {
        return bonsai_id;
    }

    public void setBonsai_id(Bonsai bonsai_id) {
        this.bonsai_id = bonsai_id;
    }
}
