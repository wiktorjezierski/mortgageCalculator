package MortgageCalculator.MortgageCalculator.starter;

import MortgageCalculator.MortgageCalculator.logic.CzestotliwoscNadplat;
import MortgageCalculator.MortgageCalculator.logic.RatyMalejace;

public class ApplicationStarterDummy {

	public static void main(String[] args) {
		RatyMalejace rm = new RatyMalejace();
		rm.calculate(240000, 12*15, 4.57/(100*12), 1, 6000, 24, CzestotliwoscNadplat.HALFYEAR);
	}
}
