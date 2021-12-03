package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.watering;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface WateringDao extends JpaRepository<WateringEntity, UUID> {

}
