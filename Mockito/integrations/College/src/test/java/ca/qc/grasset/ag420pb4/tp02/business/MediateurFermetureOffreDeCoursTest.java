package ca.qc.grasset.ag420pb4.tp02.business;

import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreEtudiant;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreFacture;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreOffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.business.utilities.MockEntity;
import ca.qc.grasset.ag420pb4.tp02.entities.Facture;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionFactureIntrouvable;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionSystemeFacturationIndisponible;

public class MediateurFermetureOffreDeCoursTest {

    private RegistreOffreDeCours registreOffreDeCours = Mockito.mock(RegistreOffreDeCours.class);
    private RegistreEtudiant registreEtudiant = Mockito.mock(RegistreEtudiant.class);
    private RegistreFacture registreFacture = Mockito.mock(RegistreFacture.class);


    public MediateurFermetureOffreDeCoursTest() {

    }

    @Test
    public void test() throws ExceptionFactureIntrouvable, ExceptionSystemeFacturationIndisponible {
        MediateurGenerationFactureOffreDeCours mediateurGenerationFactureOffreDeCours = new MediateurGenerationFactureOffreDeCours(
             this.registreEtudiant, this.registreFacture);

        MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours =
                new MediateurAnnulationOffreDeCours(registreOffreDeCours);
        MediateurFermetureOffreDeCours mediateurFermetureOffreDeCours = new MediateurFermetureOffreDeCours(
             this.registreOffreDeCours, mediateurGenerationFactureOffreDeCours, mediateurAnnulationOffreDeCours);


        MockEntity mockValue = new MockEntity();
        OffreDeCours offreDeCours = mockValue.getOffreDeCours();
        Facture facture = mockValue.getFacture(offreDeCours);

        Mockito.when(registreEtudiant.obtenir(mockValue.getEtudiant()))
                .thenReturn(mockValue.getEtudiant());
        Mockito.when(registreOffreDeCours.modifier(offreDeCours))
                .thenReturn(offreDeCours);
        Mockito.when(registreOffreDeCours.obtenir(offreDeCours))
                .thenReturn(offreDeCours);

        Mockito.when(registreFacture.creer(Mockito.any(Facture.class)))
                .thenReturn(facture);
        Mockito.when(registreFacture.obtenir(Mockito.any(Facture.class)))
                .thenReturn(facture);

        mediateurFermetureOffreDeCours.executer(offreDeCours);

    }

}
