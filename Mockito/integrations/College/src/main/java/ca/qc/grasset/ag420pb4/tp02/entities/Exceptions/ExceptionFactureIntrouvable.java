package ca.qc.grasset.ag420pb4.tp02.entities.Exceptions;

@SuppressWarnings("serial")
public class ExceptionFactureIntrouvable extends Exception {

    public ExceptionFactureIntrouvable() {
          super("Facture spécifié n'existe pas");
    }
}
