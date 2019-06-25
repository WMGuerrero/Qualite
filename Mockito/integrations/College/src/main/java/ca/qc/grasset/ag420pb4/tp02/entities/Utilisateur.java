package ca.qc.grasset.ag420pb4.tp02.entities;

public class Utilisateur {

    private String identificateur;

    public Utilisateur(final String identificateur_) {
        this.identificateur = identificateur_;
    }

    public final String getIdentificateur() {
        return identificateur;
    }

}
