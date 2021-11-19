package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;

import javax.persistence.Column;
import java.util.UUID;

public class BonsaiDTO {

    private UUID id;

    private String name;

    private String species;

    private String acquisitionDate;

    private int acquisitionAge;

    private String status;

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
