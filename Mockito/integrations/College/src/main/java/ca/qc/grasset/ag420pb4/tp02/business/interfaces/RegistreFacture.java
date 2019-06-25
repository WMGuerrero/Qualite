package ca.qc.grasset.ag420pb4.tp02.business.interfaces;

import ca.qc.grasset.ag420pb4.tp02.entities.Facture;

public interface RegistreFacture {

    Facture creer(Facture facture_);
    Facture obtenir(Facture facture_);

}
