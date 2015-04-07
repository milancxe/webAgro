package webAgro.core.services;

import java.util.List;

import webAgro.core.models.entities.Lager;

public interface LagerService {

	public Lager createLager(Long poljGazdId,Lager lager);
	
	public List<Lager> getAll(Long brojGazdinstva);
	
	public boolean deleteLager(Long lagerId);
	
	public Lager updateLager(Lager lager);
}
