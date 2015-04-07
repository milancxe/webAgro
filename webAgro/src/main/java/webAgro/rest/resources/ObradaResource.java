package webAgro.rest.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import webAgro.core.models.entities.Njiva;
import webAgro.core.models.entities.PrikljucnaMasina;
import webAgro.core.models.entities.Vozilo;
import webAgro.core.models.entities.Zaposleni;

public class ObradaResource  extends ResourceSupport{
	
	private Long obradaId;
	private String vrstaObrade;
	private String napomena;
	private String datum;
	
	private List<Vozilo> vozila;
	
	private List<PrikljucnaMasina> prikljucneMasine;
	
	private List<Zaposleni> zaposleni;
	
	private List<Njiva> njive;

	public Long getObradaId() {
		return obradaId;
	}

	public void setObradaId(Long obradaId) {
		this.obradaId = obradaId;
	}

	public String getVrstaObrade() {
		return vrstaObrade;
	}

	public void setVrstaObrade(String vrstaObrade) {
		this.vrstaObrade = vrstaObrade;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public List<Vozilo> getVozila() {
		return vozila;
	}

	public void setVozila(List<Vozilo> vozila) {
		this.vozila = vozila;
	}

	public List<PrikljucnaMasina> getPrikljucneMasine() {
		return prikljucneMasine;
	}

	public void setPrikljucneMasine(List<PrikljucnaMasina> prikljucneMasine) {
		this.prikljucneMasine = prikljucneMasine;
	}

	public List<Zaposleni> getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(List<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	public List<Njiva> getNjive() {
		return njive;
	}

	public void setNjive(List<Njiva> njive) {
		this.njive = njive;
	}
	
	

}
