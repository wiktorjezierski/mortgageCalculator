package MortgageCalculator.MortgageCalculator.logic;

import org.springframework.stereotype.Service;

@Service
public class RatyMalejace {

	/**
	 * Okres w miesiacach
	 * @see MortgageCalculator.MortgageCalculator.logic.Raty#calculate(int, int, double, double)
	 */
	public void calculate(double kwota, double okres, double oprocentowanie, double prowizja, double nadplata,
			int opoznienieNadplaty, CzestotliwoscNadplat czestotliwoscNadplat) {
		double rataKapitalowa = kwota / okres;
		
		double odsetkiCalkowite = 0;
		
		for (int i = 0; i < (int)okres; i++) {
			double odsetki = oprocentowanie * kwota;
			odsetkiCalkowite += odsetki;
			
			if(i >= opoznienieNadplaty && i % czestotliwoscNadplat.getCzestotliwosc() == 0) {
				if(kwota - nadplata > 0)
					kwota -= nadplata;
				else {
					System.out.println(i + " " + kwota + " " + odsetki);
					break;
				}
			}
			
			if(kwota - rataKapitalowa < 0) {
				System.out.println(i + " " + kwota + " " + odsetki);
				break;
			}
			kwota -= rataKapitalowa;
			System.out.println(i + " " + rataKapitalowa + " " + odsetki);
		}
		
		System.out.println(kwota + " " + odsetkiCalkowite);
	}

}
