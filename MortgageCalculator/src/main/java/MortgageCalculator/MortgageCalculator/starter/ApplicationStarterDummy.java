package MortgageCalculator.MortgageCalculator.starter;

import MortgageCalculator.MortgageCalculator.logic.RatyMalejace;
import MortgageCalculator.MortgageCalculator.logic.RatyRowne;
import MortgageCalculator.MortgageCalculator.logic.Request;
import MortgageCalculator.MortgageCalculator.logic.RequestBuilder;

public class ApplicationStarterDummy {

	public static void main(String[] args) {
		RatyMalejace rm = new RatyMalejace();
		RatyRowne rr = new RatyRowne();
		
		Request request = RequestBuilder.with()//
				.kwota(240000)//
				.okres(16*12)//
				.marza(1.88)//
				.wibor(1.79)//
				.prowizja(0)//
//				.nadplata(1000)//
//				.opoznienieNadplaty(3*12)//
//				.czestotliwoscNadplat(CzestotliwoscNadplat.MONTHLY)//
				.build();
		
//		rm.calculate(request);
		rr.calculate(request);
	}
}
