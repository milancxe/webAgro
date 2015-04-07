package webAgro.core.services;

import java.util.List;

import webAgro.core.models.entities.Vozilo;

public interface VoziloService {

	public Vozilo createVozilo(Long poljGazdId, Vozilo vozilo);
	
	public List<Vozilo> getAll(Long poljGazdId);
	
	public boolean deleteVozilo(Long mhzId);
	
	public Vozilo updateVozilo(Vozilo vozilo);
	
	public Vozilo findVoziloById(Long mhzId);
}
