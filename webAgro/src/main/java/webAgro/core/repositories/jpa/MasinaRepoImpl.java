package webAgro.core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import webAgro.core.models.entities.PrikljucnaMasina;
import webAgro.core.repositories.MasinaRepo;

@Repository
public class MasinaRepoImpl implements MasinaRepo{

	@PersistenceContext 
	EntityManager em;
	
	@Override
	public PrikljucnaMasina createMasina(PrikljucnaMasina masina) {

		em.persist(masina);
		return masina;
	}

	@Override
	public List<PrikljucnaMasina> getAll(Long poljGazdId) {
		List<PrikljucnaMasina> rezultati = em
				.createQuery(
						"FROM PrikljucnaMasina p where p.poljoprivrednoGazdinstvo.id= :brojGazd")
				.setParameter("brojGazd", poljGazdId).getResultList();

		return rezultati;
	}

	@Override
	public boolean deleteMasina(Long mhzId) {

		PrikljucnaMasina toDelete = em.find(PrikljucnaMasina.class, mhzId);
		
		if(toDelete!=null){
			em.remove(toDelete);
			return true;
		}
		return false;
	}

	@Override
	public PrikljucnaMasina updateMasina(PrikljucnaMasina masina) {

		PrikljucnaMasina stara = em.find(PrikljucnaMasina.class, masina.getMhzId());
		stara.setGodiste(masina.getGodiste());
		stara.setNapomena(masina.getNapomena());
		stara.setTip(masina.getTip());
		em.persist(stara);
		return stara;
	}

	@Override
	public PrikljucnaMasina findMasinaById(Long mhzId) {
		// TODO Auto-generated method stub
		return em.find(PrikljucnaMasina.class, mhzId);
	}
	

}
