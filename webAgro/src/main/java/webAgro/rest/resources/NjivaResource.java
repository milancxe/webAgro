package webAgro.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import webAgro.core.models.entities.Njiva;
import webAgro.core.models.entities.Parcela;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class NjivaResource extends ResourceSupport{
	
	private Long njivaId;
	private String kultura;
	private int sezona;
	private int prinos;
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
	private Parcela parcela;
	public Long getNjivaId() {
		return njivaId;
	}
	public void setNjivaId(Long njivaId) {
		this.njivaId = njivaId;
	}
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
	public Parcela getParcela() {
		return parcela;
	}
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	
	public Njiva toNjiva(){
		Njiva n = new Njiva();
		n.setKultura(kultura);
		n.setNjivaId(njivaId);
		n.setParcela(parcela);
		n.setPrinos(prinos);
		n.setSezona(sezona);
		return n;
	}
	

}
