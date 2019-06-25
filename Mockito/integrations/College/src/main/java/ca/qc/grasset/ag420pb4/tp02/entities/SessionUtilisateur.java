package ca.qc.grasset.ag420pb4.tp02.entities;

import java.util.Date;

public class SessionUtilisateur {

    private Utilisateur utilisateur;
    private Date dateDeDebut;


    public SessionUtilisateur(final Utilisateur utilisateur_, final Date dateDeDebut_) {
           this.utilisateur = utilisateur_;
           this.dateDeDebut = dateDeDebut_;
    }

    public final Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public final Date getDateDeDebut() {
       return dateDeDebut;
    }

}
