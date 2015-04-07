package webAgro.core.models.entities;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Njiva")
public class Njiva{

	@Id
	@GeneratedValue
	@Column(name="njivaId")
	private Long njivaId;
	
	private String kultura;
	private int sezona;
	private int prinos;
	
	@ManyToOne
	@JoinColumn(name="parcelniBroj")
	private Parcela parcela;
	
	
	@ManyToMany(mappedBy="njive")
	private List<Obrada> obrade;
	
	public String getKultura() {
		return kultura;
	}
	public void setKultura(String kultura) {
		this.kultura = kultura;
	}
	public int getSezona() {
		return sezona;
	}
	public void setSezona(int sezona) {
		this.sezona = sezona;
	}
	public int getPrinos() {
		return prinos;
	}
	public void setPrinos(int prinos) {
		this.prinos = prinos;
	}
	public List<Obrada> getObrade() {
		return obrade;
	}
	public void setObrade(List<Obrada> obrade) {
		this.obrade = obrade;
	}
	public Parcela getParcela() {
		return parcela;
	}
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	public Long getNjivaId() {
		return njivaId;
	}
	public void setNjivaId(Long njivaId) {
		this.njivaId = njivaId;
	}
	
	
	
}
