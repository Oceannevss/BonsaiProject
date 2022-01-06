package fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto.BonsaiDTO;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.entity.BonsaiEntity;

public class BonsaiMapper {

    public static Bonsai DtoToBonsai (BonsaiDTO bonsaiDTO){
        Bonsai bonsaiConvert = new Bonsai();
        bonsaiConvert.setId(bonsaiDTO.getId());
        bonsaiConvert.setName(bonsaiDTO.getName());
        bonsaiConvert.setSpecies(bonsaiDTO.getSpecies());
        bonsaiConvert.setAcquisitionDate(bonsaiDTO.getAcquisitionDate());
        bonsaiConvert.setAcquisitionAge(bonsaiDTO.getAcquisitionAge());
        bonsaiConvert.setStatus(bonsaiDTO.getStatus());

        return bonsaiConvert;
    }

    public static Bonsai EntityToBonsai (BonsaiEntity bonsaiEntity){
        Bonsai bonsaiConvert = new Bonsai();
        bonsaiConvert.setId(bonsaiEntity.getId());
        bonsaiConvert.setName(bonsaiEntity.getName());
        bonsaiConvert.setSpecies(bonsaiEntity.getSpecies());
        bonsaiConvert.setAcquisitionDate(bonsaiEntity.getAcquisitionDate());
        bonsaiConvert.setAcquisitionAge(bonsaiEntity.getAcquisitionAge());
        bonsaiConvert.setStatus(bonsaiEntity.getStatus());

        return bonsaiConvert;
    }

    public static BonsaiDTO bonsaiToDto (Bonsai bonsai){
        BonsaiDTO bonsaiConvert = new BonsaiDTO();
        bonsaiConvert.setId(bonsai.getId());
        bonsaiConvert.setName(bonsai.getName());
        bonsaiConvert.setSpecies(bonsai.getSpecies());
        bonsaiConvert.setAcquisitionDate(bonsai.getAcquisitionDate());
        bonsaiConvert.setAcquisitionAge(bonsai.getAcquisitionAge());
        bonsaiConvert.setStatus(bonsai.getStatus());


        return bonsaiConvert;
    }

    public static BonsaiEntity dtoToEntity (BonsaiDTO bonsaiDto){
        BonsaiEntity bonsaiConvert = new BonsaiEntity();
        bonsaiConvert.setId(bonsaiDto.getId());
        bonsaiConvert.setName(bonsaiDto.getName());
        bonsaiConvert.setSpecies(bonsaiDto.getSpecies());
        bonsaiConvert.setAcquisitionDate(bonsaiDto.getAcquisitionDate());
        bonsaiConvert.setAcquisitionAge(bonsaiDto.getAcquisitionAge());
        bonsaiConvert.setStatus(bonsaiDto.getStatus());

        return bonsaiConvert;
    }

    public static BonsaiEntity BonsaiToEntity (Bonsai bonsai){
        BonsaiEntity bonsaiConvert = new BonsaiEntity();
        bonsaiConvert.setId(bonsai.getId());
        bonsaiConvert.setName(bonsai.getName());
        bonsaiConvert.setSpecies(bonsai.getSpecies());
        bonsaiConvert.setAcquisitionDate(bonsai.getAcquisitionDate());
        bonsaiConvert.setAcquisitionAge(bonsai.getAcquisitionAge());
        bonsaiConvert.setStatus(bonsai.getStatus());

        return bonsaiConvert;
    }
}
