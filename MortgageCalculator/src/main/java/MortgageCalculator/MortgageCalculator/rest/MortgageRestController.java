package MortgageCalculator.MortgageCalculator.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MortgageRestController {
	
	@GetMapping("/example")
	public boolean example() {
		return true;
	}

}
