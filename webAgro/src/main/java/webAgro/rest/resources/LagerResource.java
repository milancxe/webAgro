package webAgro.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;

import webAgro.core.models.entities.Lager;
import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;
import webAgro.core.services.PoljoprivrednoGazdinstvoService;

public class LagerResource extends ResourceSupport{
	
	@Autowired
	PoljoprivrednoGazdinstvoService poljoprivrednoGazdinstvoService;
	
    private Long lid;
	private String kultura;
	private int godina;
	private int kolicina;
	private Long poljoprivrednoGazdinstvoId;
	
	
	public Long getLid() {
		return lid;
	}
	public void setLid(Long lid) {
		this.lid = lid;
	}
	public String getKultura() {
		return kultura;
	}
	public void setKultura(String kultura) {
		this.kultura = kultura;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	
	public Lager toLager(){
		Lager l= new Lager();
		l.setGodina(godina);
		l.setId(lid);
		l.setKolicina(kolicina);
		l.setKultura(kultura);

		
		return l;
	}

}
