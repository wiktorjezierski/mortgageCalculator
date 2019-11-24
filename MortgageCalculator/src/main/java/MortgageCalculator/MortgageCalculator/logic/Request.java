package MortgageCalculator.MortgageCalculator.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Request {

	private double kwota;
	private int okres;
	private double marza;
	private double wibor;
	private double commission;
	private double nadplata;
	private KindOfOverpayment kindOfOverpayment;
	private int opoznienieNadplaty;
	private CzestotliwoscNadplat czestotliwoscNadplat;
	private Map<Integer, Double> zmianaMarzy;
	private Map<Integer, Double> zmianaWiboru;
	
	public Request() {
		zmianaMarzy = new HashMap<>();
		zmianaWiboru = new HashMap<>();
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public int getOkres() {
		return okres;
	}

	public void setOkres(int okres) {
		this.okres = okres;
	}

	public double getMarza() {
		return marza;
	}

	public void setMarza(double marza) {
		this.marza = marza;
	}

	public double getWibor() {
		return wibor;
	}

	public void setWibor(double wibor) {
		this.wibor = wibor;
	}

	public double getCommission() {
		return commission;
	}
	
	public double getAmountOfCommission() {
		return (commission / 100) * kwota;
	}


	public void setProwizja(double prowizja) {
		this.commission = prowizja;
	}

	public double getNadplata() {
		return nadplata;
	}

	public void setNadplata(double nadplata) {
		this.nadplata = nadplata;
	}
	
	public KindOfOverpayment getKindOfOverpayment() {
		return kindOfOverpayment;
	}
	
	public void setKindOfOverpayment(KindOfOverpayment kindOfOverpayment) {
		this.kindOfOverpayment = kindOfOverpayment;
	}

	public int getOpoznienieNadplaty() {
		return opoznienieNadplaty;
	}

	public void setOpoznienieNadplaty(int opoznienieNadplaty) {
		this.opoznienieNadplaty = opoznienieNadplaty;
	}

	public CzestotliwoscNadplat getCzestotliwoscNadplat() {
		return czestotliwoscNadplat;
	}

	public void setCzestotliwoscNadplat(CzestotliwoscNadplat czestotliwoscNadplat) {
		this.czestotliwoscNadplat = czestotliwoscNadplat;
	}

	public Map<Integer, Double> getZmianaMarzy() {
		return zmianaMarzy;
	}

	public void setZmianaMarzy(Map<Integer, Double> zmianaMarzy) {
		this.zmianaMarzy = zmianaMarzy;
	}

	public Map<Integer, Double> getZmianaWiboru() {
		return zmianaWiboru;
	}

	public void setZmianaWiboru(Map<Integer, Double> zmianaWiboru) {
		this.zmianaWiboru = zmianaWiboru;
	}

	public double getOprocentowanie() {
		return (marza + wibor) / (100.0 * 12.0);
	}

	public double getOprocentowanie(int rata, double obecneOprocentowanie) {
		Double nowaMarza = zmianaMarzy.get(rata);
		Double nowyWibor = zmianaWiboru.get(rata);

		if (nowaMarza == null && nowyWibor == null) {
			return obecneOprocentowanie;
		}

		if (nowaMarza == null) {
			nowaMarza = findValidValue(rata, zmianaMarzy, marza);
		}

		if (nowyWibor == null) {
			nowyWibor = findValidValue(rata, zmianaWiboru, wibor);
		}

		return (nowaMarza + nowyWibor) / (100 * 12);
	}
	
	private double findValidValue(int range, Map<Integer, Double> values, double defaultValue) {
		int lastKey = 0;
		for (Entry<Integer, Double> entry : values.entrySet()) {
			if(entry.getKey() < range) {
				lastKey = entry.getKey();
			}
			else {
				return values.get(lastKey);
			}
		}
		
		return defaultValue;
	}
}
