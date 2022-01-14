package fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDao extends JpaRepository<UserEntity, UUID> {
}
