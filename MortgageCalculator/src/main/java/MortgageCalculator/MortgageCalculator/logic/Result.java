package MortgageCalculator.MortgageCalculator.logic;

import java.util.List;

public class Result {

	private List<Rata> raty;
	private double odsetkiCalkowite;
	
	public Result(List<Rata> raty, double odsetkiCalkowite) {
		super();
		this.raty = raty;
		this.odsetkiCalkowite = odsetkiCalkowite;
	}

	public List<Rata> getRaty() {
		return raty;
	}

	public double getOdsetkiCalkowite() {
		return odsetkiCalkowite;
	}
	
}
