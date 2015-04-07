package webAgro.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import webAgro.core.models.entities.Parcela;
import webAgro.rest.mvc.ParceleController;
import webAgro.rest.resources.ParcelaResource;

public class ParcelaResourceAsm extends ResourceAssemblerSupport<Parcela, ParcelaResource>{
	
	public ParcelaResourceAsm(){
		super (ParceleController.class,ParcelaResource.class);
	}

	@Override
	public ParcelaResource toResource(Parcela parcela) {
		// TODO Auto-generated method stub
		ParcelaResource res = new ParcelaResource();
		res.setKategorija(parcela.getKategorija());
		res.setParcelniBroj(parcela.getParcelniBroj());
		res.setPotez(parcela.getPotez());
		res.setVlasnik(parcela.getVlasnik());
		return res;
	}
	

}
