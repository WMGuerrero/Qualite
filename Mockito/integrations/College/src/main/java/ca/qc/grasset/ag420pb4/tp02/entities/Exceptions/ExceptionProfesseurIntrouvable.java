package ca.qc.grasset.ag420pb4.tp02.entities.Exceptions;

@SuppressWarnings("serial")
public class ExceptionProfesseurIntrouvable extends Exception {

    public ExceptionProfesseurIntrouvable() {
         super("Professeur n'existe pas pour le cours.");
    }

}
