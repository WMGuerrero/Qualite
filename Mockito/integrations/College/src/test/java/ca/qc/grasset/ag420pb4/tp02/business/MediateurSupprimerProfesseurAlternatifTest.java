package ca.qc.grasset.ag420pb4.tp02.business;

import java.util.Date;


import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreProfesseur;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionProfesseurIntrouvable;

public class MediateurSupprimerProfesseurAlternatifTest {

   private final RegistreProfesseur registre = Mockito.mock(RegistreProfesseur.class);

   public MediateurSupprimerProfesseurAlternatifTest() {

   }

   @Test(expected = ExceptionProfesseurIntrouvable.class)
   public void execute() throws ExceptionProfesseurIntrouvable {

     MediateurSuppresionProfesseur mediateurSuppresionProfesseur = new MediateurSuppresionProfesseur(this.registre);
     Professeur nouveauProfesseur = getProfesseur();

     Mockito.when(this.registre.obtenir(nouveauProfesseur)).thenReturn(getProfesseur());

     mediateurSuppresionProfesseur.executer(nouveauProfesseur);


   }


     private Professeur getProfesseur() {

       Professeur professeur = new Professeur("CMagno", "", "", new Date(), "123456789");

        return professeur;
    }

}
