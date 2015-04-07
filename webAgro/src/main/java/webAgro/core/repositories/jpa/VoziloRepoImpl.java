package webAgro.core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import webAgro.core.models.entities.Vozilo;
import webAgro.core.repositories.VoziloRepo;

@Repository
public class VoziloRepoImpl implements VoziloRepo {

	@PersistenceContext
	EntityManager em;

	@Override
	public Vozilo createVozilo(Vozilo vozilo) {
		// TODO Auto-generated method stub
		
		em.persist(vozilo);
		return vozilo;
	}

	@Override
	public List<Vozilo> getAll(Long poljGazdId) {
		
		List<Vozilo> rezultati = em
				.createQuery(
						"FROM Vozilo v where v.poljoprivrednoGazdinstvo.id= :brojGazd")
				.setParameter("brojGazd", poljGazdId).getResultList();

		return rezultati;
		
	}

	@Override
	public boolean deleteVozilo(Long mhzId) {

		Vozilo toDelete = em.find(Vozilo.class, mhzId);
		
		if(toDelete!=null){
			em.remove(toDelete);
			return true;
		}
		return false;
	}

	@Override
	public Vozilo updateVozilo(Vozilo vozilo) {
		
		Vozilo staro = em.find(Vozilo.class, vozilo.getMhzId());
		staro.setGodiste(vozilo.getGodiste());
		staro.setNapomena(vozilo.getNapomena());
		staro.setTip(vozilo.getTip());
		em.persist(staro);
		
		return staro;
	}

	@Override
	public Vozilo findVoziloById(Long mhzId) {
		// TODO Auto-generated method stub
		return em.find(Vozilo.class, mhzId);
	}
}
