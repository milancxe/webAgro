package webAgro.core.repositories;

import java.util.List;

import webAgro.core.models.entities.PrikljucnaMasina;

public interface MasinaRepo {
	
	public PrikljucnaMasina createMasina(PrikljucnaMasina masina);
	
	public List<PrikljucnaMasina> getAll(Long poljGazdId);
	
	public boolean deleteMasina(Long mhzId);
	
	public PrikljucnaMasina updateMasina(PrikljucnaMasina masina);
	
	public PrikljucnaMasina findMasinaById(Long mhzId);
}
