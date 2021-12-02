package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.watering;

import java.util.Date;
import java.util.UUID;

public class Watering {

    private UUID id;
    private Date wateringDate;

    public Watering() {
    }

    public UUID getId() {
        return id;
    }

    public void setUuid(UUID id) {
        this.id = id;
    }

    public Date getWateringDate() {
        return wateringDate;
    }

    public void setWatering_date(Date wateringDate) {
        this.wateringDate = wateringDate;
    }

}
