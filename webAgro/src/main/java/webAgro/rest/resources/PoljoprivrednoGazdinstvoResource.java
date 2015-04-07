package webAgro.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;

public class PoljoprivrednoGazdinstvoResource extends ResourceSupport{
	
	private Long brojGazdinstva;
	private String vlasnikIme;
	private String vlasnikPrezime;
	private String sifra;
	
	public Long getBrojGazdinstva() {
		return brojGazdinstva;
	}
	public void setBrojGazdinstva(Long brojGazdinstva) {
		this.brojGazdinstva = brojGazdinstva;
	}
	public String getVlasnikIme() {
		return vlasnikIme;
	}
	public void setVlasnikIme(String vlasnikIme) {
		this.vlasnikIme = vlasnikIme;
	}
	public String getVlasnikPrezime() {
		return vlasnikPrezime;
	}
	public void setVlasnikPrezime(String vlasnikPrezime) {
		this.vlasnikPrezime = vlasnikPrezime;
	}
	
	public PoljoprivrednoGazdinstvo toPoljoprivrednoGazdinstvo(){
		PoljoprivrednoGazdinstvo novoGazd = new PoljoprivrednoGazdinstvo();
		return null;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	
	

}
