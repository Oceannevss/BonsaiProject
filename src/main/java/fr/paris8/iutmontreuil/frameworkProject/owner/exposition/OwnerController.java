package fr.paris8.iutmontreuil.frameworkProject.owner.exposition;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto.BonsaiDTO;
import fr.paris8.iutmontreuil.frameworkProject.owner.Mapper.OwnerMapper;
import fr.paris8.iutmontreuil.frameworkProject.owner.domaine.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerDTO> findAll() {
        return ownerService.findAll().stream().map(OwnerMapper::ownerToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable UUID id) {
        return ownerService.findById(id).map(o -> ResponseEntity.ok(OwnerMapper.ownerToDto(o))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> create(@RequestBody OwnerDTO ownerDto) {
        return new ResponseEntity<>(OwnerMapper.ownerToDto(ownerService.create(OwnerMapper.dtoToOwner(ownerDto))), HttpStatus.CREATED);
    }

    /*@GetMapping("/{id}/bonsais")
    public List<BonsaiDTO> getBonsais(@PathVariable UUID id) {
        return ownerService.getBonsais(id).stream().map(BonsaiMapper::DtoToBonsai).collect(Collectors.toList());
    }

    @PostMapping("/{owner_id}/bonsais/{bonsai_id}/transfer")
    public ResponseEntity<BonsaiDTO> transferBonsai(@PathVariable UUID owner_id, @PathVariable UUID bonsai_id, @RequestBody Owner new_owner) {


    }

    @PostMapping("/{owner_id}/bonsais")
    public List<BonsaiDto> addBonsai(@PathVariable UUID owner_id, @RequestBody List<Bonsai> bonsais) {

        return ownerService.addBonsai(owner_id, bonsais).stream().map(OwnerMapper::toBonsaiDto).collect(Collectors.toList());
    }*/
}
