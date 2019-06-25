package ca.qc.grasset.ag420pb4.tp02.business.interfaces;

import ca.qc.grasset.ag420pb4.tp02.entities.SessionUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.entities.Utilisateur;

public interface RegistreSessionUtilisateur {

  SessionUtilisateur creer(Utilisateur utilisateur_);
}
