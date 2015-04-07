package webAgro.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import webAgro.core.models.entities.PrikljucnaMasina;
import webAgro.rest.mvc.MasinaController;
import webAgro.rest.resources.MasinaResource;

public class MasinaResourceAsm extends ResourceAssemblerSupport<PrikljucnaMasina, MasinaResource>{

	public MasinaResourceAsm(){
		super (MasinaController.class, MasinaResource.class);
	}
	
	@Override
	public MasinaResource toResource(PrikljucnaMasina masina) {

		MasinaResource res = new MasinaResource();
		res.setGodiste(masina.getGodiste());
		res.setMhzId(masina.getMhzId());
		res.setNapomena(masina.getNapomena());
		res.setTip(masina.getTip());
		
		return res;
	}

}
