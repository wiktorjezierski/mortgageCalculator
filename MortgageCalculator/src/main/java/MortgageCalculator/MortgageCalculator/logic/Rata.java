package MortgageCalculator.MortgageCalculator.logic;

public class Rata {

	private int numerRaty;
	private double kwotaDoSplaty;
	private double rataKapitalowa;
	private double odsetki;
	
	public Rata(int numerRaty, double rataKapitalowa, double odsetki, double kwota) {
		super();
		this.rataKapitalowa = rataKapitalowa;
		this.odsetki = odsetki;
		this.numerRaty = numerRaty;
		this.kwotaDoSplaty = kwota;
	}
	
	public int getNumerRaty() {
		return numerRaty;
	}
	
	public double getKwota() {
		return kwotaDoSplaty;
	}

	public double getRataKapitalowa() {
		return rataKapitalowa;
	}

	public double getOdsetki() {
		return odsetki;
	}
}
