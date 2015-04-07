package webAgro.core.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;
import webAgro.core.models.entities.Zaposleni;
import webAgro.core.repositories.PoljoprivrednoGazdinstvoRepo;
import webAgro.core.services.PoljoprivrednoGazdinstvoService;
import webAgro.core.services.ZaposleniService;

@Service
@Transactional
public class PoljoprivrednoGazdinstvoServiceImpl implements PoljoprivrednoGazdinstvoService {

	@Autowired
	PoljoprivrednoGazdinstvoRepo poljoprivrednoGazdinstvoRepo;
	
	@Autowired
	ZaposleniService zaposleniService;
	
	
	@Override
	public PoljoprivrednoGazdinstvo findPoljoprivrednoGazdinstvo(Long id) {
		// TODO Auto-generated method stub
		return poljoprivrednoGazdinstvoRepo.findPoljoprivrednoGazdinstvo(id);
	}

	@Override
	public PoljoprivrednoGazdinstvo updatePoljoprivrednoGazdinstvo(Long id,
			PoljoprivrednoGazdinstvo data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PoljoprivrednoGazdinstvo createPoljoprivrednoGazdinstvo(
			Long brojGazdinstva, String imeVlasnika, String prezimeVlasnika, String sifra) {
		// TODO Auto-generated method stub


		Zaposleni vlasnik = new Zaposleni();
		vlasnik.setIme(imeVlasnika);
		vlasnik.setPrezime(prezimeVlasnika);
		vlasnik.setSifra(sifra);

		
		PoljoprivrednoGazdinstvo novoGazd = new PoljoprivrednoGazdinstvo();
		vlasnik.setPoljoprivrednoGazdinstvo(novoGazd);
		
		Zaposleni kreiranVlasnik = zaposleniService.createZaposleni(vlasnik);
		PoljoprivrednoGazdinstvo novoGazdinstvo = poljoprivrednoGazdinstvoRepo.createPoljoprivrednoGazdinstvo(novoGazd);
		
		return novoGazdinstvo;
	}
	

}
