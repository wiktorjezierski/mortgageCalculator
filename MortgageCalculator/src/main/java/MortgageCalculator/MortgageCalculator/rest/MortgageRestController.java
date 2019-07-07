package MortgageCalculator.MortgageCalculator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import MortgageCalculator.MortgageCalculator.logic.Calculator;
import MortgageCalculator.MortgageCalculator.logic.CzestotliwoscNadplat;
import MortgageCalculator.MortgageCalculator.logic.Request;
import MortgageCalculator.MortgageCalculator.logic.RequestBuilder;
import MortgageCalculator.MortgageCalculator.logic.Result;

@RestController
public class MortgageRestController {
	
	@Autowired
	private Calculator calculator;
	
	@GetMapping("/calculate")
	public List<Result> calculate(@RequestParam double kwota, @RequestParam int okres,
			@RequestParam double marza, @RequestParam double wibor, @RequestParam double prowizja, @RequestParam double nadplata,
			@RequestParam int opoznienieNadplaty, @RequestParam CzestotliwoscNadplat czestotliwoscNadplat) {
		
		Request request = RequestBuilder.with()//
				.kwota(kwota)//
				.okres(okres)//
				.marza(marza)//
				.wibor(wibor)//
				.prowizja(prowizja)//
				.nadplata(nadplata)//
				.opoznienieNadplaty(opoznienieNadplaty)//
				.czestotliwoscNadplat(czestotliwoscNadplat)//
				.build();
		
		return calculator.calculate(request);
	}
	
	@GetMapping("/calculate2")
	public List<Result> calculate(@RequestParam double kwota, @RequestParam int okres,
			@RequestParam double marza, @RequestParam double wibor, @RequestParam double prowizja) {
		
		Request request = RequestBuilder.with()//
				.kwota(kwota)//
				.okres(okres)//
				.marza(marza)//
				.wibor(wibor)//
				.prowizja(prowizja)//
				.build();
		
		return calculator.calculate(request);
	}
}
