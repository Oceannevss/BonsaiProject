package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.UUID;

@Entity (name = "bonsai")
@Table (name = "bonsai")
public class BonsaiEntity {

   @Id
   @GeneratedValue(generator = "uuid2")
   @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
   @Column (name = "id")
   private UUID id;

   @Column (name = "name")
   private String name;

   @Column (name = "species")
   private String species;

   @Column (name = "acquisition_date")
   private String acquisitionDate;

   @Column (name = "acquisition_age")
   private int acquisitionAge;

   @Column (name = "status")
   private String status;

   public BonsaiEntity(){

   }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
   }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public int getAcquisitionAge() {
        return acquisitionAge;
    }

    public void setAcquisitionAge(int acquisitionAge) {
        this.acquisitionAge = acquisitionAge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
