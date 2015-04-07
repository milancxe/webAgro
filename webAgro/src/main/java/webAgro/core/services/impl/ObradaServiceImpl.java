package webAgro.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webAgro.core.models.entities.Njiva;
import webAgro.core.models.entities.Obrada;
import webAgro.core.models.entities.PrikljucnaMasina;
import webAgro.core.models.entities.Vozilo;
import webAgro.core.models.entities.Zaposleni;
import webAgro.core.repositories.ObradaRepo;
import webAgro.core.services.MasinaService;
import webAgro.core.services.NjivaService;
import webAgro.core.services.ObradaService;
import webAgro.core.services.VoziloService;
import webAgro.core.services.ZaposleniService;

@Service
@Transactional
public class ObradaServiceImpl implements ObradaService{

	@Autowired
	NjivaService njivaService;
	
	@Autowired
	VoziloService voziloService;
	
	@Autowired
	MasinaService masinaService;
	
	@Autowired
	ZaposleniService zaposleniService;
	
	@Autowired
	ObradaRepo obradaRepo;
	
	@Override
	public Obrada createObrada(Long njivaId, Long voziloId, Long masinaId,Long zaposlenId,
			Obrada obrada) {
		Njiva njiva = njivaService.findNjivaById(njivaId);
		Vozilo vozilo = voziloService.findVoziloById(voziloId);
		PrikljucnaMasina masina = masinaService.findMasinaById(masinaId);
		Zaposleni zaposlen =zaposleniService.findZaposleni(zaposlenId);
		
		List<Njiva> njive = new ArrayList<>();
		njive.add(njiva);
		obrada.setNjive(njive);
		
		List<Vozilo> vozila = new ArrayList<>();
		vozila.add(vozilo);
		
		List<PrikljucnaMasina> masine = new ArrayList<>();
		masine.add(masina);
		
		List<Zaposleni> zaposleni = new ArrayList<>();
		zaposleni.add(zaposlen);
		
		
		obrada.setVozila(vozila);
		obrada.setPrikljucneMasine(masine);
		obrada.setZaposleni(zaposleni);
		
		return obradaRepo.createObrada(obrada);
	}

	@Override
	public List<Obrada> getAll(Long gazdinstvoId) {
		List<Obrada> obrade = new ArrayList<Obrada>();
		obrade =obradaRepo.getAll(gazdinstvoId);
		
		System.out.println("trazim sve obrade");
		
		for(Obrada o: obrade){
			System.out.println(o.getDatum());
			System.out.println(o.getVrstaObrade());
			System.out.println(o.getNjive().toString());
			System.out.println(o.getZaposleni().toString());
			System.out.println(o.getVozila().toString());
			System.out.println(o.getPrikljucneMasine().toString());
		}
		return obrade;
	}

	@Override
	public Obrada updateObrada(Long masinaId, Long njivaId, Long voziloId,
			Long zaposleniId, Obrada toUpdate) {
		
		PrikljucnaMasina masina = masinaService.findMasinaById(masinaId);
		Njiva njiva = njivaService.findNjivaById(njivaId);
		Vozilo vozilo = voziloService.findVoziloById(voziloId);
		Zaposleni zaposlen= zaposleniService.findZaposleni(zaposleniId);
		
		List<Njiva> njive = new ArrayList<>();
		njive.add(njiva);

		
		List<Vozilo> vozila = new ArrayList<>();
		vozila.add(vozilo);
		
		List<PrikljucnaMasina> masine = new ArrayList<>();
		masine.add(masina);
		
		List<Zaposleni> zaposleni = new ArrayList<>();
		zaposleni.add(zaposlen);
		
		toUpdate.setNjive(njive);
		toUpdate.setVozila(vozila);
		toUpdate.setPrikljucneMasine(masine);
		toUpdate.setZaposleni(zaposleni);
		
		return obradaRepo.updateObrada(toUpdate);
	}

	@Override
	public boolean deleteObrada(Long obradaId) {
		// TODO Auto-generated method stub
		
		return obradaRepo.deleteObrada(obradaId);
	}

}
