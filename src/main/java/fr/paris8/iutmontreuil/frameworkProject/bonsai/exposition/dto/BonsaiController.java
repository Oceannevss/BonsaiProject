package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.PruningMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.RepottingMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.WateringMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.BonsaiService;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Pruning;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Repotting;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Watering;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @GetMapping()
    public List<BonsaiDTO> findAll() {
        return bonsaiService.findAll()
                            .stream()
                            .map(BonsaiMapper::bonsaiToDto)
                            .collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID uuid) {

            Optional<Bonsai> bonsai = bonsaiService.findById(uuid);

          return bonsai.map(bonsai1 -> {
              BonsaiDTO bonsaiDTO = BonsaiMapper.bonsaiToDto(bonsai1);
              bonsaiDTO.setLastWatering(bonsaiService.getLastWatering(bonsai1.getId()).map(Watering::getWateringDate).get());
              bonsaiDTO.setLastRepotting(bonsaiService.getLastRepotting(bonsai1.getId()).map(Repotting::getRepottingDate).get());
              bonsaiDTO.setLastPruning(bonsaiService.getLastPruning(bonsai1.getId()).map(Pruning::getPruningDate).get());
            return ResponseEntity.ok(bonsaiDTO);
          })
                    .orElse(ResponseEntity.notFound().build());

    }

   @PostMapping
    public ResponseEntity<BonsaiDTO> create(@RequestBody BonsaiDTO bonsaiDTO){

        Bonsai bonsai = bonsaiService.create(BonsaiMapper.DtoToBonsai(bonsaiDTO));
        bonsaiDTO = BonsaiMapper.bonsaiToDto(bonsai) ;
        return ResponseEntity.ok(bonsaiDTO);


   }

  /* @PostMapping
   public ResponseEntity<BonsaiDTO> createTest(@RequestBody String name, String species, String acquisition_date, String acquisition_age, String owner_id){
        Bonsai bonsai = bonsaiService.createTest(name, species, acquisition_date, acquisition_age, owner_id);
        BonsaiDTO bonsaiDTO = BonsaiMapper.bonsaiToDto(bonsai);
        return ResponseEntity.ok(bonsaiDTO);
   }*/

   @DeleteMapping("/{uuid}")
   @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteById(@PathVariable UUID uuid){

         bonsaiService.deleteById(uuid);
   }

    @PatchMapping("/{uuid}")
    @PreAuthorize("hasAuthority('STAFF')")
    public ResponseEntity<BonsaiDTO> update(@PathVariable UUID uuid, @RequestBody BonsaiDTO bonsaiDTO) {

        return bonsaiService.update(uuid, BonsaiMapper.DtoToBonsai(bonsaiDTO))
                            .map(bonsai -> ResponseEntity.ok(BonsaiMapper.bonsaiToDto(bonsai)))
                            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{uuid}/status")
    @PreAuthorize("hasAuthority('STAFF')")
    public ResponseEntity<BonsaiDTO> statusUpdate(@PathVariable UUID uuid, @RequestBody String status){

        return bonsaiService.statusUpdate(uuid, status)
                            .map(bonsai -> ResponseEntity.ok(BonsaiMapper.bonsaiToDto(bonsai)))
                            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{uuid}/watering")
    public List<WateringDTO> findWateringById(@PathVariable("uuid") UUID uuid) {
        return bonsaiService.findWateringById(uuid)
                .stream()
                .map(WateringMapper::wateringToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/watering")
    public List<WateringDTO> getWaterings(){
        return bonsaiService.getWaterings()
                .stream()
                .map(WateringMapper::wateringToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{uuid}/repotting")
    public List<RepottingDTO> findRepottingById(@PathVariable UUID uuid){
         return bonsaiService.findRepottingById(uuid)
                .stream()
                .map(RepottingMapper::repottingToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{uuid}/pruning")
    public List<PruningDTO> findPruningById(@PathVariable("uuid") UUID uuid){
      return bonsaiService.findPruningById(uuid)
              .stream()
              .map(PruningMapper::pruningToDto)
              .collect(Collectors.toList());
    }

}
