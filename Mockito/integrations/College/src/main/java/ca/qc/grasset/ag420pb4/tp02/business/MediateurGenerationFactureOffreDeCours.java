package ca.qc.grasset.ag420pb4.tp02.business;

import java.util.ArrayList;
import java.util.List;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreEtudiant;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreFacture;
import ca.qc.grasset.ag420pb4.tp02.entities.Etudiant;
import ca.qc.grasset.ag420pb4.tp02.entities.Facture;
import ca.qc.grasset.ag420pb4.tp02.entities.InscriptionSemestre;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.Semestre;
import ca.qc.grasset.ag420pb4.tp02.entities.StatutFacture;

public class MediateurGenerationFactureOffreDeCours {

    private RegistreEtudiant registreEtudiant;
    private RegistreFacture registreFacture;

    public MediateurGenerationFactureOffreDeCours(final RegistreEtudiant registreEtudiant_, final RegistreFacture registreFacture_) {
        this.registreEtudiant = registreEtudiant_;
        this.registreFacture = registreFacture_;
    }


    public final void executer(final OffreDeCours offreDeCours_) {

        List<OffreDeCours> courses = new ArrayList<>();
        courses.add(offreDeCours_);
        Semestre semestre = new Semestre();
        InscriptionSemestre inscription = new  InscriptionSemestre(semestre, courses);

        for (Etudiant etudiant : offreDeCours_.getEtudiants()) {
             Etudiant etudiantRegistre = registreEtudiant.obtenir(etudiant);

             if (etudiantRegistre != null) {
                 Facture facture = new Facture(etudiant, new StatutFacture("ATTEND"), inscription);
                 facture = registreFacture.creer(facture);
                 System.out.println(facture.toString());
             }
        }
    }

}
