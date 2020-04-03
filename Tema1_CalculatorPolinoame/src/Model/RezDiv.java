package Model;

public class RezDiv {
	private Polinom rezultat;
	private Polinom rest;
	
	public RezDiv(Polinom rez, Polinom rest) {
		this.rezultat = rez;
		this.rest = rest;
	}

	public Polinom getRezultat() {
		return rezultat;
	}

	public Polinom getRest() {
		return rest;
	}
	

}
