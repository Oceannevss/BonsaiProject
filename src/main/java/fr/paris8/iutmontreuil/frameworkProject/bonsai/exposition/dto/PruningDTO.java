package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import java.util.Date;
import java.util.UUID;

public class PruningDTO {

    private UUID id;

    private Date pruningDate;

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
}
