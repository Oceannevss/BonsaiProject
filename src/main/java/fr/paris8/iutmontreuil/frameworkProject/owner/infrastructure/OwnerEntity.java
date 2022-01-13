package fr.paris8.iutmontreuil.frameworkProject.owner.infrastructure;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.entity.BonsaiEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "owner")
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @OneToMany (targetEntity = BonsaiEntity.class, mappedBy = "ownerId")
    private List<BonsaiEntity> listBonsais ;

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

    public List<BonsaiEntity> getListBonsais() {
        return listBonsais;
    }

    public void setListBonsais(List<BonsaiEntity> listBonsais) {
        this.listBonsais = listBonsais;
    }
}
