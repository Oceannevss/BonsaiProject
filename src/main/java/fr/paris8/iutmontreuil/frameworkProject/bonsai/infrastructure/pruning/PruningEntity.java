package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.pruning;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "pruning")
@Table(name = "pruning")
public class PruningEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;
    @Column(name = "pruning_date")
    private Date pruningDate;
    @Column(name = "bonsai_id")
    private UUID bonsai_id;


    public PruningEntity() {
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

    public void setPruningDate(Date pruning_date) {
        this.pruningDate = pruning_date;
    }

    public UUID getBonsai_id() {
        return bonsai_id;
    }

    public void setBonsai_id(UUID bonsai_id) {
        this.bonsai_id = bonsai_id;
    }
}
