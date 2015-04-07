package webAgro.core.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;
import webAgro.core.models.entities.Vozilo;
import webAgro.core.repositories.VoziloRepo;
import webAgro.core.services.PoljoprivrednoGazdinstvoService;
import webAgro.core.services.VoziloService;

@Service
@Transactional
public class VoziloServiceImpl implements VoziloService{

	@Autowired
	PoljoprivrednoGazdinstvoService poljoprivrednoGazdinstvoService;
	
	@Autowired
	VoziloRepo voziloRepo;
	
	@Override
	public Vozilo createVozilo(Long poljGazdId, Vozilo vozilo) {

		PoljoprivrednoGazdinstvo gazdinstvo = poljoprivrednoGazdinstvoService.findPoljoprivrednoGazdinstvo(poljGazdId);
		
		vozilo.setPoljoprivrednoGazdinstvo(gazdinstvo);
		
		
		return voziloRepo.createVozilo(vozilo);
	}

	@Override
	public List<Vozilo> getAll(Long poljGazdId) {

		return voziloRepo.getAll(poljGazdId);
	}

	@Override
	public boolean deleteVozilo(Long mhzId) {
		
		
		return voziloRepo.deleteVozilo(mhzId);
	}

	@Override
	public Vozilo updateVozilo(Vozilo vozilo) {
		
		return voziloRepo.updateVozilo(vozilo);
	}

	@Override
	public Vozilo findVoziloById(Long mhzId) {
		// TODO Auto-generated method stub
		return voziloRepo.findVoziloById(mhzId);
	}

}
