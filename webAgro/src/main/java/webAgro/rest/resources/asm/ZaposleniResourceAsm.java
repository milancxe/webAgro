package webAgro.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import webAgro.core.models.entities.Zaposleni;
import webAgro.rest.mvc.ZaposleniController;
import webAgro.rest.resources.ZaposleniResource;

public class ZaposleniResourceAsm extends ResourceAssemblerSupport<Zaposleni, ZaposleniResource> {

	public ZaposleniResourceAsm() {
		
		super(ZaposleniController.class, ZaposleniResource.class);

	}

	@Override
	public ZaposleniResource toResource(Zaposleni zaposleni) {
		
		ZaposleniResource res = new ZaposleniResource();
	//	res.setId(zaposleni.getId());
		res.setZid(zaposleni.getId());
		res.setIme(zaposleni.getIme());
	//	res.setObrade(zaposleni.getObrade());
	//	res.setParcele(zaposleni.getParcele());
		res.setPoljoprivrednoGazdinstvoId(zaposleni.getPoljoprivrednoGazdinstvo().getId());
		res.setPrezime(zaposleni.getPrezime());
		res.setSifra(zaposleni.getSifra());
        //res.add(linkTo(methodOn(LoginController.class).getAccount(zaposleni.getId())).withSelfRel());

		return res;
	}

}
