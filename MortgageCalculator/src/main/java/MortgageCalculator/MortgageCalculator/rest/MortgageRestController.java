package MortgageCalculator.MortgageCalculator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import MortgageCalculator.MortgageCalculator.logic.Calculator;
import MortgageCalculator.MortgageCalculator.logic.CzestotliwoscNadplat;
import MortgageCalculator.MortgageCalculator.logic.Result;

@RestController
public class MortgageRestController {
	
	@Autowired
	private Calculator calculator;
	
	@GetMapping("/calculate")
	public Result calculate(@RequestParam double kwota, @RequestParam double okres,
			@RequestParam double marza, @RequestParam double wibor, @RequestParam double prowizja, @RequestParam double nadplata,
			@RequestParam int opoznienieNadplaty, @RequestParam CzestotliwoscNadplat czestotliwoscNadplat) {
		
		return calculator.calculate(kwota, okres, marza + wibor, prowizja, nadplata, opoznienieNadplaty, czestotliwoscNadplat);
	}
	
	@GetMapping("/calculate2")
	public Result calculate(@RequestParam double kwota, @RequestParam double okres,
			@RequestParam double marza, @RequestParam double wibor, @RequestParam double prowizja) {
		
		return calculator.calculate(kwota, okres, marza + wibor, prowizja, 0, 0, null);
	}
}
