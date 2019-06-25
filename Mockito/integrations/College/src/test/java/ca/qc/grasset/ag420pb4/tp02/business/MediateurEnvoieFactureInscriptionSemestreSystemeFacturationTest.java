package ca.qc.grasset.ag420pb4.tp02.business;

import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.DiffuseurFacture;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreFacture;
import ca.qc.grasset.ag420pb4.tp02.business.utilities.MockEntity;
import ca.qc.grasset.ag420pb4.tp02.entities.Facture;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionFactureIntrouvable;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionSystemeFacturationIndisponible;

public class MediateurEnvoieFactureInscriptionSemestreSystemeFacturationTest {

    private RegistreFacture registreFacture = Mockito.mock(RegistreFacture.class);
    private DiffuseurFacture diffuseurFacture = Mockito.mock(DiffuseurFacture.class);

    public MediateurEnvoieFactureInscriptionSemestreSystemeFacturationTest() {

    }

    @Test(expected = ExceptionFactureIntrouvable.class)
    public void test() throws ExceptionFactureIntrouvable, ExceptionSystemeFacturationIndisponible {
        MediateurEnvoieFactureInscriptionSemestre mediateurEnvoieFactureInscriptionSemestre = new MediateurEnvoieFactureInscriptionSemestre(
             this.diffuseurFacture, this.registreFacture);

        MockEntity mockValue = new MockEntity();
        OffreDeCours offreDeCours = mockValue.getOffreDeCours();
        Facture factureEnvoie = mockValue.getFactureDifusse(offreDeCours);
        Facture facture = mockValue.getFactureDebout(offreDeCours);

        Mockito.when(diffuseurFacture.diffuser(facture))
                .thenReturn(factureEnvoie);

        Mockito.when(registreFacture.creer(Mockito.any(Facture.class)))
                .thenReturn(facture);
        Mockito.when(registreFacture.obtenir(Mockito.any(Facture.class)))
                .thenReturn(facture);
        
        System.out.println(offreDeCours.toString());

        mediateurEnvoieFactureInscriptionSemestre.executer(mockValue.getInscriptionSemestre());

    }

}
