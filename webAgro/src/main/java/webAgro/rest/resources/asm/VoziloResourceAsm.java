package webAgro.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import webAgro.core.models.entities.Vozilo;
import webAgro.rest.mvc.VoziloController;
import webAgro.rest.resources.VoziloResource;

public class VoziloResourceAsm extends ResourceAssemblerSupport<Vozilo, VoziloResource>{
	
	public VoziloResourceAsm(){
		super (VoziloController.class, VoziloResource.class);
	}

	@Override
	public VoziloResource toResource(Vozilo vozilo) {

		VoziloResource res = new VoziloResource();
		res.setGodiste(vozilo.getGodiste());
		res.setMhzId(vozilo.getMhzId());
		res.setNapomena(vozilo.getNapomena());
		res.setTip(vozilo.getTip());
		
		return res;
	}

}
