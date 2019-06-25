package ca.qc.grasset._420_pa4_ag.lab02;

import org.junit.Test;

public class RechercheBinaireTableauNullTest {

    public RechercheBinaireTableauNullTest() {

        super();
    }

    @Test(expected = NullPointerException.class)
    public void test() {

        new RechercheBinaire().rechercher(null, 0);
    }

}
