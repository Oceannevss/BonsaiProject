package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.repotting;

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
    @Column(name = "bonsai_id")
    private UUID bonsai_id;

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

}
