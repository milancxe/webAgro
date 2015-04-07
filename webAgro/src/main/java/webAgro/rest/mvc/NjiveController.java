package webAgro.rest.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import webAgro.core.models.entities.Njiva;
import webAgro.core.models.entities.Parcela;
import webAgro.core.services.NjivaService;
import webAgro.rest.resources.NjivaResource;
import webAgro.rest.resources.ParcelaResource;
import webAgro.rest.resources.asm.NjivaResourceAsm;
import webAgro.rest.resources.asm.ParcelaResourceAsm;

@Controller
@RequestMapping("/app")
public class NjiveController {
	
	@Autowired
	NjivaService njiveService;
	
	@RequestMapping(value="/{gazdinstvoId}/njiva",method = RequestMethod.POST)
    public @ResponseBody Object createNjiva(@PathVariable Long gazdinstvoId,@RequestBody Map<String, String> fieldValues){
    	

    	String kultura =fieldValues.get("kultura");
    	int sezona = Integer.parseInt(fieldValues.get("sezona"));
    	int prinos = Integer.parseInt(fieldValues.get("prinos"));
    	Long parcelniBroj = Long.parseLong(fieldValues.get("parcela"));
    	
    	Njiva n = new Njiva();
    	n.setKultura(kultura);
    	n.setSezona(sezona);
    	n.setPrinos(prinos);

    	return njiveService.createNjiva(parcelniBroj, n);
    }
	
	@RequestMapping(value="/{gazdinstvoId}/njiva",method = RequestMethod.GET)
    public @ResponseBody List<NjivaResource> getAll(@PathVariable Long gazdinstvoId){
		
		List<Njiva> njive = njiveService.getAll(gazdinstvoId);
		List<NjivaResource> rezultat = new ArrayList<>();
		for(Njiva n:njive){
			System.out.println(n.getKultura());
			System.out.println(n.getPrinos());
			System.out.println(n.getParcela().getPoljoprivrednoGazdinstvo().getId());

			NjivaResource res = new NjivaResourceAsm().toResource(n);
			rezultat.add(res);
		}
		return rezultat;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/njiva/{njivaId}",method = RequestMethod.PUT)
    public @ResponseBody NjivaResource editNjiva(@PathVariable Long gazdinstvoId, @PathVariable Long njivaId,@RequestBody Map<String, String> njiva){
    	String kultura =njiva.get("kultura");
    	int sezona = Integer.parseInt(njiva.get("sezona"));
    	int prinos = Integer.parseInt( njiva.get("prinos"));
    	Long parcelniBroj = Long.parseLong( njiva.get("parcela"));
		System.out.println(kultura+"  "+sezona+"  "+prinos+"  "+parcelniBroj);
		
		Njiva n = new Njiva();
		n.setNjivaId(njivaId);
		n.setKultura(kultura);
		n.setPrinos(prinos);
		n.setSezona(sezona);
		
		Njiva nova = njiveService.updateNjiva(parcelniBroj, n);
		return new NjivaResourceAsm().toResource(nova);
	}
	
	@RequestMapping(value="/{gazdinstvoId}/njiva/{njivaId}",method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteLager(@PathVariable Long gazdinstvoId,@PathVariable Long njivaId){
		

		
		if(njiveService.deleteNjiva(njivaId)){
			return true;
		}
	//	Lager kreiran = lagerService.createLager(gazdinstvoId,lager.toLager());

		return false;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/njiva/{njivaId}",method = RequestMethod.GET)
    public @ResponseBody NjivaResource getNjiva(@PathVariable Long gazdinstvoId, @PathVariable Long njivaId){
		
		Njiva trazena = njiveService.findNjivaById(njivaId);
		
		return new NjivaResourceAsm().toResource(trazena);
	}

}
