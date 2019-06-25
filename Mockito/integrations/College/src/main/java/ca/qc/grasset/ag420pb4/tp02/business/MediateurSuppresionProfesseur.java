package ca.qc.grasset.ag420pb4.tp02.business;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreProfesseur;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionProfesseurIntrouvable;

public class MediateurSuppresionProfesseur {

 private RegistreProfesseur registreProfesseur;

 public MediateurSuppresionProfesseur(final RegistreProfesseur registreProfesseur_) {
      this.registreProfesseur = registreProfesseur_;
 }

 final void executer(final Professeur professeur_) throws ExceptionProfesseurIntrouvable {

     Professeur professeur = registreProfesseur.obtenir(professeur_);

     if (professeur.getPrenom().isEmpty() && professeur.getNom().isEmpty()) {
            throw new ExceptionProfesseurIntrouvable();
     }

     registreProfesseur.supprimer(professeur_);
 }

}
