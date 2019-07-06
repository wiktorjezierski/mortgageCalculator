package MortgageCalculator.MortgageCalculator.logic;

public class RequestBuilder {

	private Request request;
	
	private RequestBuilder() {}
	
	public static RequestBuilder with() {
		return new RequestBuilder();
	}

	public RequestBuilder kwota(double kwota) {
		request.setKwota(kwota);
		return this;
	}

	public RequestBuilder okres(double okres) {
		request.setOkres(okres);
		return this;
	}

	public RequestBuilder marza(double marza) {
		request.setMarza(marza);
		return this;
	}

	public RequestBuilder wibor(double wibor) {
		request.setWibor(wibor);
		return this;
	}

	public RequestBuilder prowizja(double prowizja) {
		request.setProwizja(prowizja);
		return this;
	}

	public RequestBuilder nadplata(double nadplata) {
		request.setNadplata(nadplata);
		return this;
	}

	public RequestBuilder opoznienieNadplaty(int opoznienieNadplaty) {
		request.setOpoznienieNadplaty(opoznienieNadplaty);
		return this;
	}

	public RequestBuilder czestotliwoscNadplat(CzestotliwoscNadplat czestotliwoscNadplat) {
		request.setCzestotliwoscNadplat(czestotliwoscNadplat);
		return this;
	}

	public Request build() {
		return request;
	}
}
