package fr.paris8.iutmontreuil.frameworkProject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaiController {

    private final BonsaiDao bonsaiDao ;

    public BonsaiController(BonsaiDao bonsaiDao) {
        this.bonsaiDao = bonsaiDao;
    }


    //@RequestMapping(method = RequestMethod.GET, path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
   /* @GetMapping
    public String helloWorld(){
        return "hello World ";
    }*/

    @GetMapping
    public List<BonsaiEntity> helloWorld() {
        return bonsaiDao.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> FindById(@PathVariable("uuid") UUID uuid) {
        return bonsaiDao.findById(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   @PostMapping
    public BonsaiEntity create(@RequestBody BonsaiEntity bonsai){
        return bonsaiDao.save(bonsai);
   }

   @DeleteMapping("/{uuid}")
    public BonsaiEntity delete(@RequestBody BonsaiEntity bonsai){
        return bonsaiDao.delete(bonsai);
   }
}
