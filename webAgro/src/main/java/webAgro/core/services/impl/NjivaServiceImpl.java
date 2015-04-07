package webAgro.core.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webAgro.core.models.entities.Njiva;
import webAgro.core.models.entities.Parcela;
import webAgro.core.repositories.NjivaRepo;
import webAgro.core.services.NjivaService;
import webAgro.core.services.ParcelaService;

@Service
@Transactional
public class NjivaServiceImpl implements NjivaService {

	@Autowired
	ParcelaService parcelaService;
	
	@Autowired
	NjivaRepo njivaRepo;
	
	@Override
	public Njiva createNjiva(Long parcelniBroj, Njiva njiva) {

		Parcela p = parcelaService.findParcela(parcelniBroj);
		njiva.setParcela(p);
		return njivaRepo.createNjiva(njiva);
	}

	@Override
	public List<Njiva> getAll(Long gazdinstvoId) {
		// TODO Auto-generated method stub
		List<Njiva>njive = njivaRepo.getAll(gazdinstvoId);
		for(Njiva n:njive){
			n.getParcela().getKategorija();
			n.getParcela().getPoljoprivrednoGazdinstvo();
			n.getParcela().getPotez();
		}
		
		return njive;
	}

	@Override
	public Njiva updateNjiva(Long parcelniBroj, Njiva njiva) {
		
		Parcela p = parcelaService.findParcela(parcelniBroj);
		njiva.setParcela(p);
		
		return njivaRepo.updateNjiva(njiva);
	}

	@Override
	public boolean deleteNjiva(Long njivaId) {

		return njivaRepo.deleteNjiva(njivaId);
	}

	@Override
	public Njiva findNjivaById(Long njivaId) {

		return njivaRepo.findNjivaById(njivaId);
	}

}
