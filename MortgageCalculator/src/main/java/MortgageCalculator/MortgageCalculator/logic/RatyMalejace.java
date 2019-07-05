package MortgageCalculator.MortgageCalculator.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RatyMalejace {

	/**
	 * Okres w miesiacach
	 * @see MortgageCalculator.MortgageCalculator.logic.Raty#calculate(int, int, double, double)
	 */
	public Result calculate(double kwota, double okres, double oprocentowanie, double prowizja, double nadplata,
			int opoznienieNadplaty, CzestotliwoscNadplat czestotliwoscNadplat) {
		double rataKapitalowa = kwota / okres;
		
		double odsetkiCalkowite = 0;
		
		List<Rata> raty = new ArrayList<>();
		
		for (int i = 0; i < (int)okres; i++) {
			double odsetki = oprocentowanie * kwota;
			odsetkiCalkowite += odsetki;
			
			if(i >= opoznienieNadplaty && czestotliwoscNadplat != null && i % czestotliwoscNadplat.getCzestotliwosc() == 0) {
				if(kwota - nadplata > 0)
					kwota -= nadplata;
				else {
					raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
					System.out.println(i + " " + kwota + " " + odsetki);
					break;
				}
			}
			
			if(kwota - rataKapitalowa < 0) {
				raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
				System.out.println(i + " " + kwota + " " + odsetki);
				break;
			}
			kwota -= rataKapitalowa;
			raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
			System.out.println(i + " " + rataKapitalowa + " " + odsetki);
		}
		
		System.out.println(kwota + " " + odsetkiCalkowite);
		return new Result(raty, odsetkiCalkowite);
	}

}
