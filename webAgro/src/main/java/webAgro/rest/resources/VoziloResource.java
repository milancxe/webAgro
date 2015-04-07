package webAgro.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import webAgro.core.models.entities.Vozilo;

public class VoziloResource extends ResourceSupport{
	
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
	
	public Vozilo toVozilo(){
		Vozilo v = new Vozilo();
		v.setGodiste(godiste);
		v.setNapomena(napomena);
		v.setTip(tip);
		v.setMhzId(mhzId);
		
		return v;
	}

}
