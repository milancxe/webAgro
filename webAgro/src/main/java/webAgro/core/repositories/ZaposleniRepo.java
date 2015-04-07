package webAgro.core.repositories;


import java.util.List;

import webAgro.core.models.entities.Zaposleni;

public interface ZaposleniRepo {

    public Zaposleni findZaposleni(Long id);
    
    public Zaposleni findZaposleniLogin(Long brojGazdinstva, String sifra);
	
	public Zaposleni createZaposleni(Zaposleni data);
	
    public Zaposleni updateZaposleni(Zaposleni data);

    public List<Zaposleni> getAll(Long gazdinstvoId);
    
    public boolean deleteZaposleni(Long zapId);
}
