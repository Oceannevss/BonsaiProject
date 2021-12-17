package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Pruning;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Repotting;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Watering;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai.BonsaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
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

    public List<Bonsai> findAll() {

        return bonsaiRepository.findAll();
    }


    public Optional<Bonsai> findById(UUID uuid) {
        return bonsaiRepository.findById(uuid);
    }


    public Bonsai create(Bonsai bonsai){

       return bonsaiRepository.create(bonsai);

    }

   /* public Bonsai createTest(String name, String species, String acquisition_date, String acquisition_age, String owner_id){

        Bonsai bonsai = new Bonsai();
        bonsai.setName(name);
        bonsai.setSpecies(species);
        LocalDate localDate = LocalDate.parse(acquisition_date);
        bonsai.setAcquisitionDate(localDate);
        bonsai.setAcquisitionAge(Integer.parseInt(acquisition_age));
        bonsai.setOwnerId(null);
        return bonsaiRepository.create(bonsai);
    }*/


    public void deleteById(UUID uuid){

        bonsaiRepository.deleteById(uuid);
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

    public Optional<Bonsai> statusUpdate(UUID id, String status){

        Optional<Bonsai> bonsaiUpdate = bonsaiRepository.findById(id);

        if(bonsaiUpdate.isPresent()){

            if(status.equals("dead") || status.equals("alive") || status.equals("unknown")){

                bonsaiUpdate.get().setStatus(status);

                return  Optional.of(bonsaiRepository.statusUpdate(bonsaiUpdate.get()));
            }
        }

        return bonsaiUpdate;
    }

    public List<Watering> findWateringById(UUID uuid) {
        return bonsaiRepository.findWateringById(uuid);
    }

    public List<Watering> getWaterings(){
        return bonsaiRepository.getWaterings();
    }

    public Optional<Watering> getLastWatering(UUID uuid) {

        Optional<Bonsai> bonsai = bonsaiRepository.findById(uuid);

        if (bonsai.isPresent()) {
            return Optional.of(bonsaiRepository.findWateringById(bonsai.map(Bonsai::getId).get()).get(0));
        }
        return Optional.empty();
    }

    public List<Repotting> findRepottingById(UUID uuid) {
        return bonsaiRepository.findRepottingById(uuid);
    }

    public Optional<Repotting> getLastRepotting(UUID uuid) {

        Optional<Bonsai> bonsai = bonsaiRepository.findById(uuid);

        if (bonsai.isPresent()) {
            return Optional.of(bonsaiRepository.findRepottingById(uuid).get(0));
        }
        return Optional.empty();
    }

    public List<Pruning> findPruningById(UUID uuid){
        return bonsaiRepository.findPruningById(uuid);
    }

    public Optional<Pruning> getLastPruning(UUID uuid) {

        Optional<Bonsai> bonsai = bonsaiRepository.findById(uuid);

        if (bonsai.isPresent()) {
            return Optional.of(bonsaiRepository.findPruningById(uuid).get(0));
        }
        return Optional.empty();
    }
}
