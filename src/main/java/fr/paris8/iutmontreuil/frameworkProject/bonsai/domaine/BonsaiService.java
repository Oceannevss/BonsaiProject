package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.WateringMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.pruning.Pruning;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.repotting.Repotting;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.watering.Watering;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto.BonsaiDTO;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai.BonsaiEntity;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai.BonsaiRepository;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.watering.WateringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<Bonsai> findAll() {

        return bonsaiRepository.findAll();
    }


    public Optional<Bonsai> findById(@PathVariable("uuid") UUID uuid) {
        return bonsaiRepository.findById(uuid);
    }


    public Bonsai create(@RequestBody Bonsai bonsai){

       return bonsaiRepository.create(bonsai);

    }


    public void delete(UUID uuid){

        bonsaiRepository.delete(uuid);
    }

    public Optional<Bonsai> update(UUID id, Bonsai bonsai) {

        Optional<Bonsai> bonsaiUpdate = bonsaiRepository.findById(id);

        if (bonsaiUpdate.isPresent()) {
            bonsaiUpdate.get().setName(bonsai.getName());
            bonsaiUpdate.get().setSpecies(bonsai.getSpecies());
            bonsaiUpdate.get().setAcquisitionDate(bonsai.getAcquisitionDate());
            bonsaiUpdate.get().setAcquisitionAge(bonsai.getAcquisitionAge());
            return Optional.of(bonsaiRepository.update(bonsaiUpdate.get()));
        }
        return bonsaiUpdate;
    }

    public Optional<Bonsai> statusUpdate(UUID id, Bonsai bonsai){

        Optional<Bonsai> bonsaiUpdate = bonsaiRepository.findById(id);

        if(bonsaiUpdate.isPresent()){
            do{
                bonsaiUpdate.get().setStatus(bonsai.getStatus());
            }while( (bonsai.getStatus() != "dead") || (bonsai.getStatus() != "alive") || (bonsai.getStatus() != "unknown") );

            return  Optional.of(bonsaiRepository.update(bonsaiUpdate.get()));
        }

        return bonsaiUpdate;
    }

    public List<Watering> findWateringById(@PathVariable("uuid") UUID uuid) {

            Optional<Bonsai> bonsai = bonsaiRepository.findById(uuid);

                if(bonsai.isPresent()){

                    return bonsai.get().getListeWatering().stream()
                            .map(WateringMapper::entityToWatering)
                            .collect(Collectors.toList());
                }else {
                    return
                }
    }

    /*public Optional<Repotting> findRepottingById(@PathVariable("uuid") UUID uuid) {
        return bonsaiRepository.findRepottingById(uuid);
    }

    public Optional<Pruning> findPruningById(@PathVariable("uuid") UUID uuid){
        return bonsaiRepository.findPruningById(uuid);
    }*/
}
