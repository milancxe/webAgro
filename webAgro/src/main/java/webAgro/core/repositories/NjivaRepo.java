package webAgro.core.repositories;

import java.util.List;

import webAgro.core.models.entities.Njiva;

public interface NjivaRepo {
	
	public Njiva createNjiva(Njiva njiva);
	
	public List<Njiva> getAll(Long gazdinstvoId);
	
	public Njiva updateNjiva(Njiva njiva);
	
	public boolean deleteNjiva(Long njivaId);

	public Njiva findNjivaById(Long njivaId);
}
