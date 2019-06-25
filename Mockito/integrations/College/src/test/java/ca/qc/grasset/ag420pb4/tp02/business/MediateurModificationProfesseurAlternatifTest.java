package ca.qc.grasset.ag420pb4.tp02.business;


import java.util.Date;


import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreProfesseur;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionProfesseurIntrouvable;

public class MediateurModificationProfesseurAlternatifTest {

    private final RegistreProfesseur registre = Mockito.mock(RegistreProfesseur.class);

    public MediateurModificationProfesseurAlternatifTest() {

    }

    @Test(expected = ExceptionProfesseurIntrouvable.class)
    public void execute() throws ExceptionProfesseurIntrouvable {

        MediateurModificationProfesseur mediateurModificationProfesseur = new MediateurModificationProfesseur(this.registre);

        Professeur nouveauProfesseur = getProfesseur();

        Mockito.when(this.registre.obtenir(nouveauProfesseur)).thenReturn(getProfesseur());
        Mockito.when(this.registre.modifier(nouveauProfesseur)).thenReturn(getMockProfesseur());

        nouveauProfesseur = mediateurModificationProfesseur.executer(nouveauProfesseur);


    }

    private Professeur getProfesseur() {

       Professeur professeur = new Professeur("CMagno", "", "", new Date(), "123456789");

       return professeur;
    }

    private Professeur getMockProfesseur() {

        Professeur professeur = new Professeur("", "Carlos", "Magno", new Date(), "ABCDEFGD");

        return professeur;
   }

}
