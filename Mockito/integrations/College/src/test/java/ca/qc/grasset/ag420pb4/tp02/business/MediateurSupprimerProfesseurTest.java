package ca.qc.grasset.ag420pb4.tp02.business;

import java.util.Date;


import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreProfesseur;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionProfesseurIntrouvable;

public class MediateurSupprimerProfesseurTest {

   private final RegistreProfesseur registre = Mockito.mock(RegistreProfesseur.class);

   public MediateurSupprimerProfesseurTest() {

   }

   @Test
   public void execute() throws ExceptionProfesseurIntrouvable {

     MediateurSuppresionProfesseur mediateurSuppresionProfesseur = new MediateurSuppresionProfesseur(this.registre);
     Professeur nouveauProfesseur = getProfesseur();

     Mockito.when(this.registre.obtenir(nouveauProfesseur)).thenReturn(getProfesseur());

     mediateurSuppresionProfesseur.executer(nouveauProfesseur);

     Mockito.verify(this.registre).supprimer(nouveauProfesseur);

   }


     private Professeur getProfesseur() {

       Professeur professeur = new Professeur("CMagno", "Carlo", "Magno", new Date(), "123456789");

        return professeur;
    }

}
