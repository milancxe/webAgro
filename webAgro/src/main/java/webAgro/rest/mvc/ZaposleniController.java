package webAgro.rest.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import webAgro.core.models.entities.Vozilo;
import webAgro.core.models.entities.Zaposleni;
import webAgro.core.services.LoginService;
import webAgro.core.services.ZaposleniService;
import webAgro.rest.resources.LoginResource;
import webAgro.rest.resources.VoziloResource;
import webAgro.rest.resources.ZaposleniResource;
import webAgro.rest.resources.asm.VoziloResourceAsm;
import webAgro.rest.resources.asm.ZaposleniResourceAsm;

@Controller
@RequestMapping("/app")
public class ZaposleniController{

	@Autowired 
	LoginService loginService;
	
	@Autowired
	ZaposleniService zaposleniService;
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value="/login",method =RequestMethod.POST)
	public  ZaposleniResource loginZaposleni(@RequestBody LoginResource loginData){
		System.out.println("spici je login");
		Zaposleni ulogovaniKorisnik = loginService.loginKorisnika(loginData.getBrojGazdinstva(),loginData.getSifra());

		ZaposleniResource trazeni = new ZaposleniResourceAsm().toResource(ulogovaniKorisnik);

		return trazeni;
		
	}
	
	@RequestMapping(value="/{gazdinstvoId}/zaposleni",method = RequestMethod.POST)
    public @ResponseBody Object createZaposleni(@PathVariable Long gazdinstvoId,@RequestBody Map<String, String> zaposleni){
		
    	String ime =zaposleni.get("ime");
    	String prezime =zaposleni.get("prezime");
    	String sifra =zaposleni.get("sifra");
		Zaposleni z = new Zaposleni();
		z.setIme(ime);
		z.setPrezime(prezime);
		z.setSifra(sifra);
		
		
		
		ZaposleniResource noviZaposleni = new ZaposleniResourceAsm().toResource(zaposleniService.createZaposleni(gazdinstvoId,z));

		return noviZaposleni;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/zaposleni",method = RequestMethod.GET)
    public @ResponseBody List<ZaposleniResource> getAll(@PathVariable Long gazdinstvoId){
		
		List<Zaposleni> zaposleni = zaposleniService.getAll(gazdinstvoId);
		List<ZaposleniResource> rezultat = new ArrayList<>();
		for(Zaposleni z:zaposleni){
			System.out.println(z.getIme());
			//System.out.println(z.getParcele());
			
			rezultat.add(new ZaposleniResourceAsm().toResource(z));
		}
		return rezultat;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/zaposleni/{zapId}",method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteZaposleni(@PathVariable Long gazdinstvoId,@PathVariable Long zapId){
		
		System.out.println("spicio mi brisanje lager");
		System.out.println("id je: "+zapId);
		
		if(zaposleniService.deleteZaposleni(zapId)){
			return true;
		}

		return false;
	}
	
	@RequestMapping(value="/{gazdinstvoId}/zaposleni/{zapId}",method = RequestMethod.PUT)
    public @ResponseBody ZaposleniResource updateZaposleni(@PathVariable Long gazdinstvoId,@PathVariable Long zapId,@RequestBody ZaposleniResource zap){
		
		System.out.println("spicio mi brisanje lager");
		System.out.println("id je: "+zapId);
		Zaposleni toEdit =  new Zaposleni();
		toEdit.setId(zap.getZid());
		toEdit.setIme(zap.getIme());
		toEdit.setPrezime(zap.getPrezime());
		toEdit.setSifra(zap.getSifra());
		Zaposleni updateovan = zaposleniService.updateZaposleni(toEdit);
		return new ZaposleniResourceAsm().toResource(updateovan);
	}
	
	@RequestMapping(value="/{gazdinstvoId}/zaposleni/{zapId}", method=RequestMethod.GET)
	public @ResponseBody ZaposleniResource getZaposleni(@PathVariable Long gazdinstvoId,@PathVariable Long zapId){
		
		Zaposleni trazeni = zaposleniService.findZaposleni(zapId);
		return new ZaposleniResourceAsm().toResource(trazeni);
	}
	
}
