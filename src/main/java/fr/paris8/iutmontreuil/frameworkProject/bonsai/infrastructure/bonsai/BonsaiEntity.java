package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.pruning.PruningEntity;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.repotting.RepottingEntity;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.watering.WateringEntity;
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


    @OneToMany (targetEntity = WateringEntity.class)
    @OrderBy
    private List<WateringEntity> listeWatering;

    @OneToMany (targetEntity = RepottingEntity.class)
    @OrderBy
    private List<RepottingEntity> listeRepotting;

    @OneToMany (targetEntity = PruningEntity.class)
    @OrderBy
    private List<PruningEntity> listePrunnig;

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

    public List<PruningEntity> getListePrunnig() {
        return listePrunnig;
    }

    public void setListePrunnig(List<PruningEntity> listePrunnig) {
        this.listePrunnig = listePrunnig;
    }

    /* public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }*/
}
