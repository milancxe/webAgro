package webAgro.core.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webAgro.core.models.entities.Lager;
import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;
import webAgro.core.repositories.LagerRepo;
import webAgro.core.services.LagerService;
import webAgro.core.services.PoljoprivrednoGazdinstvoService;

@Service
@Transactional
public class LagerServiceImpl implements LagerService{

	@Autowired
	private LagerRepo lagerRepo;
	
	@Autowired
	private PoljoprivrednoGazdinstvoService poljoprivrednogazdinstvoService;
	
	@Override
	public Lager createLager(Long poljGazdId, Lager lager) {
		// TODO Auto-generated method stub
		System.out.println("poljgazdid je"+poljGazdId);
		PoljoprivrednoGazdinstvo gazdinstvo = poljoprivrednogazdinstvoService.findPoljoprivrednoGazdinstvo(poljGazdId);
		System.out.println("nasaoSamGazdinstvo "+gazdinstvo.toString());
		lager.setPoljoprivrednoGazdinstvo(gazdinstvo);
		return lagerRepo.createLager(lager);
	}

	@Override
	public List<Lager> getAll(Long brojGazdinstva) {

		return lagerRepo.getAll(brojGazdinstva);
	}

	@Override
	public boolean deleteLager(Long lagerId) {

		return lagerRepo.deleteLager(lagerId);
	}

	@Override
	public Lager updateLager(Lager lager) {
		// TODO Auto-generated method stub
		return lagerRepo.updateLager(lager);
	}
	


}
