package webAgro.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import webAgro.core.models.entities.Lager;
import webAgro.rest.mvc.LagerController;
import webAgro.rest.mvc.ParceleController;
import webAgro.rest.resources.LagerResource;
import webAgro.rest.resources.ParcelaResource;

public class LagerResourceAsm extends ResourceAssemblerSupport<Lager, LagerResource>{

	public LagerResourceAsm(){
		super (LagerController.class, LagerResource.class);
	}
	
	@Override
	public LagerResource toResource(Lager lager) {

		LagerResource res = new LagerResource();
		res.setGodina(lager.getGodina());
		res.setLid(lager.getId());
		res.setKolicina(lager.getKolicina());
		res.setKultura(lager.getKultura());
		return res;
	}

}
