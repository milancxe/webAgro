package webAgro.rest.mvc;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.NewParentTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import webAgro.core.models.entities.Parcela;
import webAgro.core.services.ParcelaService;
import webAgro.rest.resources.ParcelaResource;
import webAgro.rest.resources.asm.ParcelaResourceAsm;

@Controller
@RequestMapping("/app")
public class ParceleController {
	
	@Autowired
	ParcelaService parcelaService;
	
	@RequestMapping(value="/{gazdinstvoId}/parcele",method = RequestMethod.GET)
    public @ResponseBody List<ParcelaResource> getAll(@PathVariable Long gazdinstvoId){
		
		List<Parcela> parcele = parcelaService.getAll(gazdinstvoId);
		List<ParcelaResource> rezultat = new ArrayList<>();
		for(Parcela p:parcele){


			rezultat.add(new ParcelaResourceAsm().toResource(p));
		}
		return rezultat;
	}
	
	
	
    @RequestMapping(value="/{gazdinstvoId}/parcele/{parcelniBroj}",method = RequestMethod.POST)
    public @ResponseBody ParcelaResource createParcela(@PathVariable Long gazdinstvoId,@RequestBody ParcelaResource parcela){
    	

    	
    	Parcela novaParcela = parcela.toParcela();
    	
    	Parcela created = parcelaService.createParcela(gazdinstvoId, novaParcela);
    	ParcelaResource createdResource = new ParcelaResourceAsm().toResource(created);
    	return createdResource;
    }
    
    @RequestMapping(value="/{gazdinstvoId}/parcele/{parcelniBroj}",method = RequestMethod.GET)
    public @ResponseBody ParcelaResource getParcela(@PathVariable Long gazdinstvoId, @PathVariable Long parcelniBroj){
    	
    	Parcela created = parcelaService.findParcela(parcelniBroj);
    	ParcelaResource createdResource = new ParcelaResourceAsm().toResource(created);
    	return createdResource;
    }
    
    @RequestMapping(value="/{gazdinstvoId}/parcele/{parcelniBroj}",method = RequestMethod.PUT)
    public @ResponseBody ParcelaResource editParcela(@PathVariable Long gazdinstvoId, @PathVariable Long parcelniBroj,@RequestBody ParcelaResource parcela){
		
		Parcela editovana = parcelaService.updateParcela(parcela.toParcela());
		return new ParcelaResourceAsm().toResource(editovana);
	}
    
    @RequestMapping(value="/{gazdinstvoId}/parcele/{parcelniBroj}",method = RequestMethod.DELETE)
    public @ResponseBody ParcelaResource deleteParcela(@PathVariable Long gazdinstvoId, @PathVariable Long parcelniBroj){
		
    	System.out.println("spicio me je");
    	parcelaService.deleteParcela(parcelniBroj);
		return new ParcelaResource();
	}

}
