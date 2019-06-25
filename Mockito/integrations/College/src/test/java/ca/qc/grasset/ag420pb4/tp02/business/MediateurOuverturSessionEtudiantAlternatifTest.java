package ca.qc.grasset.ag420pb4.tp02.business;


import java.util.Date;


import org.junit.Test;
import org.mockito.Mockito;

import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreSessionUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.business.interfaces.RegistreUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.entities.SessionUtilisateur;
import ca.qc.grasset.ag420pb4.tp02.entities.Utilisateur;
import ca.qc.grasset.ag420pb4.tp02.entities.Exceptions.ExceptionNomMotPasseInvalide;

public class MediateurOuverturSessionEtudiantAlternatifTest {

    private final RegistreSessionUtilisateur sessionUtilisateur = Mockito.mock(RegistreSessionUtilisateur.class);

    private final RegistreUtilisateur registreUtilisateur = Mockito.mock(RegistreUtilisateur.class);

    public MediateurOuverturSessionEtudiantAlternatifTest() {

    }

    @Test(expected = ExceptionNomMotPasseInvalide.class)
    public void execute() throws ExceptionNomMotPasseInvalide {

        MediateurOuverturSessionUtilisateur mediateurOuverturSessionUtilisateur = new MediateurOuverturSessionUtilisateur(this.sessionUtilisateur, this.registreUtilisateur);
        SessionUtilisateur sessionTest = new SessionUtilisateur(getUtilisateur(), new Date());

        Utilisateur utilisateur = getUtilisateur();
        Utilisateur user = new Utilisateur("");

        Mockito.when(this.registreUtilisateur.obtenir(utilisateur))
        .thenReturn(user);

        Mockito.when(this.sessionUtilisateur.creer(utilisateur))
        .thenReturn(sessionTest);

        SessionUtilisateur session = mediateurOuverturSessionUtilisateur.executer(utilisateur);

        System.out.println(session.toString());
    }

    private Utilisateur getUtilisateur() {

       Utilisateur utilisateur = new Utilisateur("wbarrera");

        return utilisateur;
    }

}
