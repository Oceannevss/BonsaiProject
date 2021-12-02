package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.BonsaiService;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai.Bonsai;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaiController {

    private final BonsaiService bonsaiService;

    public BonsaiController(BonsaiService bonsaiService) {
        this.bonsaiService = bonsaiService;
    }


    //@RequestMapping(method = RequestMethod.GET, path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
   /* @GetMapping
    public String helloWorld(){
        return "hello World ";
    }*/

  /*  @GetMapping
    public List<BonsaiEntity> helloWorld() {
        return bonsaiDao.findAll();
    }*/

    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID uuid) {

            Optional<Bonsai> bonsai = bonsaiService.findById(uuid);
          return bonsai.map(bonsai1 -> BonsaiMapper.bonsaiToDto(bonsai1))
                    .map(bonsaiDTO -> ResponseEntity.ok(bonsaiDTO))
                    .orElse(ResponseEntity.notFound().build());


    }

   @PostMapping
    public ResponseEntity<BonsaiDTO> create(@RequestBody BonsaiDTO bonsaiDTO){

        Bonsai bonsai = bonsaiService.create(BonsaiMapper.DtoToBonsai(bonsaiDTO));
        bonsaiDTO = BonsaiMapper.bonsaiToDto(bonsai) ;
        return ResponseEntity.ok(bonsaiDTO);


   }

   @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid){

         bonsaiService.delete(uuid);
   }

    @PatchMapping("/{id}")
    public ResponseEntity<BonsaiDTO> update(@PathVariable UUID id, @RequestBody BonsaiDTO updatedBonsai) {
        return bonsaiService.update(id, BonsaiMapper.DtoToBonsai(updatedBonsai))
                            .map(bonsai -> ResponseEntity.ok(BonsaiMapper.bonsaiToDto(bonsai)))
                            .orElse(ResponseEntity.notFound().build());
    }

}
