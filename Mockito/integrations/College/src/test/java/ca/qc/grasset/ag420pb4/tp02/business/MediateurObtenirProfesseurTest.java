package ca.qc.grasset.ag420pb4.tp02.business;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreProfesseur;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;

public class MediateurObtenirProfesseurTest {

     private final RegistreProfesseur registre = Mockito.mock(RegistreProfesseur.class);

     public MediateurObtenirProfesseurTest() {

     }

    @Test
    public void execute() {

        MediateurObtenirProfesseur mediateurObtenirProfesseur = new MediateurObtenirProfesseur(this.registre);

        Professeur nouveauProfesseur = getProfesseur();

        Mockito.when(this.registre.obtenir(nouveauProfesseur))
        .thenReturn(getMockProfesseur());

        Professeur professeur = mediateurObtenirProfesseur.executer(nouveauProfesseur);

        Assert.assertTrue(professeur.getNom().equalsIgnoreCase(getMockProfesseur().getNom()));
        Assert.assertTrue(professeur.getPrenom().equalsIgnoreCase(getMockProfesseur().getPrenom()));
        Assert.assertTrue(professeur.getNumeroAssuranceSociale().equalsIgnoreCase(getMockProfesseur().getNumeroAssuranceSociale()));

    }

    private Professeur getProfesseur() {

       Professeur utilisateur = new Professeur("CMagno", "", "", new Date(), "");

       return utilisateur;
    }

    private Professeur getMockProfesseur() {

        Professeur utilisateur = new Professeur("CMagno", "Carlo", "Magno", new Date(), "123456789");

        return utilisateur;
    }
}
