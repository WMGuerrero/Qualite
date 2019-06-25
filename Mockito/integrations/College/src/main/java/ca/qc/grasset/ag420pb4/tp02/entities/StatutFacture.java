package ca.qc.grasset.ag420pb4.tp02.entities;

public class StatutFacture {

    private String statusFacture;

    public StatutFacture(final String statusFacture_) {
        super();
        this.statusFacture = statusFacture_;
    }

    public StatutFacture() {
        final String defaultStatut = "ATTEND";
        this.statusFacture = defaultStatut;
    }

    public final boolean factureEnvoiee() {
        if ("ENVOIEE".equalsIgnoreCase(statusFacture)) {
           return true;
        }
        return false;
    }

    public final boolean factureNil() {
        if ("NIL".equalsIgnoreCase(statusFacture)) {
           return true;
        }
       return false;
    }

	@Override
	public String toString() {
		return "StatutFacture [factureEnvoiee()=" + factureEnvoiee() + ", factureNil()=" + factureNil() + "]";
	}
    
    
}
