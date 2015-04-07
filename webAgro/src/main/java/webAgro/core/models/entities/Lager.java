package webAgro.core.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lager")
public class Lager {
	
	@Id 
	@GeneratedValue
    private Long id;
	private String kultura;
	private int godina;
	private int kolicina;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	

}
