package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.repotting;

import java.util.Date;
import java.util.UUID;

public class Repotting {

    private UUID id;
    private Date repottingDate;

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


}
