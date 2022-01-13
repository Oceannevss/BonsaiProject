package fr.paris8.iutmontreuil.frameworkProject.owner.infrastructure;

import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface OwnerDao extends JpaRepository<OwnerEntity, UUID> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update bonsai set owner_id = :owner_id WHERE id = :bonsai_id")
    public void addNewOwner(@Param("owner_id") UUID owner_id, @Param("bonsai_id") UUID bonsai_id);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update bonsai set owner_id = :owner_id WHERE id = :bonsai_id")
    public void addNewBonsai(@Param("owner_id") UUID owner_id, @Param("bonsai_id") UUID bonsai_id);


}
