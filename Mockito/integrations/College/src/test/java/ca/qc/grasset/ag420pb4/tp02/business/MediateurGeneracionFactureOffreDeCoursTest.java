package ca.qc.grasset.ag420pb4.tp02.business;

import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreEtudiant;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreFacture;
import ca.qc.grasset.ag420pb4.tp02.business.utilities.MockEntity;
import ca.qc.grasset.ag420pb4.tp02.entities.Facture;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionFactureIntrouvable;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionSystemeFacturationIndisponible;

public class MediateurGeneracionFactureOffreDeCoursTest {


    private RegistreEtudiant registreEtudiant = Mockito.mock(RegistreEtudiant.class);
    private RegistreFacture registreFacture = Mockito.mock(RegistreFacture.class);


    public MediateurGeneracionFactureOffreDeCoursTest() {

    }

    @Test
    public void test() throws ExceptionFactureIntrouvable, ExceptionSystemeFacturationIndisponible {
        MediateurGenerationFactureOffreDeCours mediateurGenerationFactureOffreDeCours = new MediateurGenerationFactureOffreDeCours(
             this.registreEtudiant, this.registreFacture);
     

        MockEntity mockValue = new MockEntity();
        OffreDeCours offreDeCours = mockValue.getOffreDeCours();
        Facture facture = mockValue.getFacture(offreDeCours);

        Mockito.when(registreEtudiant.obtenir(mockValue.getEtudiant()))
                .thenReturn(mockValue.getEtudiant());

        Mockito.when(registreFacture.creer(Mockito.any(Facture.class)))
                .thenReturn(facture);
        Mockito.when(registreFacture.obtenir(Mockito.any(Facture.class)))
                .thenReturn(facture);

        mediateurGenerationFactureOffreDeCours.executer(offreDeCours);

    }

}
