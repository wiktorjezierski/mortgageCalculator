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
	public Result calculate(Request request) {
		double kwota = request.getKwota();
		double rataKapitalowa = kwota / (double)request.getOkres();
		
		double odsetkiCalkowite = 0;
		
		List<Rata> raty = new ArrayList<>();
		double oprocentowanie = request.getOprocentowanie();
		
		for (int i = 0; i < (int)request.getOkres(); i++) {
			double odsetki = request.getOprocentowanie(i, oprocentowanie) * kwota;
			odsetkiCalkowite += odsetki;
			
			if(i >= request.getOpoznienieNadplaty() && request.getCzestotliwoscNadplat() != null && i % request.getCzestotliwoscNadplat().getCzestotliwosc() == 0) {
				if(kwota - request.getNadplata() > 0)
					kwota -= request.getNadplata();
				else {
					raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
					System.out.println(i + " " + kwota + " " + odsetki + " " + (rataKapitalowa + odsetki));
					break;
				}
			}
			
			if(kwota - rataKapitalowa < 0) {
				raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
				System.out.println(i + " " + kwota + " " + odsetki + " " + (rataKapitalowa + odsetki));
				break;
			}
			kwota -= rataKapitalowa;
			raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
			System.out.println(i + " " + rataKapitalowa + " " + odsetki + " " + (rataKapitalowa + odsetki));
		}
		
		System.out.println(kwota + " " + odsetkiCalkowite);
		return new Result(raty, odsetkiCalkowite);
	}

}
