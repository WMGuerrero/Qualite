package ca.qc.grasset.ag420pb4.tp02.business;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreProfesseur;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;

public class MediateurObtenirProfesseur {

    private RegistreProfesseur registreProfesseur;

    public MediateurObtenirProfesseur(final RegistreProfesseur registreProfesseur_) {
        this.registreProfesseur = registreProfesseur_;
    }

    public final Professeur executer(final Professeur professeur_) {

       return registreProfesseur.obtenir(professeur_);
    }

}
