package webAgro.rest.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import webAgro.core.models.entities.Vozilo;
import webAgro.core.services.VoziloService;
import webAgro.rest.resources.VoziloResource;
import webAgro.rest.resources.asm.VoziloResourceAsm;

@Controller
@RequestMapping("/app")
public class VoziloController {
	
	@Autowired
	VoziloService voziloService;
	
	@RequestMapping(value="/{gazdinstvoId}/vozilo",method = RequestMethod.POST)
    public @ResponseBody Object createVozilo(@PathVariable Long gazdinstvoId,@RequestBody VoziloResource vozilo){
		
		Vozilo v = vozilo.toVozilo();
		System.out.println(v.getGodiste());
		System.out.println(v.getNapomena());
		System.out.println(v.getTip());
		
		voziloService.createVozilo(gazdinstvoId, v);

		return true;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/vozilo",method = RequestMethod.GET)
    public @ResponseBody List<VoziloResource> getAll(@PathVariable Long gazdinstvoId){
		
		List<Vozilo> vozila = voziloService.getAll(gazdinstvoId);
		List<VoziloResource> rezultat = new ArrayList<>();
		for(Vozilo v:vozila){
			System.out.println(v.getGodiste());
			System.out.println(v.getNapomena());
			System.out.println(v.getMhzId());
			System.out.println(v.getTip());
			rezultat.add(new VoziloResourceAsm().toResource(v));
		}
		return rezultat;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/vozilo/{mhzId}",method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteVozilo(@PathVariable Long gazdinstvoId,@PathVariable Long mhzId){
		
		System.out.println("spicio mi brisanje lager");
		System.out.println("id je: "+mhzId);
		
		if(voziloService.deleteVozilo(mhzId)){
			return true;
		}

		return false;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/vozilo/{mhzId}",method = RequestMethod.PUT)
    public @ResponseBody VoziloResource editVozilo(@PathVariable Long gazdinstvoId, @PathVariable Long mhzId,@RequestBody VoziloResource vozilo){
		
		/*Parcela editovana = parcelaService.updateParcela(parcela.toParcela());
		return new ParcelaResourceAsm().toResource(editovana);*/
		//stize dobar objekat, ne valja prikaz na klijentu, treba odraditi ostale metode
		
		Vozilo novo = voziloService.updateVozilo(vozilo.toVozilo());
		VoziloResource updejtovano = new VoziloResourceAsm().toResource(novo);

		return updejtovano;
	}

	@RequestMapping(value="/{gazdinstvoId}/vozilo/{mhzId}",method = RequestMethod.GET)
	public @ResponseBody VoziloResource getVozilo(@PathVariable Long gazdinstvoId, @PathVariable Long mhzId){
		Vozilo trazeno = voziloService.findVoziloById(mhzId);
		return new VoziloResourceAsm().toResource(trazeno);
	}
}
