package ca.qc.grasset.ag420pb4.tp02.business.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.qc.grasset.ag420pb4.tp02.entities.Cours;
import ca.qc.grasset.ag420pb4.tp02.entities.Etudiant;
import ca.qc.grasset.ag420pb4.tp02.entities.Facture;
import ca.qc.grasset.ag420pb4.tp02.entities.InscriptionSemestre;
import ca.qc.grasset.ag420pb4.tp02.entities.OffreDeCours;
import ca.qc.grasset.ag420pb4.tp02.entities.Professeur;
import ca.qc.grasset.ag420pb4.tp02.entities.Semestre;
import ca.qc.grasset.ag420pb4.tp02.entities.StatutFacture;
import ca.qc.grasset.ag420pb4.tp02.entities.StatusOfreeDeCours;

public class MockEntity {
    private OffreDeCours offreDeCours;
    private OffreDeCours offreDeCoursInvalide;
    private Etudiant etudiant;
    private InscriptionSemestre inscripcionSemestre;
    private InscriptionSemestre inscripcionSemestreInvalide;

    public MockEntity() {
        this.etudiant = this.creeEtudiant();
        this.offreDeCours = this.getOffreDeCours(new Semestre());
        this.offreDeCoursInvalide = this.getOffreDeCoursInvalide(new Semestre());
        this.inscripcionSemestre = getInscripcionSemestre(offreDeCours);
        this.inscripcionSemestreInvalide = getInscripcionSemestre(offreDeCoursInvalide);
    }

    public final OffreDeCours getOffreDeCours() {
       return offreDeCours;
    }

    public final OffreDeCours getOffreDeCoursInvalide() {
         return offreDeCoursInvalide;
     }

    public final Etudiant getEtudiant() {
        return this.etudiant;
    }

    public final InscriptionSemestre getInscriptionSemestre() {
        return this.inscripcionSemestre;
    }

    public final InscriptionSemestre getInscriptionSemestreInvalide() {
        return this.inscripcionSemestreInvalide;
    }

    public final Professeur getProfesseur() {
       return new Professeur("CMagno", "Carlo", "Magno", null, "123456789");
    }

    public final Facture getFactureDebout(final OffreDeCours offreDeCours_) {
       return new Facture(getEtudiant(), new StatutFacture("NIL"), this.inscripcionSemestre);
    }

    public final Facture getFacture(final OffreDeCours offreDeCours_) {
        return new Facture(getEtudiant(), new StatutFacture("ATTEND"), this.inscripcionSemestre);
    }

    public final Facture getFactureDifusse(final OffreDeCours offreDeCours_) {
        return new Facture(getEtudiant(), new StatutFacture("ENVOIEE"), this.inscripcionSemestre);
    }

    public final Etudiant creeEtudiant() {
       return new Etudiant("Pepito");
    }

    private InscriptionSemestre getInscripcionSemestre(final OffreDeCours offreDeCours_) {
        Semestre semestre = new Semestre();
        List<OffreDeCours> courses = new ArrayList<>();
        courses.add(offreDeCours_);
        return new InscriptionSemestre(semestre, courses);
    }

    private OffreDeCours getOffreDeCours(final Semestre semestre_) {
        Cours cours = new Cours();
        StatusOfreeDeCours statusOfreeDeCours = new StatusOfreeDeCours();
        Professeur professeur = getProfesseur();
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(this.etudiant);
        etudiants.add(this.etudiant);
        etudiants.add(this.etudiant);

        return new OffreDeCours(professeur, cours, etudiants, semestre_, statusOfreeDeCours);
     }

    private OffreDeCours getOffreDeCoursInvalide(final Semestre semestre_) {
        Cours cours = new Cours();
        StatusOfreeDeCours statusOfreeDeCours = new StatusOfreeDeCours();
        Professeur professeur = new Professeur("","","", new Date(), "");
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(this.etudiant);
        etudiants.add(this.etudiant);

        return new OffreDeCours(professeur, cours, etudiants, semestre_, statusOfreeDeCours);
     }
}
