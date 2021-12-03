package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.PruningMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.RepottingMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.WateringMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.BonsaiService;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.pruning.Pruning;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.repotting.Repotting;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.watering.Watering;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai.BonsaiEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
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

    @PatchMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> update(@PathVariable UUID uuid, @RequestBody BonsaiDTO bonsaiDTO) {

        return bonsaiService.update(uuid, BonsaiMapper.DtoToBonsai(bonsaiDTO))
                            .map(bonsai -> ResponseEntity.ok(BonsaiMapper.bonsaiToDto(bonsai)))
                            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{uuid}/status")
    public  ResponseEntity<BonsaiDTO> statusUpdate(@PathVariable UUID uuid, @RequestBody  BonsaiDTO bonsaiDTO){

        return bonsaiService.update(uuid, BonsaiMapper.DtoToBonsai(bonsaiDTO))
                            .map(bonsai -> ResponseEntity.ok(BonsaiMapper.bonsaiToDto(bonsai)))
                            .orElse(ResponseEntity.notFound().build());
    }

   /* @GetMapping("/{uuid}/watering")
    public ResponseEntity<WateringDTO> findWateringById(@PathVariable("uuid") UUID uuid){

        Optional<Watering> watering = bonsaiService.findWateringById(uuid);

        return watering.map(watering1 -> WateringMapper.wateringToDto(watering1))
                        .map(wateringDTO -> ResponseEntity.ok(wateringDTO))
                        .orElse(ResponseEntity.notFound().build());
    }*/

    @GetMapping("/{uuid}/watering")
    public List<Watering> findWateringById(@PathVariable("uuid") UUID uuid) {
        return bonsaiService.findWateringById(uuid)
                .stream()
                .collect(Collectors.toList());
    }

   /* @GetMapping("/{uuid}/watering")
    public ResponseEntity<BonsaiDTO> findWateringById(@PathVariable("uuid") UUID uuid) {

        Optional<Bonsai> bonsai = bonsaiService.findById(uuid);
        return bonsai.map(bonsai1 -> BonsaiMapper.bonsaiToDto(bonsai1))
                .map(bonsaiDTO -> ResponseEntity.ok(bonsaiDTO))
                .orElse(ResponseEntity.notFound().build());


    }

    @GetMapping("{uuid}/repotting")
    public ResponseEntity<RepottingDTO> findRepottingById(@PathVariable UUID uuid){
         Optional<Repotting> repotting = bonsaiService.findRepottingById(uuid);

         return repotting.map(repotting1 -> RepottingMapper.repottingToDto(repotting1))
                         .map(repottingDTO -> ResponseEntity.ok(repottingDTO))
                         .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("{uuid}/pruning")
    public ResponseEntity<PruningDTO> findPruningById(@PathVariable("uuid") UUID uuid){
        Optional<Pruning> pruning = bonsaiService.findPruningById(uuid);

        return pruning.map(pruning1 -> PruningMapper.pruningToDto(pruning1))
                        .map(pruningDTO -> ResponseEntity.ok(pruningDTO))
                        .orElse(ResponseEntity.notFound().build());
    }*/

}
