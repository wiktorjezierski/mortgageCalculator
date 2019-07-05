package MortgageCalculator.MortgageCalculator.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
	
	@Autowired
	private RatyRowne ratyRowne;
	
	@Autowired
	private RatyMalejace ratyMalejace;
	
	public Result calculate(double kwota, double okres, double oprocentowanie, double prowizja, double nadplata,
			int opoznienieNadplaty, CzestotliwoscNadplat czestotliwoscNadplat) {
		oprocentowanie = oprocentowanie / (100*12);
		
		return ratyMalejace.calculate(kwota, okres, oprocentowanie, prowizja, nadplata, opoznienieNadplaty, czestotliwoscNadplat);
//		ratyRowne.calculate(kwota, okres, oprocentowanie, prowizja);
	}
}
