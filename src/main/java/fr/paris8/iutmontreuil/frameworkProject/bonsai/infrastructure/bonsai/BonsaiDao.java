package fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.bonsai;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {


}
