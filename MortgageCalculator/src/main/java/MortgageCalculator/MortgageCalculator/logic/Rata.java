package MortgageCalculator.MortgageCalculator.logic;

public class Rata {

	private double rataKapitalowa;
	private double odsetki;
	private int numerRaty;
	private double kwota;
	
	public Rata(int numerRaty, double rataKapitalowa, double odsetki, double kwota) {
		super();
		this.rataKapitalowa = rataKapitalowa;
		this.odsetki = odsetki;
		this.numerRaty = numerRaty;
		this.kwota = kwota;
	}

	public double getRataKapitalowa() {
		return rataKapitalowa;
	}

	public double getOdsetki() {
		return odsetki;
	}

	public int getNumerRaty() {
		return numerRaty;
	}

	public double getKwota() {
		return kwota;
	}
	
}
