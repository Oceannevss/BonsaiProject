package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.PruningMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.RepottingMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.WateringMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Pruning;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Repotting;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Watering;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.DAO.BonsaiDao;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.entity.BonsaiEntity;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.DAO.PruningDao;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.DAO.RepottingDao;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.DAO.WateringDao;
import org.springframework.stereotype.Component;

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

    public Optional<Bonsai> findById(UUID uuid) {

        Optional<BonsaiEntity> res = bonsaiDao.findById(uuid);

            return res.map(bonsaiEntity -> BonsaiMapper.EntityToBonsai(bonsaiEntity));


    }

    public Bonsai create(Bonsai bonsai){

        BonsaiEntity bonsaiEntity = BonsaiMapper.BonsaiToEntity(bonsai);
        BonsaiEntity save = bonsaiDao.save(bonsaiEntity);

        return BonsaiMapper.EntityToBonsai(save);

    }

    public void deleteById(UUID uuid){

        bonsaiDao.deleteById(uuid);
    }

    public Bonsai update (Bonsai bonsai){

        return BonsaiMapper.EntityToBonsai(bonsaiDao.save(BonsaiMapper.BonsaiToEntity(bonsai)));
    }

    public Bonsai statusUpdate (Bonsai bonsai){

        return BonsaiMapper.EntityToBonsai(bonsaiDao.save(BonsaiMapper.BonsaiToEntity(bonsai)));
    }


    public List<Watering> findWateringById(UUID uuid) {

        Optional<BonsaiEntity> bonsaiEntity = bonsaiDao.findById(uuid);

       return wateringDao.findAll().stream()
                .map(WateringMapper::entityToWatering)
                .collect(Collectors.toList());

       /* return wateringDao.findAllById(bonsaiEntity.get().getId().)
                .stream()
                .map(WateringMapper::entityToWatering)
                .collect(Collectors.toList());*/

    }

    public List<Watering> getWaterings(){
        return wateringDao.findAll().stream()
                .map(WateringMapper::entityToWatering)
                .collect(Collectors.toList());
    }

    public List<Repotting> findRepottingById(UUID id) {
        return repottingDao.findAll().stream()
                .map(RepottingMapper::entityToRepotting)
                .collect(Collectors.toList());
    }

    public List<Pruning> findPruningById(UUID id) {
        return pruningDao.findAll().stream()
                .map(PruningMapper::entityToPruning)
                .collect(Collectors.toList());
    }

}
