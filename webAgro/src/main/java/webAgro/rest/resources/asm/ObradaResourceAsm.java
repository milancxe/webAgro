package webAgro.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import webAgro.core.models.entities.Obrada;
import webAgro.rest.mvc.MasinaController;
import webAgro.rest.mvc.NjiveController;
import webAgro.rest.mvc.ObradaController;
import webAgro.rest.mvc.ParceleController;
import webAgro.rest.mvc.VoziloController;
import webAgro.rest.mvc.ZaposleniController;
import webAgro.rest.resources.ObradaResource;

public class ObradaResourceAsm extends ResourceAssemblerSupport<Obrada, ObradaResource> {

public ObradaResourceAsm() {
		
		super(ObradaController.class, ObradaResource.class);

	}
	
	@Override
	public ObradaResource toResource(Obrada obrada) {
		// TODO Auto-generated method stub
		
		ObradaResource res = new ObradaResource();
		res.setDatum(obrada.getDatum());
		res.setNapomena(obrada.getNapomena());
		res.setObradaId(obrada.getId());
		res.setVrstaObrade(obrada.getVrstaObrade());	
		
		Long gazdinstvoId=obrada.getZaposleni().get(0).getPoljoprivrednoGazdinstvo().getId();
		
		/*res.setPrikljucneMasine(obrada.getPrikljucneMasine());
		res.setVozila(obrada.getVozila());
		res.setZaposleni(obrada.getZaposleni());
		res.setNjive(obrada.getNjive());*/
		//app/{gazdid}/masina/{mhzId}
		res.add(linkTo(MasinaController.class).slash(gazdinstvoId).slash("masina").slash(obrada.getPrikljucneMasine().get(0).getMhzId()).withRel(obrada.getPrikljucneMasine().get(0).getTip()));
		//app/{gazdid}/vozilo/{mhzId}
		res.add(linkTo(VoziloController.class).slash(gazdinstvoId).slash("vozilo").slash(obrada.getVozila().get(0).getMhzId()).withRel(obrada.getVozila().get(0).getTip()));
		//app/{gazdid}/zaposleni/{zid}
		res.add(linkTo(ZaposleniController.class).slash(gazdinstvoId).slash("zaposleni").slash(obrada.getZaposleni().get(0).getId()).withRel(obrada.getZaposleni().get(0).getIme()+" "+obrada.getZaposleni().get(0).getPrezime()));
		//app/{gazdid}/njiva/{zid}
		res.add(linkTo(NjiveController.class).slash(gazdinstvoId).slash("njiva").slash(obrada.getNjive().get(0).getNjivaId()).withRel(obrada.getNjive().get(0).getParcela().getPotez()));

		
		return res;
	}
	

}
