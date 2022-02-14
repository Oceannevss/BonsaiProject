package fr.paris8.iutmontreuil.frameworkProject.owner.domaine;


import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.owner.infrastructure.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> findAll() {

        return ownerRepository.findAll();
    }

    public Optional<Owner> findById(UUID id) {
        return ownerRepository.findById(id);
    }

    public Owner create(Owner owner) {

        return ownerRepository.create(owner);
    }

    public List<Bonsai> getBonsais(UUID uuid) {

        return ownerRepository.getBonsais(uuid);
    }

   public Optional<Bonsai> transferBonsaiToOwner(UUID owner_id, UUID bonsai_id, Owner new_owner) {

        Optional<Owner> owner = ownerRepository.findById(owner_id);
        Optional<Bonsai> bonsai = ownerRepository.findBonsaiById(bonsai_id);

        if (bonsai.isPresent() && owner.isPresent()) {

            return Optional.of(ownerRepository.transferBonsaiToOwner(new_owner, bonsai.get()));
        }


        return Optional.empty();
    }

    public List<Bonsai> addBonsaiToOwner(UUID owner_id, List<Bonsai> bonsais) {

        List<Bonsai> listeBonsais = new ArrayList<>();
        Optional<Owner> owner = ownerRepository.findById(owner_id);

        if(owner.isPresent()){
            for(Bonsai b : bonsais){
                if(b.getOwnerId() != null){
                    listeBonsais.add(ownerRepository.addBonsaiToOwner(owner.get(),b));
                }
            }
        }

        return listeBonsais;
    }

    public void delete(UUID uuid){

        ownerRepository.delete(uuid);
    }
}
