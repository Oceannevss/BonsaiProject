package fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserDao extends JpaRepository<UserEntity, UUID> {

    UserEntity findByUsername(String s);

    @Query(value = "select authority from AUTHORITY where id =:id ", nativeQuery = true)
    List<String> findAuthorityByUserId(UUID id);

}
