package webAgro.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import webAgro.core.models.entities.Parcela;

public class ParcelaResource extends ResourceSupport{
	
	private Long parcelniBroj;
	private String vlasnik;
	private String potez;
	private int kategorija;
	
	
	public Long getParcelniBroj() {
		return parcelniBroj;
	}
	public void setParcelniBroj(Long parcelniBroj) {
		this.parcelniBroj = parcelniBroj;
	}
	public String getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(String vlasnik) {
		this.vlasnik = vlasnik;
	}
	public String getPotez() {
		return potez;
	}
	public void setPotez(String potez) {
		this.potez = potez;
	}
	public int getKategorija() {
		return kategorija;
	}
	public void setKategorija(int kategorija) {
		this.kategorija = kategorija;
	}
	
	public Parcela toParcela(){
		Parcela novaParcela = new Parcela();
		novaParcela.setKategorija(kategorija);
		novaParcela.setParcelniBroj(parcelniBroj);
		novaParcela.setPotez(potez);
		novaParcela.setVlasnik(vlasnik);
		return novaParcela;
	}

}
