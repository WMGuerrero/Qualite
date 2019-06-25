package ca.qc.grasset.ag420pb4.tp02.business;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreProfesseur;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreSessionUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;
import ca.qc.grasset.ag420pb4.tp02.entities.Registraire;
import ca.qc.grasset.ag420pb4.tp02.entities.SessionUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionNomMotPasseInvalide;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionProfesseurIntrouvable;

public class MediateurCreationProfesseurTest {

   private final RegistreProfesseur registreProfesseur = Mockito.mock(RegistreProfesseur.class);
   private final RegistreSessionUtilisateur sessionUtilisateur = Mockito.mock(RegistreSessionUtilisateur.class);
   private final RegistreUtilisateur registreUtilisateur = Mockito.mock(RegistreUtilisateur.class);

   public MediateurCreationProfesseurTest() {

   }

   @Test
   public void execute() throws ExceptionProfesseurIntrouvable, ExceptionNomMotPasseInvalide {

     MediateurCreationProfesseur mediateurCreationProfesseur =
             new MediateurCreationProfesseur(this.registreProfesseur);
     MediateurOuverturSessionUtilisateur mediateurCreationSesion =
             new MediateurOuverturSessionUtilisateur(this.sessionUtilisateur, this.registreUtilisateur);
     Professeur nouveauProfesseur = getProfesseur();
     Registraire secretarie = creeRegistraire();
     SessionUtilisateur sessionRegistraire = new SessionUtilisateur(secretarie, new Date());

     Mockito.when(this.registreProfesseur.creer(nouveauProfesseur))
        .thenReturn(getMockProfesseur());
     Mockito.when(this.registreUtilisateur.obtenir(secretarie))
     .thenReturn(secretarie);
     Mockito.when(this.sessionUtilisateur.creer(secretarie))
     .thenReturn(sessionRegistraire);

     SessionUtilisateur session = mediateurCreationSesion.executer(secretarie);
     Assert.assertTrue(session.getUtilisateur().getIdentificateur()
              .equalsIgnoreCase(sessionRegistraire.getUtilisateur().getIdentificateur()));

     Professeur professeur = mediateurCreationProfesseur.executer(nouveauProfesseur);

     Assert.assertTrue(!professeur.getIdentificateur().isEmpty());

   }


     private Professeur getProfesseur() {

       Professeur professeur = new Professeur("", "Carlo", "Magno", new Date(), "123456789");

        return professeur;
    }

     private Professeur getMockProfesseur() {

       Professeur professeur = new Professeur("CMagno", "Carlo", "Magno", new Date(), "ABCDEFGD");

       return professeur;
    }

     private Registraire creeRegistraire() {
         return new Registraire("Secretarie");
     }
}
