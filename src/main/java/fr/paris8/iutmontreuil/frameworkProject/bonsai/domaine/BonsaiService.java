package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.BonsaiEntity;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.BonsaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{uuid}")
    public Optional<Bonsai> FindById(@PathVariable("uuid") UUID uuid) {
        return bonsaiRepository.FindById(uuid);
    }

    @PostMapping
    public Bonsai create(@RequestBody Bonsai bonsai){

       return bonsaiRepository.create(BonsaiMapper.BonsaiToEntity(bonsai));

    }
}
