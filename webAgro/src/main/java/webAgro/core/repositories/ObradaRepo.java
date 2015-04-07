package webAgro.core.repositories;

import java.util.List;

import webAgro.core.models.entities.Obrada;

public interface ObradaRepo {
	
	public Obrada createObrada(Obrada obrada);

	public List<Obrada> getAll(Long gazdinstvoId);
	
	public Obrada updateObrada(Obrada obrada);
	
	public boolean deleteObrada(Long obradaId);
}
