package webAgro.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import webAgro.core.models.entities.Njiva;
import webAgro.core.models.entities.Parcela;
import webAgro.rest.mvc.NjiveController;
import webAgro.rest.mvc.ParceleController;
import webAgro.rest.resources.NjivaResource;

public class NjivaResourceAsm extends ResourceAssemblerSupport<Njiva, NjivaResource>{

	public NjivaResourceAsm(){
		super (NjiveController.class,NjivaResource.class);
	}
	
	@Override
	public NjivaResource toResource(Njiva njiva) {

		NjivaResource res =  new NjivaResource();
		res.setKultura(njiva.getKultura());
		res.setNjivaId(njiva.getNjivaId());
		res.setPrinos(njiva.getPrinos());
		res.setSezona(njiva.getSezona());
		//app/{gazdid}/parcele/{idParcele}
		res.add(linkTo(ParceleController.class).slash(njiva.getParcela().getPoljoprivrednoGazdinstvo().getId()).slash("parcele").slash(njiva.getParcela().getParcelniBroj()).withRel(njiva.getParcela().getPotez()));
		return res;
	}
	

}
