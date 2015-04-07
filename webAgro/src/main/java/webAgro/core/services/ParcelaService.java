package webAgro.core.services;

import java.util.List;

import webAgro.core.models.entities.Parcela;

public interface ParcelaService {
	
	public Parcela findParcela(Long parcelniBroj);
	
	public Parcela createParcela(Long brojGazdinstva, Parcela parcela);
	
	public List<Parcela> getAll(Long brojGazdinstva);
	
	public Parcela updateParcela(Parcela parcela);
	
	public boolean deleteParcela(Long parcelniBroj);
	
	public Parcela getParcela(Long gazdinstvoId, Long parcelniBroj);

}
