package MortgageCalculator.MortgageCalculator.starter;

import java.util.Collections;
import java.util.Map;

import MortgageCalculator.MortgageCalculator.logic.RatyMalejace;
import MortgageCalculator.MortgageCalculator.logic.RatyRowne;
import MortgageCalculator.MortgageCalculator.logic.Request;
import MortgageCalculator.MortgageCalculator.logic.RequestBuilder;

public class ApplicationStarterDummy {

	public static void main(String[] args) {
		RatyMalejace rm = new RatyMalejace();
		RatyRowne rr = new RatyRowne();
		
		Map<Integer, Double> zmianaMarzy = Collections.singletonMap(13, 1.88);
		
		
		Request request = RequestBuilder.with()//
				.kwota(240000)//
				.okres(16*12)//
				.marza(1.88)//
//				.zmianaMarzy(zmianaMarzy)
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
