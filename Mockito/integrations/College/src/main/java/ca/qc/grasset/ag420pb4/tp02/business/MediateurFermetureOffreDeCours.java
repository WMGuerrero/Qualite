package ca.qc.grasset.ag420pb4.tp02.business;


import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreOffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;

public class MediateurFermetureOffreDeCours {

    private RegistreOffreDeCours registreOffreDeCours;
    private MediateurGenerationFactureOffreDeCours  mediateurGenerationFactureOffreDeCours;
    private MediateurAnnulationOffreDeCours  mediateurAnnulationOffreDeCours;

    public MediateurFermetureOffreDeCours(final RegistreOffreDeCours registreOffreDeCours_,
            final MediateurGenerationFactureOffreDeCours mediateurGenerationFactureOffreDeCours_,
            final MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours_) {
        this.registreOffreDeCours = registreOffreDeCours_;
        this.mediateurGenerationFactureOffreDeCours = mediateurGenerationFactureOffreDeCours_;
        this.mediateurAnnulationOffreDeCours = mediateurAnnulationOffreDeCours_;
    }

    public final void executer(final OffreDeCours offreDeCours_) {

        OffreDeCours cours = registreOffreDeCours.obtenir(offreDeCours_);

        if (!cours.isValide()) {
             mediateurAnnulationOffreDeCours.executer(cours);
        } else {
             mediateurGenerationFactureOffreDeCours.executer(cours);
        }
    }
}
