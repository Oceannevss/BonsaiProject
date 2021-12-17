package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.watering;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai.BonsaiEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity (name = "watering")
@Table(name = "watering")
public class WateringEntity {

        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "id")
        private UUID id;
        @Column(name = "watering_date")
        private Date wateringDate;
        @ManyToOne
        @JoinColumn(name = "bonsai_id")
        private BonsaiEntity bonsai;



        public WateringEntity() {
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public Date getWatering_date() {
            return wateringDate;
        }

        public void setWatering_date(Date watering_date) {
            this.wateringDate = watering_date;
        }

        public BonsaiEntity getBonsai_id() {
            return bonsai;
        }

        public void setBonsai_id(BonsaiEntity bonsai_id) {
            this.bonsai = bonsai_id;
        }
}
