package webAgro.core.services;

import java.util.List;

import webAgro.core.models.entities.PrikljucnaMasina;

public interface MasinaService {
	
	public PrikljucnaMasina createMasina(Long poljGazdId, PrikljucnaMasina masina);
	
	public List<PrikljucnaMasina> getAll(Long poljGazdId);
	
	public boolean deleteMasina(Long mhzId);
	
	public PrikljucnaMasina updateMasina(PrikljucnaMasina masina);
	
	public PrikljucnaMasina findMasinaById(Long mhzId);
}
