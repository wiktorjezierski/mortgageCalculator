package MortgageCalculator.MortgageCalculator.logic;

public class Request {

	private double kwota;
	private double okres;
	private double marza;
	private double wibor;
	private double prowizja;
	private double nadplata;
	private int opoznienieNadplaty;
	private CzestotliwoscNadplat czestotliwoscNadplat;

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public double getOkres() {
		return okres;
	}

	public void setOkres(double okres) {
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

	public double getProwizja() {
		return prowizja;
	}

	public void setProwizja(double prowizja) {
		this.prowizja = prowizja;
	}

	public double getNadplata() {
		return nadplata;
	}

	public void setNadplata(double nadplata) {
		this.nadplata = nadplata;
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

	public double getOprocentowanie() {
		return (marza + wibor) / (100.0 * 12.0);
	}
}
