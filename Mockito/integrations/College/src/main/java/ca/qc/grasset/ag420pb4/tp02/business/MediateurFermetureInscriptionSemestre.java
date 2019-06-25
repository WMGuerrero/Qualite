package ca.qc.grasset.ag420pb4.tp02.business;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreOffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.InscriptionSemestre;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionFactureIntrouvable;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionSystemeFacturationIndisponible;

public class MediateurFermetureInscriptionSemestre {

    private RegistreOffreDeCours registreOffreDeCours;
    private MediateurFermetureOffreDeCours mediateurFermetureOffreDeCours;
    private MediateurEnvoieFactureInscriptionSemestre mediateurEnvoieFactureInscriptionSemestre;

    public MediateurFermetureInscriptionSemestre(final RegistreOffreDeCours registreOffreDeCours_,
           final MediateurFermetureOffreDeCours mediateurFermetureOffreDeCours_,
           final MediateurEnvoieFactureInscriptionSemestre mediateurEnvoieFactureInscriptionSemestre_) {

        this.registreOffreDeCours = registreOffreDeCours_;
        this.mediateurFermetureOffreDeCours = mediateurFermetureOffreDeCours_;
        this.mediateurEnvoieFactureInscriptionSemestre = mediateurEnvoieFactureInscriptionSemestre_;
    }

    public final void executer(final InscriptionSemestre inscriptionSemestre_)
           throws ExceptionFactureIntrouvable, ExceptionSystemeFacturationIndisponible {

         for (OffreDeCours offreDeCours : inscriptionSemestre_.getOffreDeCours()) {

            OffreDeCours cours = registreOffreDeCours.obtenir(offreDeCours);

            mediateurFermetureOffreDeCours.executer(cours);

         }

         mediateurEnvoieFactureInscriptionSemestre.executer(inscriptionSemestre_);

     }

}
