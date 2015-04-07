package webAgro.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;
import webAgro.core.models.entities.Zaposleni;
import webAgro.core.repositories.ZaposleniRepo;
import webAgro.core.services.PoljoprivrednoGazdinstvoService;
import webAgro.core.services.ZaposleniService;

@Service
@Transactional
public class ZaposleniServiceImpl implements ZaposleniService {
	
	@Autowired
	private ZaposleniRepo zaposleniRepo;
	
	@Autowired
	private PoljoprivrednoGazdinstvoService gazdinstvoService;

	@Override
	public Zaposleni findZaposleni(Long id) {
		// TODO Auto-generated method stub
		return zaposleniRepo.findZaposleni(id);
	}

	@Override
	public Zaposleni createZaposleni(Long gazdinstvoId,Zaposleni data) {
		// TODO Auto-generated method stub
		PoljoprivrednoGazdinstvo gazdinstvo = gazdinstvoService.findPoljoprivrednoGazdinstvo(gazdinstvoId);
		data.setPoljoprivrednoGazdinstvo(gazdinstvo);
        Zaposleni zaposleni = zaposleniRepo.createZaposleni(data);
        zaposleni.getPoljoprivrednoGazdinstvo();
        return zaposleni;
		
	}

	@Override
	public Zaposleni updateZaposleni(Zaposleni data) {
		// TODO Auto-generated method stub
		Zaposleni updateovan =zaposleniRepo.updateZaposleni(data);
		System.out.println(updateovan.getParcele());
		return updateovan;
	}

	@Override
	public Zaposleni createZaposleni(Zaposleni data) {
		Zaposleni zaposleni = zaposleniRepo.createZaposleni(data);
        zaposleni.getPoljoprivrednoGazdinstvo();
        return zaposleni;
	}

	@Override
	public List<Zaposleni> getAll(Long gazdinstvoId) {
		// TODO Auto-generated method stub
		List<Zaposleni> lista = zaposleniRepo.getAll(gazdinstvoId);
		for(Zaposleni z:lista){
			z.getParcele();
			System.out.println(z.getPrezime());
			System.out.println(z.getParcele());
			
		}
		return lista;
	}

	@Override
	public boolean deleteZaposleni(Long zapId) {
		// TODO Auto-generated method stub
		return zaposleniRepo.deleteZaposleni(zapId);
	}

}
