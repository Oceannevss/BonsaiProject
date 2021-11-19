package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public Optional<Bonsai> FindById(@PathVariable("uuid") UUID uuid) {

        Optional<BonsaiEntity> res = bonsaiDao.findById(uuid);

            return res.map(bonsaiEntity -> BonsaiMapper.EntityToBonsai(bonsaiEntity));


    }

    @PostMapping
    public Bonsai create(@RequestBody BonsaiEntity bonsai){

        BonsaiEntity save = bonsaiDao.save(bonsai);
        return BonsaiMapper.EntityToBonsai(save);

    }
}
