package webAgro.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import webAgro.core.models.entities.PrikljucnaMasina;

public class MasinaResource extends ResourceSupport{
	
	public Long mhzId;
	public int godiste;
	public String tip;
	public String napomena;
	
	public Long getMhzId() {
		return mhzId;
	}
	public void setMhzId(Long mhzId) {
		this.mhzId = mhzId;
	}
	public int getGodiste() {
		return godiste;
	}
	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	public PrikljucnaMasina toPrikljucnaMasina(){
		PrikljucnaMasina p = new PrikljucnaMasina();
		p.setGodiste(godiste);
		p.setMhzId(mhzId);
		p.setNapomena(napomena);
		p.setTip(tip);
		return p;
	}
	
	

}
