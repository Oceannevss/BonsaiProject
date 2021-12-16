package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.pruning.PruningEntity;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.repotting.RepottingEntity;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.watering.WateringEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Bonsai {

    private UUID id;

    private String name;

    private String species;

    private LocalDate acquisitionDate;

    private int acquisitionAge;

    private String status;

    private UUID ownerId;

    private List<WateringEntity> listeWatering;

    private List<RepottingEntity> listRepottings;

    private List<PruningEntity> listPrunings;

    public Bonsai(){

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

    public List<RepottingEntity> getListRepottings() {
        return listRepottings;
    }

    public void setListRepottings(List<RepottingEntity> listRepottings) {
        this.listRepottings = listRepottings;
    }

    public List<PruningEntity> getListPrunings() {
        return listPrunings;
    }

    public void setListPrunings(List<PruningEntity> listPrunings) {
        this.listPrunings = listPrunings;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

}
