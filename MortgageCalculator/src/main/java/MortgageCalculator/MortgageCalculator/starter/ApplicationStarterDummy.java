package MortgageCalculator.MortgageCalculator.starter;

import MortgageCalculator.MortgageCalculator.logic.CzestotliwoscNadplat;
import MortgageCalculator.MortgageCalculator.logic.RatyMalejace;
import MortgageCalculator.MortgageCalculator.logic.Request;
import MortgageCalculator.MortgageCalculator.logic.RequestBuilder;

public class ApplicationStarterDummy {

	public static void main(String[] args) {
		RatyMalejace rm = new RatyMalejace();
		
		Request request = RequestBuilder.with()//
				.kwota(240000)//
				.okres(12*15)//
				.marza(2)//
				.wibor(2.57)//
				.prowizja(1)//
				.nadplata(6000)//
				.opoznienieNadplaty(24)//
				.czestotliwoscNadplat(CzestotliwoscNadplat.HALFYEAR)//
				.build();
		
		rm.calculate(request);
	}
}
