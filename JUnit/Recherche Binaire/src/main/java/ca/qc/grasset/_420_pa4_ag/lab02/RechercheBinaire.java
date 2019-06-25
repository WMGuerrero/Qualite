package ca.qc.grasset._420_pa4_ag.lab02;

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
        final int[] tableau,
        final int valeur) {

        int gauche = 0;
        int droit = tableau.length - 1;
        while (gauche <= droit) {
            int index = (droit + gauche) / 2;
            if (tableau[index] == valeur) {
                return true;
            }
            if (tableau[index] < valeur) {
                droit = index - 1;
            } else {
                gauche = index + 1;
            }
        }
        return false;

    }
}
