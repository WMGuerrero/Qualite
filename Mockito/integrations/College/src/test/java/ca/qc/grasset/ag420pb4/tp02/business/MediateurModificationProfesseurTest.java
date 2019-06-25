package ca.qc.grasset.ag420pb4.tp02.business;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreProfesseur;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionProfesseurIntrouvable;

public class MediateurModificationProfesseurTest {

    private final RegistreProfesseur registre = Mockito.mock(RegistreProfesseur.class);

    public MediateurModificationProfesseurTest() {

    }

    @Test
    public void execute() throws ExceptionProfesseurIntrouvable {

       MediateurModificationProfesseur mediateurModificationProfesseur = new MediateurModificationProfesseur(this.registre);

       Professeur nouveauProfesseur = getProfesseur();

       Mockito.when(this.registre.obtenir(nouveauProfesseur)).thenReturn(getProfesseur());
       Mockito.when(this.registre.modifier(nouveauProfesseur)).thenReturn(getMockProfesseur());

       Professeur professeur = mediateurModificationProfesseur.executer(nouveauProfesseur);

       Assert.assertTrue(professeur.getNumeroAssuranceSociale().equalsIgnoreCase(getMockProfesseur().getNumeroAssuranceSociale()));
       Assert.assertTrue(professeur.getNom().equalsIgnoreCase(getMockProfesseur().getNom()));

    }

    private Professeur getProfesseur() {

        Professeur professeur = new Professeur("CMagno", "Carlos", "Magno", new Date(), "");

       return professeur;
    }

    private Professeur getMockProfesseur() {

       Professeur professeur = new Professeur("", "Carlos", "Magno", new Date(), "ABCDEFGD");

       return professeur;
    }

}
