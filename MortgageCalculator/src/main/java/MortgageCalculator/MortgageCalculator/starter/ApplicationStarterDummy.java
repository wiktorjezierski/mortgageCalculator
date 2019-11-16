package MortgageCalculator.MortgageCalculator.starter;

import java.util.HashMap;
import java.util.Map;

import MortgageCalculator.MortgageCalculator.logic.CzestotliwoscNadplat;
import MortgageCalculator.MortgageCalculator.logic.KindOfOverpayment;
import MortgageCalculator.MortgageCalculator.logic.RatyMalejace;
import MortgageCalculator.MortgageCalculator.logic.RatyRowne;
import MortgageCalculator.MortgageCalculator.logic.Request;
import MortgageCalculator.MortgageCalculator.logic.RequestBuilder;

public class ApplicationStarterDummy {

	public static void main(String[] args) {
		RatyMalejace rm = new RatyMalejace();
		RatyRowne rr = new RatyRowne();
		
//		Map<Integer, Double> zmianaMarzy = Collections.singletonMap(61, 4.0);
		Map<Integer, Double> zmianaMarzy = new HashMap<>();
		
		
		Request request = RequestBuilder.with()//
				.kwota(242400)//
				.okres(15*12)//
				.marza(2)//
				.zmianaMarzy(zmianaMarzy)
				.wibor(1.7)//
				.prowizja(0)//
				.nadplata(1000)//
				.opoznienieNadplaty(12)//
				.czestotliwoscNadplat(CzestotliwoscNadplat.MONTHLY)//
				.kindOfOverpayment(KindOfOverpayment.TIME)//
				.build();
		
		rm.calculate(request);
//		rr.calculate(request);
	}
}
