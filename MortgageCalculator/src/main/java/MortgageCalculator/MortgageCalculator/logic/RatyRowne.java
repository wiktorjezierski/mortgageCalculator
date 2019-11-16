package MortgageCalculator.MortgageCalculator.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RatyRowne {

	public Result calculate(Request request) {
		double rataBazowa = calculateRate(request.getKwota(), request);
		System.out.println("base rate " + rataBazowa);
		double kwota = request.getKwota();
		double odsetkiCalkowite = 0;
		
		List<Rata> raty = new ArrayList<>();
		double oprocentowanie = request.getOprocentowanie();
		
		for (int i = 0; i < request.getOkres() && kwota > 0; i++) {
			oprocentowanie = request.getOprocentowanie(i, oprocentowanie);
			
			double odsetki = oprocentowanie * kwota;
			odsetkiCalkowite += odsetki;
			
			double rataKapitalowa = rataBazowa - odsetki;
			if(kwota - rataKapitalowa <= 0) {
				rataKapitalowa = kwota;
			}
			kwota -= rataKapitalowa;
			
			if(isOverpaymentAllowed(request, i)) {
				if(kwota - request.getNadplata() > 0) {
					kwota -= request.getNadplata();
					
					if(request.getKindOfOverpayment() == KindOfOverpayment.INSTALLMENT) {
						rataBazowa = calculateRate(kwota, request);
					}
				}
				else {
					kwota = 0;
					raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
					System.out.println(i + " " + kwota + " " + odsetki);
					break;
				}
			}
			
			raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
			System.out.println(i + " " + rataKapitalowa + " " + odsetki + " " + rataBazowa);
		}
		
		System.out.println(kwota + " " + odsetkiCalkowite);
		return new Result(raty, odsetkiCalkowite);
	}

	private boolean isOverpaymentAllowed(Request request, int i) {
		return i >= request.getOpoznienieNadplaty() && request.getCzestotliwoscNadplat() != null
				&& i % request.getCzestotliwoscNadplat().getCzestotliwosc() == 0;
	}

	private double calculateRate(double kwota, Request request) {
		double sum = 0;
		for(int i = 1; i <= request.getOkres(); i++) {
			sum += Math.pow((1 + request.getOprocentowanie()), i * (-1));
		}
		
		return kwota / sum;
	}

}
