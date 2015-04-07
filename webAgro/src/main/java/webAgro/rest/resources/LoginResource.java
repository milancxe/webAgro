package webAgro.rest.resources;

import org.springframework.hateoas.ResourceSupport;

public class LoginResource extends ResourceSupport {
	
	private Long brojGazdinstva;
	private String sifra;
	
	
	public Long getBrojGazdinstva() {
		return brojGazdinstva;
	}
	public void setBrojGazdinstva(Long brojGazdinstva) {
		this.brojGazdinstva = brojGazdinstva;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	
	

}
