package MortgageCalculator.MortgageCalculator.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
	
	@Autowired
	private RatyRowne ratyRowne;
	
	@Autowired
	private RatyMalejace ratyMalejace;
	
	public Result calculate(Request request) {
		
		return ratyMalejace.calculate(request);
//		ratyRowne.calculate(kwota, okres, oprocentowanie, prowizja);
	}
}
