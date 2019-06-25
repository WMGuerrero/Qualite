package ca.qc.grasset.ag420pb4.tp02.business;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreProfesseur;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;

public class MediateurCreationProfesseur {

    private RegistreProfesseur registreProfesseur;

    public MediateurCreationProfesseur(final RegistreProfesseur registreProfesseur_) {
       this.registreProfesseur = registreProfesseur_;
    }

    public final Professeur executer(final Professeur professeur_) {

       return registreProfesseur.creer(professeur_);
    }

}
