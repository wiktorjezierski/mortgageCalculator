package MortgageCalculator.MortgageCalculator.logic;

import java.util.List;

public class Result {

	private List<Rata> raty;
	private double odsetkiCalkowite;
	private double sumaNadplat;
	private double kwotaBazowa;
	private double prowizja;
	
	public Result(List<Rata> raty, double odsetkiCalkowite, double kwotaBazowa, double prowizja, double sumaNadplat) {
		super();
		this.raty = raty;
		this.odsetkiCalkowite = odsetkiCalkowite;
		this.kwotaBazowa = kwotaBazowa;
		this.prowizja = prowizja;
		this.sumaNadplat = sumaNadplat;
	}

	public List<Rata> getRaty() {
		return raty;
	}

	public double getOdsetkiCalkowite() {
		return odsetkiCalkowite;
	}

	public double getSumaNadplat() {
		return sumaNadplat;
	}

	public double getKwotaBazowa() {
		return kwotaBazowa;
	}

	public double getProwizja() {
		return prowizja;
	}
}
