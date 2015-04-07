package webAgro.core.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;
import webAgro.core.models.entities.PrikljucnaMasina;
import webAgro.core.repositories.MasinaRepo;
import webAgro.core.services.MasinaService;
import webAgro.core.services.PoljoprivrednoGazdinstvoService;

@Service
@Transactional
public class MasinaServiceImpl implements MasinaService {
	
	@Autowired
	PoljoprivrednoGazdinstvoService poljoprivrednoGazdinstvoService;
	
	@Autowired
	MasinaRepo masinaRepo;

	@Override
	public PrikljucnaMasina createMasina(Long poljGazdId,
			PrikljucnaMasina masina) {
		PoljoprivrednoGazdinstvo gazdinstvo = poljoprivrednoGazdinstvoService.findPoljoprivrednoGazdinstvo(poljGazdId);
		
		masina.setPoljoprivrednoGazdinstvo(gazdinstvo);
		return masinaRepo.createMasina(masina);
	}

	@Override
	public List<PrikljucnaMasina> getAll(Long poljGazdId) {

		return masinaRepo.getAll(poljGazdId);
	}

	@Override
	public boolean deleteMasina(Long mhzId) {

		return masinaRepo.deleteMasina(mhzId);
	}

	@Override
	public PrikljucnaMasina updateMasina(PrikljucnaMasina masina) {

		return masinaRepo.updateMasina(masina);
	}

	@Override
	public PrikljucnaMasina findMasinaById(Long mhzId) {
		// TODO Auto-generated method stub
		return masinaRepo.findMasinaById(mhzId);
	}

	
}
