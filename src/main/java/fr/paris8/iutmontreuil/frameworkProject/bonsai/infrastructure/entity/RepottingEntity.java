package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "repotting")
@Table (name = "repotting")
public class RepottingEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;
    @Column(name = "repotting_date")
    private Date repottingDate;
    @ManyToOne
    @JoinColumn(name = "bonsai_id")
    private BonsaiEntity bonsai;

    public RepottingEntity() {
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

    public void setRepottingDate(Date repotting_date) {
        this.repottingDate = repotting_date;
    }

    public BonsaiEntity getBonsai() {
        return bonsai;
    }

    public void setBonsai(BonsaiEntity bonsai) {
        this.bonsai = bonsai;
    }
}
