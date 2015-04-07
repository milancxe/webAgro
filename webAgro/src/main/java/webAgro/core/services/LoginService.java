package webAgro.core.services;

import webAgro.core.models.entities.Zaposleni;

public interface LoginService {
	
	public Zaposleni loginKorisnika(Long brojGazdinstva, String imeVlasnika);

}
