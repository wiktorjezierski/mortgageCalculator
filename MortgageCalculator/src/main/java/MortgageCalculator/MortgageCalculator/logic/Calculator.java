package MortgageCalculator.MortgageCalculator.logic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
	
	@Autowired
	private RatyRowne ratyRowne;
	
	@Autowired
	private RatyMalejace ratyMalejace;
	
	public List<Result> calculate(Request request) {
		return Arrays.asList(ratyMalejace.calculate(request), 
				ratyRowne.calculate(request));
	}
}
