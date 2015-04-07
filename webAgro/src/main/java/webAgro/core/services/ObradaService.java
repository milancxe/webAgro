package webAgro.core.services;

import java.util.List;

import webAgro.core.models.entities.Obrada;

public interface ObradaService {
	
	public Obrada createObrada(Long njivaId, Long voziloId, Long masinaId,Long zaposlenId,Obrada obrada);

	public List<Obrada> getAll(Long gazdinstvoId);
	
	public Obrada updateObrada(Long masinaId, Long njivaId, Long voziloId,Long zaposleniId,Obrada toUpdate);
	
	public boolean deleteObrada(Long obradaId);
}
