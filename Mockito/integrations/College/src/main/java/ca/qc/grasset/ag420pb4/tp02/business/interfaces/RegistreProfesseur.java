package ca.qc.grasset.ag420pb4.tp02.business.interfaces;

import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;

public interface RegistreProfesseur {

 Professeur creer(Professeur professeur_);
 Professeur modifier(Professeur professeur_);
 Professeur obtenir(Professeur professeur_);
 void supprimer(Professeur professeur_);

}
