package fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Repotting;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto.RepottingDTO;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.repotting.RepottingEntity;

public class RepottingMapper {

    public static Repotting entityToRepotting (RepottingEntity repottingEntity){
        Repotting repottingConvert = new Repotting();
        repottingConvert.setId(repottingEntity.getId());
        repottingConvert.setRepottingDate(repottingEntity.getRepottingDate());
        return repottingConvert;
    }

    public static RepottingDTO repottingToDto (Repotting repotting){
        RepottingDTO repottingConvert = new RepottingDTO();
        repottingConvert.setId(repotting.getId());
        repottingConvert.setRepottingDate(repotting.getRepottingDate());

        return repottingConvert;
    }

}
