package webAgro.rest.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import webAgro.core.models.entities.Obrada;
import webAgro.core.models.entities.Parcela;
import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;

public class ZaposleniResource extends ResourceSupport {
	
	private Long zid;
	private String ime;
	private String prezime;
	private String sifra;

	private List<Obrada> obrade;
	
	private List<Parcela> parcele;
	
	private Long poljoprivrednoGazdinstvoId;



	/*public Long getZid() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/
	

	public String getIme() {
		return ime;
	}

	public Long getZid() {
		return zid;
	}

	public void setZid(Long zid) {
		this.zid = zid;
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

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
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

	public Long getPoljoprivrednoGazdinstvoId() {
		return poljoprivrednoGazdinstvoId;
	}

	public void setPoljoprivrednoGazdinstvoId(Long poljoprivrednoGazdinstvoId) {
		this.poljoprivrednoGazdinstvoId = poljoprivrednoGazdinstvoId;
	}


	
	
}
