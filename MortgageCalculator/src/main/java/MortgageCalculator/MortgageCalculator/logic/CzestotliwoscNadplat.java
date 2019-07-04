package MortgageCalculator.MortgageCalculator.logic;

public enum CzestotliwoscNadplat {

	MONTHLY(1), 
	BIMONTHLY(2), 
	HALFYEAR(6), 
	YEAR(12);
	
	private int czestotliwosc;

	private CzestotliwoscNadplat(int czestotliwosc) {
		this.czestotliwosc = czestotliwosc;
	}

	public int getCzestotliwosc() {
		return czestotliwosc;
	}
	
}
