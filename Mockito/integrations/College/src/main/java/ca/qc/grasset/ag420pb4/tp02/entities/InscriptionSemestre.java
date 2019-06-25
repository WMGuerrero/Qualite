package ca.qc.grasset.ag420pb4.tp02.entities;

import java.util.List;

public class InscriptionSemestre {

    private Semestre semestre;
    private List<OffreDeCours> offreDeCours;

    public InscriptionSemestre(final Semestre semestre_, final List<OffreDeCours> offreDeCours_) {
        this.semestre = semestre_;
        this.offreDeCours = offreDeCours_;
    }

    public final Semestre getSemestre() {
        return semestre;
    }

    public final List<OffreDeCours> getOffreDeCours() {
        return offreDeCours;
    }

	@Override
	public String toString() {
		return "InscriptionSemestre [getSemestre()=" + getSemestre() + ", getOffreDeCours()=" + getOffreDeCours() + "]";
	}

    
}
