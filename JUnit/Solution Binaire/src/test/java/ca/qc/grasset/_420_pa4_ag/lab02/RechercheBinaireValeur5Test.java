package ca.qc.grasset._420_pa4_ag.lab02;

import org.junit.Assert;
import org.junit.Test;

public class RechercheBinaireValeur5Test {

    public RechercheBinaireValeur5Test() {

        super();
    }

    @Test
    public void test() {

        final int[] tableau = { 1, 2, 3, 4, 5, 6, 7, 8 };

        final int valeur = 5;

        boolean indicateur = new RechercheBinaire().rechercher(tableau, valeur);

        if (indicateur) {
            System.out.println("La valeur " + valeur + " est dans le tableau.");
        } else {
            System.out.println("La valeur " + valeur + " n'est pas dans le tableau.");
        }

        Assert.assertTrue(indicateur);
    }

}
