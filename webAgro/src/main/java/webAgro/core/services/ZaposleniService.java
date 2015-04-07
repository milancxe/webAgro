package webAgro.core.services;

import java.util.List;

import webAgro.core.models.entities.Zaposleni;

public interface ZaposleniService {
	
    public Zaposleni findZaposleni(Long id);
    
    public Zaposleni createZaposleni(Zaposleni data);
	
	public Zaposleni createZaposleni(Long gazdinstvoId,Zaposleni data);
	
    public Zaposleni updateZaposleni(Zaposleni data);
    
    public List<Zaposleni> getAll(Long gazdinstvoId);
    
    public boolean deleteZaposleni(Long zapId);

}
