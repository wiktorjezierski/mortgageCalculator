package MortgageCalculator.MortgageCalculator.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RatyRowne {

	public Result calculate(Request request) {
		double rataBazowa = calculateRate(request);
		double kwota = request.getKwota();
		double odsetkiCalkowite = 0;
		
		List<Rata> raty = new ArrayList<>();
		
		for (int i = 0; i < (int)request.getOkres(); i++) {
			double odsetki = request.getOprocentowanie() * kwota;
			odsetkiCalkowite += odsetki;
			
			double rataKapitalowa = rataBazowa - odsetki;
			if(kwota - rataKapitalowa <= 0) {
				rataKapitalowa = kwota;
			}
			
			if(i >= request.getOpoznienieNadplaty() && request.getCzestotliwoscNadplat() != null && i % request.getCzestotliwoscNadplat().getCzestotliwosc() == 0) {
				if(kwota - request.getNadplata() > 0)
					kwota -= request.getNadplata();
				else {
					kwota = 0;
					raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
					System.out.println(i + " " + kwota + " " + odsetki);
					break;
				}
			}
			
			kwota -= rataKapitalowa;
			
			raty.add(new Rata(i, rataKapitalowa, odsetki, kwota));
			System.out.println(i + " " + rataKapitalowa + " " + odsetki + " " + rataBazowa);
			
			if(kwota == 0) {
				break;
			}
		}
		
		System.out.println(kwota + " " + odsetkiCalkowite);
		return new Result(raty, odsetkiCalkowite);
	}

	private double calculateRate(Request request) {
		double sum = 0;
		for(int i = 1; i <= request.getOkres(); i++) {
			sum += Math.pow((1 + request.getOprocentowanie()), i * (-1));
		}
		
		System.out.println(request.getKwota() / sum + " " + sum);
		return request.getKwota() / sum;
	}

}
