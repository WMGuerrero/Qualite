package ca.qc.grasset.ag420pb4.tp02.business;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.DiffuseurFacture;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreFacture;
import ca.qc.grasset.ag420pb4.tp02.entities.Etudiant;
import ca.qc.grasset.ag420pb4.tp02.entities.Facture;
import ca.qc.grasset.ag420pb4.tp02.entities.InscriptionSemestre;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.StatutFacture;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionFactureIntrouvable;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionSystemeFacturationIndisponible;

public class MediateurEnvoieFactureInscriptionSemestre {

    private DiffuseurFacture diffuseurFacture;
    private RegistreFacture registreFacteur;

    public MediateurEnvoieFactureInscriptionSemestre(final DiffuseurFacture diffuseurFacture_,
           final RegistreFacture registreFacteur_) {
        this.diffuseurFacture = diffuseurFacture_;
        this.registreFacteur = registreFacteur_;
    }

    public final void executer(final InscriptionSemestre inscriptionSemestre_)
           throws ExceptionFactureIntrouvable, ExceptionSystemeFacturationIndisponible {

        for (OffreDeCours offreDeCours : inscriptionSemestre_.getOffreDeCours()) {

             if (offreDeCours.isValide()) {

                for (Etudiant etudiant : offreDeCours.getEtudiants()) {

                    Facture facture = new Facture(etudiant, new StatutFacture(), inscriptionSemestre_);
                    facture = registreFacteur.obtenir(facture);

                    if (facture.getStatusFacture().factureNil()) {
                        throw new ExceptionFactureIntrouvable();
                    }

                    facture = diffuseurFacture.diffuser(facture);

                    if (!facture.getStatusFacture().factureEnvoiee()) {
                    	 System.out.println(facture.toString());
                         throw new ExceptionSystemeFacturationIndisponible();
                    }
                    System.out.println(facture.toString());
                }
            }
        }
        System.out.println(inscriptionSemestre_.toString());
    }
}
