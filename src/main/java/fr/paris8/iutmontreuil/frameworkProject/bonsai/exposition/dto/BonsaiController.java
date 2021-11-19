package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.BonsaiService;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.BonsaiDao;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.BonsaiEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<BonsaiDTO> FindById(@PathVariable("uuid") UUID uuid) {

            Optional<Bonsai> bonsai = bonsaiService.FindById(uuid);
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

    @PatchMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> update(@PathVariable("uuid") UUID uuid, @RequestBody BonsaiDTO bonsaiDTO){



        return ResponseEntity.ok(bonsaiDTO);
    }


   /*@DeleteMapping("/{uuid}")
    public BonsaiEntity deletePost(@RequestBody BonsaiEntity bonsai){

        return bonsaiDao.delete(bonsai);
   }*/

}
