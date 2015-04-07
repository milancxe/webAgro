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

import webAgro.core.models.entities.Obrada;
import webAgro.core.services.ObradaService;
import webAgro.rest.resources.ObradaResource;
import webAgro.rest.resources.asm.ObradaResourceAsm;

@Controller
@RequestMapping("/app")
public class ObradaController {
	
	@Autowired
	ObradaService obradaService;
	
	@RequestMapping(value="/{gazdinstvoId}/obrada",method = RequestMethod.POST)
    public @ResponseBody Object createObrada(@PathVariable Long gazdinstvoId,@RequestBody Map<String, String> fieldValues){
    	

    	String napomena =fieldValues.get("napomena");
    	String vrstaObrade = fieldValues.get("vrstaObrade");
    	Long masinaId = Long.parseLong(fieldValues.get("masina"));
    	Long njivaId = Long.parseLong(fieldValues.get("njiva"));
    	Long voziloId = Long.parseLong(fieldValues.get("vozilo"));
    	Long zaposlenId = Long.parseLong(fieldValues.get("zaposlen"));
    	String datum = fieldValues.get("datum");
    	
    	System.out.println(napomena+vrstaObrade+masinaId+njivaId+voziloId+datum+zaposlenId);
    	
    	Obrada o = new Obrada();
    	o.setDatum(datum);
    	o.setNapomena(napomena);
    	o.setVrstaObrade(vrstaObrade);
    	
    	obradaService.createObrada(njivaId, voziloId, masinaId,zaposlenId, o);
    

    	return null;
    }
	
	@RequestMapping(value="/{gazdinstvoId}/obrada",method = RequestMethod.GET)
	public @ResponseBody List<ObradaResource> getAll(@PathVariable Long gazdinstvoId){
		
		List<Obrada> obrade = obradaService.getAll(gazdinstvoId);
		List<ObradaResource> rezultat = new ArrayList<ObradaResource>();
		System.out.println("za slanje na klijenta:");
		for(Obrada o:obrade){
			
			System.out.println(o.getDatum());
			System.out.println(o.getNapomena());
			System.out.println(o.getVrstaObrade());
			System.out.println(o.getNjive().get(0).getParcela());
			System.out.println(o.getPrikljucneMasine().get(0).getTip());
			System.out.println(o.getVozila().get(0).getTip());
			System.out.println(o.getZaposleni().get(0).getIme());
			rezultat.add(new ObradaResourceAsm().toResource(o));
		}
		
		
		return rezultat;
		
	}
	
	@RequestMapping(value="/{gazdinstvoId}/obrada/{obradaId}",method = RequestMethod.PUT)
	public @ResponseBody List<ObradaResource> editObrada(@PathVariable Long gazdinstvoId,@PathVariable Long obradaId,@RequestBody Map<String, String> fieldValues){
		
    	String napomena =fieldValues.get("napomena");
    	String vrstaObrade = fieldValues.get("vrstaObrade");
    	Long masinaId = Long.parseLong(fieldValues.get("masina"));
    	Long njivaId = Long.parseLong(fieldValues.get("njiva"));
    	Long voziloId = Long.parseLong(fieldValues.get("vozilo"));
    	Long zaposlenId = Long.parseLong(fieldValues.get("zaposlen"));
    	String datum = fieldValues.get("datum");
    	
    	Obrada toUpdate = new Obrada();
    	toUpdate.setDatum(datum);
    	toUpdate.setId(obradaId);
    	toUpdate.setNapomena(napomena);
    	toUpdate.setVrstaObrade(vrstaObrade);
    	obradaService.updateObrada(masinaId, njivaId,voziloId,zaposlenId,toUpdate);
    	System.out.println(napomena+vrstaObrade+masinaId+njivaId+voziloId+datum+zaposlenId);
		return null;
	}

	@RequestMapping(value="/{gazdinstvoId}/obrada/{obradaId}",method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteObrada(@PathVariable Long gazdinstvoId,@PathVariable Long obradaId){
		
		return obradaService.deleteObrada(obradaId);
		
	}
	
}
