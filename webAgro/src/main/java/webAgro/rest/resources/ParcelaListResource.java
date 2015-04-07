package webAgro.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class ParcelaListResource extends ResourceSupport {
	
	private List<ParcelaResource> parcele = new ArrayList<ParcelaResource>();

	public List<ParcelaResource> getParcele() {
		return parcele;
	}

	public void setParcele(List<ParcelaResource> parcele) {
		this.parcele = parcele;
	}
	
	

}
