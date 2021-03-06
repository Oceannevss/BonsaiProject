package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model;

import fr.paris8.iutmontreuil.frameworkProject.owner.domaine.Owner;

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

    private Owner ownerId;

    private List<Watering> listeWatering;

    private List<Repotting> listRepottings;

    private List<Pruning> listPrunings;

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

    public List<Watering> getListeWatering() {
        return listeWatering;
    }

    public void setListeWatering(List<Watering> listeWatering) {
        this.listeWatering = listeWatering;
    }

    public List<Repotting> getListRepottings() {
        return listRepottings;
    }

    public void setListRepottings(List<Repotting> listRepottings) {
        this.listRepottings = listRepottings;
    }

    public List<Pruning> getListPrunings() {
        return listPrunings;
    }

    public void setListPrunings(List<Pruning> listPrunings) {
        this.listPrunings = listPrunings;
    }

    public Owner getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Owner ownerId) {
        this.ownerId = ownerId;
    }

}
