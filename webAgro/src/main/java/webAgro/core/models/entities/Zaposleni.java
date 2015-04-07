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
import javax.persistence.ManyToOne;

@Entity
public class Zaposleni {

	@Id
	@GeneratedValue
	@Column(name="zapId")
	private Long id;
	private String ime;
	private String prezime;
	private String sifra;

	@ManyToMany(mappedBy="zaposleni",fetch=FetchType.EAGER)
	private List<Obrada> obrade;
	
	@ManyToMany
	@JoinTable(name="zaposleni_parceleDT",
					joinColumns=@JoinColumn(name="zaposleni_id", referencedColumnName="zapId"),
					inverseJoinColumns=@JoinColumn(name="parcela_id",referencedColumnName="parcelniBroj"))
	private List<Parcela> parcele;
	
	@ManyToOne
	@JoinColumn(name="polj_gazd_id")
	private PoljoprivrednoGazdinstvo poljoprivrednoGazdinstvo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public List<Obrada> getObrade() {
		return obrade;
	}
	public void setObrade(List<Obrada> obrade) {
		this.obrade = obrade;
	}
	public List<Parcela> getParcele() {
		return parcele;
	}
	public void setParcele(List<Parcela> parcele) {
		this.parcele = parcele;
	}
	public PoljoprivrednoGazdinstvo getPoljoprivrednoGazdinstvo() {
		return poljoprivrednoGazdinstvo;
	}
	public void setPoljoprivrednoGazdinstvo(
			PoljoprivrednoGazdinstvo poljoprivrednoGazdinstvo) {
		this.poljoprivrednoGazdinstvo = poljoprivrednoGazdinstvo;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	
	
}
