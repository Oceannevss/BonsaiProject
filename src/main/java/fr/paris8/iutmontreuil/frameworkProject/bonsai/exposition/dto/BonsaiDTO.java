package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class BonsaiDTO {

    private UUID id;

    private String name;

    private String species;

    private LocalDate acquisitionDate;

    private int acquisitionAge;

    private String status;

    private UUID ownerId;

    private Date lastWatering;
    private Date lastRepotting;
    private Date lastPruning;

    public BonsaiDTO(){

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

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public Date getLastWatering() {
        return lastWatering;
    }

    public void setLastWatering(Date lastWatering) {
        this.lastWatering = lastWatering;
    }

    public Date getLastRepotting() {
        return lastRepotting;
    }

    public void setLastRepotting(Date lastRepotting) {
        this.lastRepotting = lastRepotting;
    }

    public Date getLastPruning() {
        return lastPruning;
    }

    public void setLastPruning(Date lastPruning) {
        this.lastPruning = lastPruning;
    }
}
