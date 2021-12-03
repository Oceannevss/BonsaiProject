package fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.pruning.Pruning;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto.PruningDTO;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.pruning.PruningEntity;

public class PruningMapper {

    public static Pruning entityToPruning (PruningEntity pruningEntity){
        Pruning pruningConvert = new Pruning();
        pruningConvert.setId(pruningEntity.getId());
        pruningConvert.setPruningDate(pruningEntity.getPruningDate());
        return pruningConvert;
    }

    public static PruningDTO pruningToDto (Pruning pruning){
        PruningDTO pruningConvert = new PruningDTO();
        pruningConvert.setId(pruning.getId());
        pruningConvert.setPruningDate(pruning.getPruningDate());

        return pruningConvert;
    }
}
