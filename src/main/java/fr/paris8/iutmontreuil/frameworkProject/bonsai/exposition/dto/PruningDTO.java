package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import java.util.Date;
import java.util.UUID;

public class PruningDTO {

    private UUID id;

    private Date pruningDate;

    private UUID bonsai_id;

    public PruningDTO(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getPruningDate() {
        return pruningDate;
    }

    public void setPruningDate(Date pruningDate) {
        this.pruningDate = pruningDate;
    }

    public UUID getBonsai_id() {
        return bonsai_id;
    }

    public void setBonsai_id(UUID bonsai_id) {
        this.bonsai_id = bonsai_id;
    }
}
