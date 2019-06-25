package ca.qc.grasset.ag420pb4.tp02.business;

import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreOffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.business.utilities.MockEntity;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionFactureIntrouvable;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionSystemeFacturationIndisponible;

public class MediateurAnnulationOffreDeCoursTest {

    private RegistreOffreDeCours registreOffreDeCours = Mockito.mock(RegistreOffreDeCours.class);


    public MediateurAnnulationOffreDeCoursTest() {

    }

    @Test
    public void test() throws ExceptionFactureIntrouvable, ExceptionSystemeFacturationIndisponible {

        MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours =
                new MediateurAnnulationOffreDeCours(registreOffreDeCours);


        MockEntity mockValue = new MockEntity();
        OffreDeCours offreDeCours = mockValue.getOffreDeCours();

        Mockito.when(registreOffreDeCours.modifier(offreDeCours))
                .thenReturn(offreDeCours);
        Mockito.when(registreOffreDeCours.obtenir(offreDeCours))
                .thenReturn(offreDeCours);

        mediateurAnnulationOffreDeCours.executer(offreDeCours);

    }

}
