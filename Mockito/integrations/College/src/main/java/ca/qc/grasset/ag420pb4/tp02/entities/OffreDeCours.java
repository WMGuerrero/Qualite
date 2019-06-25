package ca.qc.grasset.ag420pb4.tp02.entities;

import java.util.List;

public class OffreDeCours {
    private Professeur professeur;
    private Cours cours;
    private List<Etudiant> etudiants;
    private Semestre semestre;
    private StatusOfreeDeCours status;

    public OffreDeCours(final Professeur professeur_, final Cours cours_, final List<Etudiant> etudiants_,
             final Semestre semestre_, final StatusOfreeDeCours status_) {
        this.professeur = professeur_;
        this.cours = cours_;
        this.etudiants = etudiants_;
        this.semestre = semestre_;
        this.status = status_;
    }

    public final Professeur getProfesseur() {
       return professeur;
    }

    public final Cours getCours() {
        return cours;
    }

    public final List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public final Semestre getSemestre() {
        return semestre;
    }

    public final StatusOfreeDeCours getStatus() {
        return status;
    }

    public final boolean isValide() {
        final int tailleCOURS = 3;
        return this.professeur.estValide() && this.etudiants.size() >= tailleCOURS;
    }

	@Override
	public String toString() {
		return "OffreDeCours [getProfesseur()=" + getProfesseur() + ", getCours()=" + getCours() + ", getEtudiants()="
				+ getEtudiants() + ", getSemestre()=" + getSemestre() + ", getStatus()=" + getStatus() + ", isValide()="
				+ isValide() + "]";
	}
    

}
