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
		List<Double> installments = calculateInstallmentWithoutOverpayment(request);
		double kwota = request.getKwota();
		double rataKapitalowa = kwota / (double)request.getOkres();
		double nextRataKapitalowa = rataKapitalowa;
		
		double odsetkiCalkowite = 0;
		double sumaNadplat = 0;
		
		List<Rata> raty = new ArrayList<>();
		double oprocentowanie = request.getOprocentowanie();
		
		for (int i = 0; i < request.getOkres(); i++) {
			double odsetki = request.getOprocentowanie(i, oprocentowanie) * kwota;
			odsetkiCalkowite += odsetki;
			
			if (isOverpaymentAllowed(request, i)) {
				
				if(kwota - request.getNadplata() > 0) {
					kwota -= request.getNadplata();
					sumaNadplat += request.getNadplata();
					
					if(request.getKindOfOverpayment() == KindOfOverpayment.TIME) {
						double tempKwota = kwota - rataKapitalowa;
						double tempOdsetki = request.getOprocentowanie(i, oprocentowanie) * tempKwota;
						nextRataKapitalowa = installments.get(i + 1) - tempOdsetki;
					}
				}
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
			System.out.println(i + " " + rataKapitalowa + " " + odsetki + " " + (rataKapitalowa + odsetki) +" "+ kwota);
			rataKapitalowa = nextRataKapitalowa;
		}
		
		System.out.println(kwota + " " + odsetkiCalkowite);
		return new Result(raty, odsetkiCalkowite, request.getKwota(), request.getAmountOfCommission(), sumaNadplat);
	}
	
	private List<Double> calculateInstallmentWithoutOverpayment(Request request) {
		List<Double> result = new ArrayList<>();

		double kwota = request.getKwota();
		double rataKapitalowa = kwota / (double)request.getOkres();
		
		double oprocentowanie = request.getOprocentowanie();
		
		for (int i = 0; i < request.getOkres(); i++) {
			double odsetki = request.getOprocentowanie(i, oprocentowanie) * kwota;
			if(kwota - rataKapitalowa < 0) {
				result.add(rataKapitalowa + odsetki);
				break;
			}
			kwota -= rataKapitalowa;
			result.add(rataKapitalowa + odsetki);
		}
		
		return result;
	}

	private boolean isOverpaymentAllowed(Request request, int i) {
		return i >= request.getOpoznienieNadplaty() && request.getCzestotliwoscNadplat() != null
				&& i % request.getCzestotliwoscNadplat().getCzestotliwosc() == 0;
	}

}
