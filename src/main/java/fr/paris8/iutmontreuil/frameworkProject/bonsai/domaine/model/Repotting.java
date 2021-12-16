package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model;

import java.util.Date;
import java.util.UUID;

public class Repotting {

    private UUID id;
    private Date repottingDate;
    private UUID bonsai_id;

    public Repotting() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getRepottingDate() {
        return repottingDate;
    }

    public void setRepottingDate(Date repottingDate) {
        this.repottingDate = repottingDate;
    }

    public UUID getBonsai_id() {
        return bonsai_id;
    }

    public void setBonsai_id(UUID bonsai_id) {
        this.bonsai_id = bonsai_id;
    }
}
