package webAgro.core.services;

import java.util.List;

import webAgro.core.models.entities.Njiva;

public interface NjivaService {
	
	public Njiva createNjiva(Long parcelniBroj,Njiva njiva);

	public List<Njiva> getAll(Long gazdinstvoId);
	
	public Njiva updateNjiva(Long parcelniBroj,Njiva njiva);
	
	public boolean deleteNjiva(Long njivaId);
	
	public Njiva findNjivaById(Long njivaId);
}
