package ca.qc.grasset.ag420pb4.tp02.business;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreOffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;

public class MediateurAnnulationOffreDeCours {

    private RegistreOffreDeCours registreOffreDeCours;

    public MediateurAnnulationOffreDeCours(final RegistreOffreDeCours registreOffreDeCours_) {
        super();
        this.registreOffreDeCours = registreOffreDeCours_;
    }

    public final void executer(final OffreDeCours offreDeCours_) {
        registreOffreDeCours.modifier(offreDeCours_);
    }
}
