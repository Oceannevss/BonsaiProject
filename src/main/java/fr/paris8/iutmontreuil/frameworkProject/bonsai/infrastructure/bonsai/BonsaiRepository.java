package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai.Bonsai;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Component
public class BonsaiRepository {

    private final BonsaiDao bonsaiDao ;



    public BonsaiRepository(BonsaiDao bonsaiDao) {
        this.bonsaiDao = bonsaiDao;
    }


   /* @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiEntity> FindById(@PathVariable("uuid") UUID uuid) {
        return bonsaiDao.findById(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/

    @GetMapping("/{uuid}")
    public Optional<Bonsai> findById(@PathVariable("uuid") UUID uuid) {

        Optional<BonsaiEntity> res = bonsaiDao.findById(uuid);

            return res.map(bonsaiEntity -> BonsaiMapper.EntityToBonsai(bonsaiEntity));


    }

    @PostMapping
    public Bonsai create(@RequestBody BonsaiEntity bonsai){

        BonsaiEntity save = bonsaiDao.save(bonsai);
        return BonsaiMapper.EntityToBonsai(save);

    }

    @DeleteMapping
    public void delete(UUID uuid){

        bonsaiDao.deleteById(uuid);
    }

    @PatchMapping
    public Bonsai update (Bonsai bonsai){

        return BonsaiMapper.EntityToBonsai(bonsaiDao.save(BonsaiMapper.BonsaiToEntity(bonsai)));
    }
}
