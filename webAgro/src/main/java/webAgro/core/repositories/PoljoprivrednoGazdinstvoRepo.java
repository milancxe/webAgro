package webAgro.core.repositories;

import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;


public interface PoljoprivrednoGazdinstvoRepo {
    public PoljoprivrednoGazdinstvo findPoljoprivrednoGazdinstvo(Long id);
	
	public PoljoprivrednoGazdinstvo createPoljoprivrednoGazdinstvo(PoljoprivrednoGazdinstvo data);
	
    public PoljoprivrednoGazdinstvo updatePoljoprivrednoGazdinstvo(Long id, PoljoprivrednoGazdinstvo data);
}
