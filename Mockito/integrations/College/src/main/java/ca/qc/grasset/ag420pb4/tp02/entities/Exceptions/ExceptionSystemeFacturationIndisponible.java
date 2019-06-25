package ca.qc.grasset.ag420pb4.tp02.entities.Exceptions;

@SuppressWarnings("serial")
public class ExceptionSystemeFacturationIndisponible extends Exception {

    public ExceptionSystemeFacturationIndisponible() {
           super("Systeme de Facturation n'est pas disponible.");
    }

}
