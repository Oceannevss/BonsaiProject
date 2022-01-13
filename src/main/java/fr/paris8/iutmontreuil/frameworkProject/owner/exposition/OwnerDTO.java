package fr.paris8.iutmontreuil.frameworkProject.owner.exposition;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto.BonsaiDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OwnerDTO {

    private UUID id;
    private String name;
    private List<BonsaiDTO> bonsais;

    public OwnerDTO() {
        this.bonsais = new ArrayList<>();
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

    public List<BonsaiDTO> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<BonsaiDTO> bonsais) {
        this.bonsais = bonsais;
    }
}
