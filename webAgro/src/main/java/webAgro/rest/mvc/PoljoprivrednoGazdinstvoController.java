package webAgro.rest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;
import webAgro.core.services.PoljoprivrednoGazdinstvoService;
import webAgro.core.services.ZaposleniService;
import webAgro.rest.resources.PoljoprivrednoGazdinstvoResource;

@Controller
@RequestMapping("/app/poljoprivrednogazdinstvo")
public class PoljoprivrednoGazdinstvoController {
	
	@Autowired
	PoljoprivrednoGazdinstvoService servicePoljoprivrednoGazdinstvo;
	
	@Autowired
	ZaposleniService zaposleniService;
	
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Object findGazdinstvo(@RequestBody PoljoprivrednoGazdinstvo poljGazd){
    	
    	System.out.println("stigao mi je objekat");
    	System.out.println(poljGazd);
    	
    	return null;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody PoljoprivrednoGazdinstvo createGazdinstvo(@RequestBody PoljoprivrednoGazdinstvoResource poljGazd){
    	
    	System.out.println("stigao mi je objekat");
    	
    	
    	PoljoprivrednoGazdinstvo novoPoljGazd = servicePoljoprivrednoGazdinstvo.createPoljoprivrednoGazdinstvo(poljGazd.getBrojGazdinstva(),poljGazd.getVlasnikIme(),poljGazd.getVlasnikPrezime(), poljGazd.getSifra());
    	System.out.println(novoPoljGazd.getVlasnik());
    	System.out.println(novoPoljGazd.getId());
    	System.out.println(poljGazd.getVlasnikIme());
    	System.out.println(poljGazd.getVlasnikPrezime());
    	System.out.println(poljGazd.getBrojGazdinstva());
    	System.out.println(poljGazd.toString());
    	
    	return novoPoljGazd;
    }

}
