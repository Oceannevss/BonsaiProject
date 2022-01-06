package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.DAO;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.entity.BonsaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {


}
