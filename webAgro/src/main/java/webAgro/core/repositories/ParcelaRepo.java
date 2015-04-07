package webAgro.core.repositories;

import java.util.List;

import webAgro.core.models.entities.Parcela;

public interface ParcelaRepo {
	
	public Parcela findParcela(Long parcelniBroj);
	
	public Parcela saveParcela(Parcela parcela);
	
	public List<Parcela> getAll(Long brojGazdinstva);
	
	public Parcela updateParcela(Parcela parcela);
	
	public boolean deleteParcela(Long parcelniBroj);
	
	public Parcela getParcela(Long gazdinstvoId, Long parcelniBroj);

}
