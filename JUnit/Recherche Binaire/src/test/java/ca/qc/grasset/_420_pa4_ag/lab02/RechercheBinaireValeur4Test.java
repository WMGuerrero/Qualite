package ca.qc.grasset._420_pa4_ag.lab02;

import org.junit.Test;

public class RechercheBinaireValeur4Test
    extends RechercheBinaireBaseTest {

    @Test
    public void test() {

        int valeur = 4;

        if (new RechercheBinaire().rechercher(RechercheBinaireBaseTest.TABLEAU, valeur)) {
            System.out.println("La valeur " + valeur + " est dans le tableau.");
        } else {
            System.out.println("La valeur " + valeur + " n'est pas dans le tableau.");
        }
    }

}
