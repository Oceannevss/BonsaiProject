package fr.paris8.iutmontreuil.frameworkProject.owner.infrastructure;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.DAO.BonsaiDao;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.entity.OwnerEntity;
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

        return ownerDao.findAll()
                        .stream()
                        .map(OwnerMapper::entityToOwner)
                        .collect(Collectors.toList());
    }

    public Optional<Owner> findById(UUID uuid) {

        Optional<OwnerEntity> res = ownerDao.findById(uuid);

        return res.map(ownerEntity -> OwnerMapper.entityToOwner(ownerEntity));

    }

    public Owner create(Owner owner) {

        OwnerEntity ownerEntity = OwnerMapper.ownerToEntity(owner);
        OwnerEntity save = ownerDao.save(ownerEntity);

        return OwnerMapper.entityToOwner(save);
    }

    public List<Bonsai> getBonsais(UUID id) {
        return bonsaiDao.findAll()
                        .stream()
                        .filter(b -> b.getOwner() != null && b.getOwner().getId().equals(id))
                        .map(BonsaiMapper::EntityToBonsai)
                        .collect(Collectors.toList());
    }

    public Bonsai transferBonsaiToOwner(Owner new_owner, Bonsai bonsai) {

        ownerDao.addNewOwner(new_owner.getId(), bonsai.getId());

        return bonsai;
    }

    public Bonsai addBonsaiToOwner(Owner owner, Bonsai bonsai) {

        ownerDao.addNewBonsai(owner.getId(), bonsai.getId());

        return bonsai;
    }

    public Optional<Bonsai> findBonsaiById(UUID id) {
        return bonsaiDao.findById(id).map(BonsaiMapper::EntityToBonsai);
    }

    public void delete(UUID uuid){

        OwnerEntity ownerEntity = ownerDao.getById(uuid);
        ownerDao.delete(ownerEntity);
    }
}
