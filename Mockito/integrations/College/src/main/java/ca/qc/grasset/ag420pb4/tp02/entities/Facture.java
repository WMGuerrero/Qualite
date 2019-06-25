package ca.qc.grasset.ag420pb4.tp02.entities;

public class Facture {
    private Etudiant etudiant;
    private StatutFacture statusFacture;
    private InscriptionSemestre inscriptionSemestre;

    public Facture(final Etudiant etudiant_, final StatutFacture statusFacture_,
                   final InscriptionSemestre inscriptionSemestre_) {
        this.etudiant = etudiant_;
        this.statusFacture = statusFacture_;
        this.inscriptionSemestre = inscriptionSemestre_;
    }

    public final Etudiant getEtudiant() {
        return etudiant;
    }

    public final StatutFacture getStatusFacture() {
        return statusFacture;
    }

    public final InscriptionSemestre getInscriptionSemestre() {
        return inscriptionSemestre;
    }

	@Override
	public String toString() {
		return "Facture [getEtudiant()=" + getEtudiant() + ", getStatusFacture()=" + getStatusFacture()
				+ ", getInscriptionSemestre()=" + getInscriptionSemestre() + "]";
	}

    
}
