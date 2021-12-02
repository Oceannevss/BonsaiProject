package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai.BonsaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Service
public class BonsaiService {

    @Autowired
    private BonsaiRepository bonsaiRepository;

    public BonsaiService(BonsaiRepository bonsaiRepository) {
        this.bonsaiRepository= bonsaiRepository;
    }

    /*@GetMapping("/{uuid}")
    public ResponseEntity<?> FindById(@PathVariable("uuid") UUID uuid) {
        return bonsaiRepository.FindById(uuid);
    }*/


    public Optional<Bonsai> findById(@PathVariable("uuid") UUID uuid) {
        return bonsaiRepository.findById(uuid);
    }


    public Bonsai create(@RequestBody Bonsai bonsai){

       return bonsaiRepository.create(BonsaiMapper.BonsaiToEntity(bonsai));

    }


    public void delete(UUID uuid){

        bonsaiRepository.delete(uuid);
    }

    public Optional<Bonsai> update(UUID id, Bonsai updatedBonsai) {

        Optional<Bonsai> bonsai = bonsaiRepository.findById(id);

        if (bonsai.isPresent()) {
            bonsai.get().setName(updatedBonsai.getName());
            bonsai.get().setSpecies(updatedBonsai.getSpecies());
            bonsai.get().setAcquisitionDate(updatedBonsai.getAcquisitionDate());
            bonsai.get().setAcquisitionAge(updatedBonsai.getAcquisitionAge());
            return Optional.of(bonsaiRepository.update(bonsai.get()));
        }
        return bonsai;
    }
}
