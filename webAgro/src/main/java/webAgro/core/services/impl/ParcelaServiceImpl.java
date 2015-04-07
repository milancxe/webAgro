package webAgro.core.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webAgro.core.models.entities.Parcela;
import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;
import webAgro.core.repositories.PoljoprivrednoGazdinstvoRepo;
import webAgro.core.repositories.jpa.ParcelaRepoImpl;
import webAgro.core.services.ParcelaService;

@Service
@Transactional
public class ParcelaServiceImpl implements ParcelaService {

	@Autowired
	ParcelaRepoImpl parcelaRepo;
	
	@Autowired
	PoljoprivrednoGazdinstvoRepo poljoprivrednoGazdinstvoRepo;
	
	@Override
	public Parcela createParcela(Long brojGazdinstva,Parcela parcela) {

		PoljoprivrednoGazdinstvo gazdinstvo = poljoprivrednoGazdinstvoRepo.findPoljoprivrednoGazdinstvo(brojGazdinstva);
		parcela.setPoljoprivrednoGazdinstvo(gazdinstvo);
		return parcelaRepo.saveParcela(parcela);
	}

	@Override
	public List<Parcela> getAll(Long brojGazdinstva) {

	
		
		return parcelaRepo.getAll(brojGazdinstva);
	}

	@Override
	public Parcela updateParcela(Parcela parcela) {

		
		return parcelaRepo.updateParcela(parcela);
	}

	@Override
	public boolean deleteParcela(Long parcelniBroj) {
		// TODO Auto-generated method stub
		if(parcelaRepo.deleteParcela(parcelniBroj)){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public Parcela findParcela(Long parcelniBroj) {
		
		return parcelaRepo.findParcela(parcelniBroj);
	}

	@Override
	public Parcela getParcela(Long gazdinstvoId, Long parcelniBroj) {
		// TODO Auto-generated method stub
		return parcelaRepo.getParcela(gazdinstvoId,parcelniBroj);
	}

}
