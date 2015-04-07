package webAgro.core.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Obrada {

	@Id
	@GeneratedValue
	@Column(name="obradaId")
	private Long id;
	private String vrstaObrade;
	private String napomena;
	private String datum;
	

	@ManyToMany
	@JoinTable(name="obrada_voziloDT",
			joinColumns=@JoinColumn(name="obrada_id",referencedColumnName="obradaId"),
			inverseJoinColumns=@JoinColumn(name="vozilo_id", referencedColumnName="mhzId"))
	
	private List<Vozilo> vozila;
	
	
	@ManyToMany
	@JoinTable(name="obrada_prikljmasinaDT",
					joinColumns=@JoinColumn(name="obrada_id",referencedColumnName="obradaId"),
					inverseJoinColumns=@JoinColumn(name="priklj_masina_id", referencedColumnName="mhzId"))
	private List<PrikljucnaMasina> prikljucneMasine;
	
	@ManyToMany
	@JoinTable(name="obrada_zaposleniDT",
					joinColumns=@JoinColumn(name="obrada_id",referencedColumnName="obradaId"),
					inverseJoinColumns=@JoinColumn(name="zaposleni_id", referencedColumnName="zapId"))
	private List<Zaposleni> zaposleni;
	
	@ManyToMany
	@JoinTable(name="obrada_njiveDT",
					joinColumns=@JoinColumn(name="obrada_id",referencedColumnName="obradaId"),
					inverseJoinColumns=@JoinColumn(name="njiva_id", referencedColumnName="njivaId"))
	private List<Njiva> njive;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Njiva> getNjive() {
		return njive;
	}
	public void setNjive(List<Njiva> njive) {
		this.njive = njive;
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
/*	public List<Obrada> getNjive() {
		return njive;
	}
	public void setNjive(List<Obrada> njive) {
		this.njive = njive;
	}*/
	
}
