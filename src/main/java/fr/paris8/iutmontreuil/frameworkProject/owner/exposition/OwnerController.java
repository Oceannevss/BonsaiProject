package fr.paris8.iutmontreuil.frameworkProject.owner.exposition;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto.BonsaiDTO;
import fr.paris8.iutmontreuil.frameworkProject.owner.Mapper.OwnerMapper;
import fr.paris8.iutmontreuil.frameworkProject.owner.domaine.Owner;
import fr.paris8.iutmontreuil.frameworkProject.owner.domaine.OwnerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerDTO> findAll() {

        return ownerService.findAll().stream().map(OwnerMapper::ownerToDto).collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable UUID uuid) {

        return ownerService.findById(uuid)
                            .map(owner -> ResponseEntity.ok(OwnerMapper.ownerToDto(owner)))
                            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> create(@RequestBody OwnerDTO ownerDto) {

        Owner owner = ownerService.create(OwnerMapper.dtoToOwner(ownerDto));
        ownerDto = OwnerMapper.ownerToDto(owner) ;
        return ResponseEntity.ok(ownerDto);

    }

    @GetMapping("/{uuid}/bonsais")
    public List<BonsaiDTO> getBonsais(@PathVariable UUID id) {

        return ownerService.getBonsais(id)
                            .stream()
                            .map(BonsaiMapper::bonsaiToDto)
                            .collect(Collectors.toList());

    }

    @PostMapping("/{owner_id}/bonsais/{bonsai_id}/transfer")
    public ResponseEntity<BonsaiDTO> transferBonsaiToOwner(@PathVariable UUID owner_id, @PathVariable UUID bonsai_id, @RequestBody Owner new_owner) {

        return ownerService.transferBonsaiToOwner(owner_id,bonsai_id,new_owner)
                            .map(bonsai -> ResponseEntity.ok(BonsaiMapper.bonsaiToDto(bonsai)))
                            .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping("/{owner_id}/bonsais")
    public List<BonsaiDTO> addBonsaiToOwner(@PathVariable UUID owner_id, @RequestBody List<Bonsai> bonsais) {

        return ownerService.addBonsaiToOwner(owner_id,bonsais)
                            .stream()
                            .map(BonsaiMapper::bonsaiToDto)
                            .collect(Collectors.toList());
    }
}
