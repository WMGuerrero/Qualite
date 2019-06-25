package ca.qc.grasset.ag420pb4.tp02.entities;

import java.util.Date;

public class Professeur extends Utilisateur {

     private String nomes;
     private String prenom;
     private Date dateDeNaissance;
     private String numeroAssuranceSociale;
     private Departement departement;
     private StatutProfesseur status;


     public Professeur(final String identificateur_, final String nomes_, final String prenom_, final Date dateDeNaissance_, final String numeroAssuranceSociale_) {
       super(identificateur_);
       this.nomes = nomes_;
       this.prenom = prenom_;
       this.dateDeNaissance = dateDeNaissance_;
       this.numeroAssuranceSociale = numeroAssuranceSociale_;
     }


    public final String getNom() {
        return nomes;
     }


     public final String getPrenom() {
        return prenom;
     }

     public final String getNumeroAssuranceSociale() {
        return numeroAssuranceSociale;
     }


    public final String getNomes() {
         return nomes;
    }


    public final Date getDateDeNaissance() {
       return dateDeNaissance;
    }


    public final Departement getDepartement() {
        return departement;
    }


    public final StatutProfesseur getStatus() {
       return status;
    }

    public boolean estValide() {
    	return !this.getIdentificateur().isEmpty();
    }

	@Override
	public String toString() {
		return "Professeur [getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getNumeroAssuranceSociale()="
				+ getNumeroAssuranceSociale() + ", getNomes()=" + getNomes() + ", getDateDeNaissance()="
				+ getDateDeNaissance() + ", getDepartement()=" + getDepartement() + ", getStatus()=" + getStatus()
				+ "]";
	}
    
    

}
