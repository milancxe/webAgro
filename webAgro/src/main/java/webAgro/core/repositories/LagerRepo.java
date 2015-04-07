package webAgro.core.repositories;

import java.util.List;

import webAgro.core.models.entities.Lager;

public interface LagerRepo {
	
	public Lager createLager(Lager lager);
	
	public List<Lager> getAll(Long brojGazdinstva);
	
	public boolean deleteLager(Long lagerId);
	
	public Lager updateLager(Lager lager);

}
