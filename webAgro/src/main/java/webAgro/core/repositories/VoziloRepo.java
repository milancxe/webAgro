package webAgro.core.repositories;

import java.util.List;

import webAgro.core.models.entities.Vozilo;

public interface VoziloRepo {

	public Vozilo createVozilo(Vozilo vozilo);
	
	public List<Vozilo> getAll(Long poljGazdId);
	
	public boolean deleteVozilo(Long mhzId);
	
	public Vozilo updateVozilo(Vozilo vozilo);
	
	public Vozilo findVoziloById(Long mhzId);
}
