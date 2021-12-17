package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.pruning;


import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai.BonsaiEntity;
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
    @ManyToOne
    @JoinColumn(name = "bonsai_id")
    private BonsaiEntity bonsai;


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

    public BonsaiEntity getBonsai() {
        return bonsai;
    }

    public void setBonsai(BonsaiEntity bonsai) {
        this.bonsai = bonsai;
    }
}
