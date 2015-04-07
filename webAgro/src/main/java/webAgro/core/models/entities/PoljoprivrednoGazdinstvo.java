package webAgro.core.models.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="poljoprivrednoGazdinstvo")
public class PoljoprivrednoGazdinstvo {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="poljoprivrednoGazdinstvo")
	private Set<Parcela> parcele;
	
	@OneToMany(mappedBy="poljoprivrednoGazdinstvo")
	private Set<Lager> lager;
	
	@OneToMany(mappedBy="poljoprivrednoGazdinstvo")
	private Set<Mehanizacija> mehanizacije;
	
	@OneToMany(mappedBy="poljoprivrednoGazdinstvo")
	private Set<Zaposleni> zaposleni;
	
	
	public Set<Mehanizacija> getMehanizacije() {
		return mehanizacije;
	}
	public void setMehanizacije(Set<Mehanizacija> mehanizacije) {
		this.mehanizacije = mehanizacije;
	}
	public Set<Lager> getLager() {
		return lager;
	}
	public Set<Parcela> getParcele() {
		return parcele;
	}
	public void setParcele(Set<Parcela> parcele) {
		this.parcele = parcele;
	}
	public void setLager(Set<Lager> lager) {
		this.lager = lager;
	}

	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Zaposleni> getZaposleni() {
		return zaposleni;
	}
	public void setZaposleni(Set<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}
	public Set<Zaposleni> getVlasnik() {
		return zaposleni;
	}
	public void setVlasnik(Set<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	
}
