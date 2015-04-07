package webAgro.core.models.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Parcela")
public class Parcela {
	
	@Id
	@Column(name="parcelniBroj")
	private Long parcelniBroj;
	private String vlasnik;
	private String potez;
	private int kategorija;
	
	@OneToMany(mappedBy="parcela")
	private Set<Njiva> njiva;

	@ManyToOne
	@JoinColumn(name="polj_gazd_id")
	private PoljoprivrednoGazdinstvo poljoprivrednoGazdinstvo;
	
	
	public PoljoprivrednoGazdinstvo getPoljoprivrednoGazdinstvo() {
		return poljoprivrednoGazdinstvo;
	}
	public void setPoljoprivrednoGazdinstvo(
			PoljoprivrednoGazdinstvo poljoprivrednoGazdinstvo) {
		this.poljoprivrednoGazdinstvo = poljoprivrednoGazdinstvo;
	}
	
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
	public Set<Njiva> getNjiva() {
		return njiva;
	}
	public void setNjiva(Set<Njiva> njiva) {
		this.njiva = njiva;
	}
	
	
}
