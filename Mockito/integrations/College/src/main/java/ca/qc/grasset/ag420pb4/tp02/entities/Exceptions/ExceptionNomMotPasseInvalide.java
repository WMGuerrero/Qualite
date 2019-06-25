package ca.qc.grasset.ag420pb4.tp02.entities.Exceptions;

@SuppressWarnings("serial")
public class ExceptionNomMotPasseInvalide extends Exception {

    public ExceptionNomMotPasseInvalide() {
          super("Nom / mot de passe invalide.");
    }
}
