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
    private UUID id;
    @Column(name = "pruning_date")
    private Date pruningDate;


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

    public void setPruning_date(Date pruning_date) {
        this.pruningDate = pruning_date;
    }


}
