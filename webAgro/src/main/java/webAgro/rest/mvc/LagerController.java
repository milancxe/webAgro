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

import webAgro.core.models.entities.Lager;
import webAgro.core.models.entities.Parcela;
import webAgro.core.services.LagerService;
import webAgro.rest.resources.LagerResource;
import webAgro.rest.resources.ParcelaResource;
import webAgro.rest.resources.asm.LagerResourceAsm;
import webAgro.rest.resources.asm.ParcelaResourceAsm;

@Controller
@RequestMapping("/app")
public class LagerController {
	
	@Autowired
	private LagerService lagerService;
	
	@RequestMapping(value="/{gazdinstvoId}/lager",method = RequestMethod.POST)
    public @ResponseBody LagerResource createLager(@PathVariable Long gazdinstvoId,@RequestBody LagerResource lager){
		
		System.out.println("spicio mi lager");
		Lager kreiran = lagerService.createLager(gazdinstvoId,lager.toLager());

		return new LagerResourceAsm().toResource(kreiran);
	}
	
	@RequestMapping(value="/{gazdinstvoId}/lager",method = RequestMethod.GET)
    public @ResponseBody List<LagerResource> getAll(@PathVariable Long gazdinstvoId){
		
		List<Lager> lageri = lagerService.getAll(gazdinstvoId);
		List<LagerResource> rezultat = new ArrayList<>();
		for(Lager l:lageri){

			rezultat.add(new LagerResourceAsm().toResource(l));
		}
		return rezultat;
	}

	@RequestMapping(value="/{gazdinstvoId}/lager/{lagerId}",method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteLager(@PathVariable Long gazdinstvoId,@PathVariable Long lagerId){
		
		System.out.println("spicio mi brisanje lager");
		System.out.println("id je: "+lagerId);
		
		if(lagerService.deleteLager(lagerId)){
			return true;
		}
	//	Lager kreiran = lagerService.createLager(gazdinstvoId,lager.toLager());

		return false;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/lager/{lagerId}",method = RequestMethod.PUT)
    public @ResponseBody LagerResource editLager(@PathVariable Long gazdinstvoId, @PathVariable Long lagerId,@RequestBody LagerResource lager){
		

		Lager novi = lagerService.updateLager(lager.toLager());
		LagerResource updejtovan = new LagerResourceAsm().toResource(novi);

		return updejtovan;
	}
}
