package fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.PruningMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.RepottingMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper.WateringMapper;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.BonsaiService;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Bonsai;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Repotting;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.Watering;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<WateringDTO> findWateringById(@PathVariable("uuid") UUID uuid) {
        return bonsaiService.findWateringById(uuid)
                .stream()
                .map(WateringMapper::wateringToDto)
                .collect(Collectors.toList());
    }

   /* @GetMapping("/{uuid}/watering")
    public ResponseEntity<BonsaiDTO> findWateringById(@PathVariable("uuid") UUID uuid) {

        Optional<Bonsai> bonsai = bonsaiService.findById(uuid);
        return bonsai.map(bonsai1 -> BonsaiMapper.bonsaiToDto(bonsai1))
                .map(bonsaiDTO -> ResponseEntity.ok(bonsaiDTO))
                .orElse(ResponseEntity.notFound().build());


    }*/

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

    /*@GetMapping("/{id}/watering")
    public List<WateringDto> getWaterings(@PathVariable UUID id) {
        return bonsaiService.getWaterings(id).stream().map(BonsaiMapper::toWateringDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}/repotting")
    public List<RepottingDto> getRepottings(@PathVariable UUID id) {
        return bonsaiService.getRepottings(id).stream().map(BonsaiMapper::toRepottingDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}/pruning")
    public List<PruningDto> getPrunings(@PathVariable UUID id) {
        return bonsaiService.getPrunings(id).stream().map(BonsaiMapper::toPruningDto).collect(Collectors.toList());
    }*/

}
