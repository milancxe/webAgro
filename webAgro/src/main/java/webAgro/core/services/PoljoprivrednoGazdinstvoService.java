package webAgro.core.services;

import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;

public interface PoljoprivrednoGazdinstvoService {
    public PoljoprivrednoGazdinstvo findPoljoprivrednoGazdinstvo(Long id);
	
	public PoljoprivrednoGazdinstvo createPoljoprivrednoGazdinstvo(Long brojGazdinstva, String imeVlasnika, String prezimeVlasnika, String sifra);
	
    public PoljoprivrednoGazdinstvo updatePoljoprivrednoGazdinstvo(Long id, PoljoprivrednoGazdinstvo data);
}
