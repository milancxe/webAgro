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

import webAgro.core.models.entities.PrikljucnaMasina;
import webAgro.core.models.entities.Vozilo;
import webAgro.core.services.MasinaService;
import webAgro.rest.resources.MasinaResource;
import webAgro.rest.resources.VoziloResource;
import webAgro.rest.resources.asm.MasinaResourceAsm;
import webAgro.rest.resources.asm.VoziloResourceAsm;

@Controller
@RequestMapping("/app")
public class MasinaController {
	
	@Autowired
	MasinaService masinaService;
	
	
	@RequestMapping(value="/{gazdinstvoId}/masina",method = RequestMethod.POST)
    public @ResponseBody Object createMasina(@PathVariable Long gazdinstvoId,@RequestBody MasinaResource masina){
		
		
		PrikljucnaMasina prikljucnaMasina = masina.toPrikljucnaMasina();
		masinaService.createMasina(gazdinstvoId, prikljucnaMasina);

		return true;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/masina",method = RequestMethod.GET)
    public @ResponseBody List<MasinaResource> getAll(@PathVariable Long gazdinstvoId){
		
		List<PrikljucnaMasina> masine = masinaService.getAll(gazdinstvoId);
		List<MasinaResource> rezultat = new ArrayList<>();
		for(PrikljucnaMasina p:masine){

			rezultat.add(new MasinaResourceAsm().toResource(p));
		}
		return rezultat;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/masina/{mhzId}",method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteVozilo(@PathVariable Long gazdinstvoId,@PathVariable Long mhzId){
		
		
		if(masinaService.deleteMasina(mhzId)){
			return true;
		}

		return false;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/masina/{mhzId}",method = RequestMethod.PUT)
    public @ResponseBody MasinaResource editMasina(@PathVariable Long gazdinstvoId, @PathVariable Long mhzId,@RequestBody MasinaResource masina){
		
		/*Parcela editovana = parcelaService.updateParcela(parcela.toParcela());
		return new ParcelaResourceAsm().toResource(editovana);*/
		//stize dobar objekat, ne valja prikaz na klijentu, treba odraditi ostale metode
		
		PrikljucnaMasina nova = masinaService.updateMasina(masina.toPrikljucnaMasina());
		MasinaResource updejtovana = new MasinaResourceAsm().toResource(nova);

		return updejtovana;
	}
	@RequestMapping(value="/{gazdinstvoId}/masina/{mhzId}",method = RequestMethod.GET)
    public @ResponseBody MasinaResource getMasina(@PathVariable Long gazdinstvoId, @PathVariable Long mhzId){
		
		PrikljucnaMasina trazena = masinaService.findMasinaById(mhzId);
		return new MasinaResourceAsm().toResource(trazena);
	}

}
