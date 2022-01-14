package fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



@Table(name = "authority")
@Entity
public class AuthorityEntity {

    @EmbeddedId
    private AuthorityId authorityId;

    public AuthorityEntity() {
    }

    public AuthorityEntity(AuthorityId authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthority() {
        return authorityId.getAuthority();
    }

    public AuthorityId getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(AuthorityId authorityId) {
        this.authorityId = authorityId;
    }
}

