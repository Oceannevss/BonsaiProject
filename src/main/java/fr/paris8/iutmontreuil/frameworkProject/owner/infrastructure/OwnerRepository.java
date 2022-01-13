package fr.paris8.iutmontreuil.frameworkProject.owner.infrastructure;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.DAO.BonsaiDao;
import fr.paris8.iutmontreuil.frameworkProject.owner.Mapper.OwnerMapper;
import fr.paris8.iutmontreuil.frameworkProject.owner.domaine.Owner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OwnerRepository {

    private OwnerDao ownerDao;
    private BonsaiDao bonsaiDao;

    public OwnerRepository(OwnerDao ownerDao, BonsaiDao bonsaiDao) {
        this.ownerDao = ownerDao;
        this.bonsaiDao = bonsaiDao;
    }

    public List<Owner> findAll() {
        return ownerDao.findAll().stream().map(OwnerMapper::entityToOwner).collect(Collectors.toList());
    }

    public Optional<Owner> findById(UUID id) {
        return ownerDao.findById(id).map(OwnerMapper::entityToOwner);
    }

    public Owner create(Owner owner) {

        OwnerEntity ownerEntity = OwnerMapper.ownerToEntity(owner);
        OwnerEntity save = ownerDao.save(ownerEntity);

        return OwnerMapper.entityToOwner(save);
    }

    /*public List<Bonsai> getBonsais(UUID id) {
        return bonsaiDao.findAll().stream()
                .filter(b -> b.getOwner() != null && b.getOwner().getId().equals(id))
                .map(OwnerMapper::toBonsa)
                .collect(Collectors.toList());
    }

    public Bonsai transferBonsai(Owner newOwner, Bonsai bonsai) {
        ownerDao.updateOwnerId(newOwner.getId(), bonsai.getId());
        return bonsai;
    }

    public Bonsai addBonsai(Owner owner, Bonsai bonsai) {
        ownerDao.updateOwnerId(owner.getId(), bonsai.getId());
        return bonsai;
    }

    public Optional<Bonsai> findBonsaiById(UUID id) {
        return bonsaiDao.findById(id).map(OwnerMapper::toBonsai);
    }*/
}
