package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model;

import java.util.Date;
import java.util.UUID;

public class Pruning {

        private UUID id;
        private Date pruningDate;
        private UUID bonsai_id;

        public Pruning() {
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID uuid) {
            this.id = id;
        }

        public Date getPruningDate() {
            return pruningDate;
        }

        public void setPruningDate(Date pruningDate) {
            this.pruningDate = pruningDate;
        }

    public UUID getBonsai_id() {
        return bonsai_id;
    }

    public void setBonsai_id(UUID bonsai_id) {
        this.bonsai_id = bonsai_id;
    }
}
