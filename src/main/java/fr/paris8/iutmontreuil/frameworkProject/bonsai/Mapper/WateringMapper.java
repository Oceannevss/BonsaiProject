package fr.paris8.iutmontreuil.frameworkProject.bonsai.Mapper;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.watering.Watering;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.exposition.dto.WateringDTO;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.watering.WateringEntity;

public class WateringMapper {

    public static Watering entityToWatering (WateringEntity wateringEntity){
        Watering wateringConvert = new Watering();
        wateringConvert.setId(wateringEntity.getId());
        wateringConvert.setWatering_date(wateringEntity.getWatering_date());
        return wateringConvert;
    }

    public static WateringDTO wateringToDto (Watering watering){
        WateringDTO wateringConvert = new WateringDTO();
        wateringConvert.setId(watering.getId());
        wateringConvert.setWateringDate(watering.getWateringDate());

        return wateringConvert;
    }
}
