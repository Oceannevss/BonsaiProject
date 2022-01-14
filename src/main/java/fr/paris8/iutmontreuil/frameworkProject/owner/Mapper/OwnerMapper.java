package fr.paris8.iutmontreuil.frameworkProject.owner.Mapper;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.owner.domaine.Owner;
import fr.paris8.iutmontreuil.frameworkProject.owner.exposition.BonsaiDto;
import fr.paris8.iutmontreuil.frameworkProject.owner.exposition.OwnerDTO;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.entity.OwnerEntity;

import java.util.stream.Collectors;

public class OwnerMapper {


    public static Owner dtoToOwner(OwnerDTO ownerDto) {
        Owner owner = new Owner();
        owner.setId(ownerDto.getId());
        owner.setName(ownerDto.getName());
        owner.setBonsais(ownerDto.getBonsais().stream().map(BonsaiMapper::DtoToBonsai).collect(Collectors.toList()));
        return owner;
    }

    public static Owner entityToOwner(OwnerEntity ownerEntity) {
        Owner owner = new Owner();
        owner.setId(ownerEntity.getId());
        owner.setName(ownerEntity.getName());
        owner.setBonsais(ownerEntity.getListBonsais().stream().map(BonsaiMapper::EntityToBonsai).collect(Collectors.toList()));
        return owner;
    }

    public static OwnerDTO ownerToDto(Owner owner) {
        OwnerDTO ownerDto = new OwnerDTO();
        ownerDto.setId(owner.getId());
        ownerDto.setName(owner.getName());
        ownerDto.setBonsais(owner.getBonsais().stream().map(BonsaiMapper::bonsaiToDto).collect(Collectors.toList()));
        return ownerDto;
    }

    public static OwnerEntity ownerToEntity(Owner owner) {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(owner.getId());
        ownerEntity.setName(owner.getName());
        ownerEntity.setListBonsais(owner.getBonsais().stream().map(BonsaiMapper::BonsaiToEntity).collect(Collectors.toList()));
        return ownerEntity;
    }

    public static BonsaiDto bonsaiToDtoOwner(Bonsai bonsai) {
        BonsaiDto bonsaiDto = new BonsaiDto();
        bonsaiDto.setId(bonsai.getId());
        bonsaiDto.setName(bonsai.getName());
        bonsaiDto.setSpecies(bonsai.getSpecies());
        bonsaiDto.setAcquisitionAge(bonsai.getAcquisitionAge());
        return bonsaiDto;
    }

    public static Bonsai dtoToBonsaiOwner(BonsaiDto bonsaiDto) {
        Bonsai bonsai = new Bonsai();
        bonsai.setId(bonsaiDto.getId());
        bonsai.setName(bonsaiDto.getName());
        bonsai.setSpecies(bonsaiDto.getSpecies());
        bonsai.setAcquisitionAge(bonsaiDto.getAcquisitionAge());
        return bonsai;
    }

}
