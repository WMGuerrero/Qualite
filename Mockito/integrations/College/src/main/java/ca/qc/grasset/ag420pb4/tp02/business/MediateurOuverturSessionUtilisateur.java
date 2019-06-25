package ca.qc.grasset.ag420pb4.tp02.business;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreSessionUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.entities.SessionUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.entities.Utilisateur;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionNomMotPasseInvalide;

public class MediateurOuverturSessionUtilisateur {

    private RegistreSessionUtilisateur session;
    private RegistreUtilisateur registre;

    public MediateurOuverturSessionUtilisateur(final RegistreSessionUtilisateur session_, final RegistreUtilisateur registre_) {
         this.session = session_;
         this.registre = registre_;
    }

    public final SessionUtilisateur executer(final Utilisateur utilisateur_) throws ExceptionNomMotPasseInvalide {

       Utilisateur user = registre.obtenir(utilisateur_);

       if (user.getIdentificateur().isEmpty()) {
            throw new ExceptionNomMotPasseInvalide();
       }

       return this.session.creer(user);
    }
}
