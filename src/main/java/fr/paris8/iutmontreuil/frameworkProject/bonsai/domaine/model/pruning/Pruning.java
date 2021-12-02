package fr.paris8.iutmontreuil.frameworkProject.bonsai.domaine.model.pruning;

import java.util.Date;
import java.util.UUID;

public class Pruning {

        private UUID id;
        private Date pruningDate;


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



}
