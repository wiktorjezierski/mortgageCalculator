package MortgageCalculator.MortgageCalculator.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
	
	@Autowired
	private RatyRowne ratyRowne;
	
	@Autowired
	private RatyMalejace ratyMalejace;
	
	public void calculate(double kwota, double okres, TypRaty typRat, double oprocentowanie, double prowizja) {
		ratyMalejace.calculate(kwota, okres, oprocentowanie, prowizja, 0, 0, CzestotliwoscNadplat.MONTHLY);
		ratyRowne.calculate(kwota, okres, oprocentowanie, prowizja);
	}
}
