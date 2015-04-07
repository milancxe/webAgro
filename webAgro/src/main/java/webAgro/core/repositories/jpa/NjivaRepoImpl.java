package webAgro.core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import webAgro.core.models.entities.Lager;
import webAgro.core.models.entities.Njiva;
import webAgro.core.repositories.NjivaRepo;

@Repository
public class NjivaRepoImpl implements NjivaRepo{

	@PersistenceContext
	EntityManager em;

	@Override
	public Njiva createNjiva(Njiva njiva) {
		// TODO Auto-generated method stub
		em.persist(njiva);
		
		return njiva;
	}

	@Override
	public List<Njiva> getAll(Long gazdinstvoId) {
		// TODO Auto-generated method stub
		
		List<Njiva> rezultati = em
				.createQuery(
						"FROM Njiva n where n.parcela.poljoprivrednoGazdinstvo.id= :brojGazd")
				.setParameter("brojGazd", gazdinstvoId).getResultList();

		return rezultati;

	}

	@Override
	public Njiva updateNjiva(Njiva njiva) {
		
		Njiva stara = em.find(Njiva.class, njiva.getNjivaId());
		stara.setKultura(njiva.getKultura());
		stara.setParcela(njiva.getParcela());
		stara.setPrinos(njiva.getPrinos());
		stara.setSezona(njiva.getSezona());
		
		em.persist(stara);
		
		return stara;
	}

	@Override
	public boolean deleteNjiva(Long njivaId) {
		
		Njiva toDelete = em.find(Njiva.class, njivaId);
		if(toDelete!=null){
			em.remove(toDelete);
			return true;
		}
		return false;
	}

	@Override
	public Njiva findNjivaById(Long njivaId) {
		// TODO Auto-generated method stub
		return em.find(Njiva.class, njivaId);
	}
	
}
