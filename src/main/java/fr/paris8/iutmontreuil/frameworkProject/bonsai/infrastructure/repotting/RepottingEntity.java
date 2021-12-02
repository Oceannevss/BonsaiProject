package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.repotting;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity(name = "repotting")
@Table (name = "repotting")
public class RepottingEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "repotting_date")
    private Date repotting_date;
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

    public Date getRepotting_date() {
        return repotting_date;
    }

    public void setRepotting_date(Date repotting_date) {
        this.repotting_date = repotting_date;
    }

}
