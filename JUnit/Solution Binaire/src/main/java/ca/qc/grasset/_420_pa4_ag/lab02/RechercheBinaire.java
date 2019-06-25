package ca.qc.grasset._420_pa4_ag.lab02;

import java.util.Arrays;

public class RechercheBinaire {

    public RechercheBinaire() {

        super();
    }

    /**
     * Exigences:   - 'tableau' n'est pas null.
     *              - Le tableau est trié en ordre croissant de valeur
     *                  i.e. Pour chaque index 'i' et index 'j'
     *                      si 'i' < 'j' alors 'tableau[i]' < 'tableau[j]'.
     * Validation:  - s'il y a un index 'i' tel que 'tableau[i] == valeur',
     *                  la méthode retourne true.
     *              - autrement, la méthode retourne false.
     *              - dans tous les cas, 'tableau' est laissé inchangé.
     **/
    public boolean rechercher(
        final int[] tableau_,
        final int valeur_) {

        int noComparaison = 1;

        int gauche = 0;
        int droit = tableau_.length - 1;
        while (gauche <= droit) {
            int index = (droit + gauche) / 2;

            System.out.println("Comparaison #" + noComparaison++);
            System.out.println("Borne de recherche - Gauche = " + gauche);
            System.out.println("Borne de recherche - Droite = " + droit);
            System.out.println(
                "Tableau d'entiers à rechercher : "
                    + Arrays.toString(Arrays.copyOfRange(tableau_, gauche, droit + 1)));
            System.out.println("Index élément central = " + index);
            System.out.println("Valeur élément central = " + tableau_[index]);
            System.out.println("Valeur recherchée = " + valeur_);
            System.out.println("==============================");

            if (tableau_[index] == valeur_) {
                return true;
            }
            if (tableau_[index] > valeur_) {
                droit = index - 1;
            } else {
                gauche = index + 1;
            }
        }
        return false;

    }
}
