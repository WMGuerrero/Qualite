package ca.qc.grasset.ag420pb4.tp02.business;

import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.DiffuseurFacture;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreEtudiant;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreFacture;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreOffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.business.utilities.MockEntity;
import ca.qc.grasset.ag420pb4.tp02.entities.Facture;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionFactureIntrouvable;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionSystemeFacturationIndisponible;

public class MediateurFermetureInscripcionSemestreFactureIntrouvableTest {

    private RegistreOffreDeCours registreOffreDeCours = Mockito.mock(RegistreOffreDeCours.class);
    private RegistreEtudiant registreEtudiant = Mockito.mock(RegistreEtudiant.class);
    private RegistreFacture registreFacture = Mockito.mock(RegistreFacture.class);
    private DiffuseurFacture diffuseurFacture = Mockito.mock(DiffuseurFacture.class);

    public MediateurFermetureInscripcionSemestreFactureIntrouvableTest() {

    }

    @Test(expected = ExceptionSystemeFacturationIndisponible.class)
    public void test() throws ExceptionFactureIntrouvable, ExceptionSystemeFacturationIndisponible {
        MediateurGenerationFactureOffreDeCours mediateurGenerationFactureOffreDeCours = new MediateurGenerationFactureOffreDeCours(
             this.registreEtudiant, this.registreFacture);
        MediateurEnvoieFactureInscriptionSemestre mediateurEnvoieFactureInscriptionSemestre = new MediateurEnvoieFactureInscriptionSemestre(
             this.diffuseurFacture, this.registreFacture);
        MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours =
                new MediateurAnnulationOffreDeCours(registreOffreDeCours);
        MediateurFermetureOffreDeCours mediateurFermetureOffreDeCours = new MediateurFermetureOffreDeCours(
             this.registreOffreDeCours, mediateurGenerationFactureOffreDeCours, mediateurAnnulationOffreDeCours);
        MediateurFermetureInscriptionSemestre mediateurFermetureInscripcionSemestre = new MediateurFermetureInscriptionSemestre(
             this.registreOffreDeCours, mediateurFermetureOffreDeCours, mediateurEnvoieFactureInscriptionSemestre);

        MockEntity mockValue = new MockEntity();
        OffreDeCours offreDeCours = mockValue.getOffreDeCours();
        Facture factureEnvoie = mockValue.getFacture(offreDeCours);
        Facture facture = mockValue.getFacture(offreDeCours);

        Mockito.when(registreEtudiant.obtenir(mockValue.getEtudiant()))
                .thenReturn(mockValue.getEtudiant());
        Mockito.when(registreOffreDeCours.modifier(offreDeCours))
                .thenReturn(offreDeCours);
        Mockito.when(registreOffreDeCours.obtenir(offreDeCours))
                .thenReturn(offreDeCours);

        Mockito.when(diffuseurFacture.diffuser(facture))
                .thenReturn(factureEnvoie);
        Mockito.when(registreFacture.creer(Mockito.any(Facture.class)))
                .thenReturn(facture);
        Mockito.when(registreFacture.obtenir(Mockito.any(Facture.class)))
                .thenReturn(facture);

        mediateurFermetureInscripcionSemestre.executer(mockValue.getInscriptionSemestre());

    }

}
