package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.PruningMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.RepottingMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.WateringMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.pruning.Pruning;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.repotting.Repotting;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.watering.Watering;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.pruning.PruningDao;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.pruning.PruningEntity;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.repotting.RepottingDao;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.repotting.RepottingEntity;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.watering.WateringDao;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.watering.WateringEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BonsaiRepository {

    private final BonsaiDao bonsaiDao ;
    private final WateringDao wateringDao;
    private final RepottingDao repottingDao;
    private final PruningDao pruningDao;



    public BonsaiRepository(BonsaiDao bonsaiDao, WateringDao wateringDao, RepottingDao repottingDao, PruningDao pruningDao) {
        this.bonsaiDao = bonsaiDao;
        this.wateringDao = wateringDao;
        this.repottingDao = repottingDao;
        this.pruningDao = pruningDao;
    }

    public List<Bonsai> findAll() {

        return bonsaiDao.findAll()
                        .stream()
                        .map(BonsaiMapper::EntityToBonsai)
                        .collect(Collectors.toList());
    }

    public Optional<Bonsai> findById(@PathVariable("uuid") UUID uuid) {

        Optional<BonsaiEntity> res = bonsaiDao.findById(uuid);

            return res.map(bonsaiEntity -> BonsaiMapper.EntityToBonsai(bonsaiEntity));


    }

    public Bonsai create(@RequestBody Bonsai bonsai){

        BonsaiEntity bonsaiEntity = BonsaiMapper.BonsaiToEntity(bonsai);
        BonsaiEntity save = bonsaiDao.save(bonsaiEntity);

        return BonsaiMapper.EntityToBonsai(save);

    }

    public void delete(UUID uuid){

        bonsaiDao.deleteById(uuid);
    }

    public Bonsai update (Bonsai bonsai){

        return BonsaiMapper.EntityToBonsai(bonsaiDao.save(BonsaiMapper.BonsaiToEntity(bonsai)));
    }

    public  Bonsai statusUpdate (Bonsai bonsai){

        return BonsaiMapper.EntityToBonsai(bonsaiDao.save(BonsaiMapper.BonsaiToEntity(bonsai)));
    }

}
