package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.entity;

import fr.paris8.iutmontreuil.frameworkProject.owner.infrastructure.OwnerEntity;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
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
    private LocalDate acquisitionDate;

    @Column (name = "acquisition_age")
    private int acquisitionAge;

    @Column (name = "status")
    private String status;

    @OneToMany (targetEntity = WateringEntity.class, mappedBy = "bonsai")
    private List<WateringEntity> listeWatering;

    @OneToMany (targetEntity = RepottingEntity.class, mappedBy = "bonsai")
    private List<RepottingEntity> listeRepotting;

    @OneToMany (targetEntity = PruningEntity.class, mappedBy = "bonsai")
    private List<PruningEntity> listePruning;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity ownerId;

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

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
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

    public List<WateringEntity> getListeWatering() {
        return listeWatering;
    }

    public void setListeWatering(List<WateringEntity> listeWatering) {
        this.listeWatering = listeWatering;
    }


    public List<RepottingEntity> getListeRepotting() {
        return listeRepotting;
    }

    public void setListeRepotting(List<RepottingEntity> listeRepotting) {
        this.listeRepotting = listeRepotting;
    }

    public List<PruningEntity> getListePruning() {
        return listePruning;
    }

    public void setListePruning(List<PruningEntity> listePruning) {
        this.listePruning = listePruning;
    }


    public OwnerEntity getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(OwnerEntity ownerId) {
        this.ownerId = ownerId;
    }
}
