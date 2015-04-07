package webAgro.core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import webAgro.core.models.entities.Parcela;
import webAgro.core.repositories.ParcelaRepo;

@Repository
public class ParcelaRepoImpl implements ParcelaRepo{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Parcela saveParcela(Parcela parcela) {

		em.persist(parcela);
		return parcela;
	}

	@Override
	public List<Parcela> getAll(Long brojGazdinstva) {
		// TODO Auto-generated method stub
		
		List<Parcela> rezultati =  em.createQuery("FROM Parcela p where p.poljoprivrednoGazdinstvo.id= :brojGazd")
				.setParameter("brojGazd", brojGazdinstva)
				.getResultList();
	
		
		return rezultati;
	}

	@Override
	public Parcela updateParcela(Parcela parcela) {
		// TODO Auto-generated method stub
		Parcela stara = em.find(Parcela.class, parcela.getParcelniBroj());
		stara.setKategorija(parcela.getKategorija());
		stara.setParcelniBroj(parcela.getParcelniBroj());
		stara.setPotez(parcela.getPotez());
		stara.setKategorija(parcela.getKategorija());
		stara.setVlasnik(parcela.getVlasnik());
		em.persist(stara);
		return stara;
	}

	@Override
	public boolean deleteParcela(Long parcelniBroj) {

		Parcela toDelete = em.find(Parcela.class, parcelniBroj);

		if(toDelete!=null){
			em.remove(toDelete);
			return true;
		}else{ 
			return false;
		}
		
	}

	@Override
	public Parcela findParcela(Long parcelniBroj) {

		return em.find(Parcela.class, parcelniBroj);
	}

	@Override
	public Parcela getParcela(Long gazdinstvoId, Long parcelniBroj) {
		// TODO Auto-generated method stub
		return em.find(Parcela.class, parcelniBroj);
	}
	

}
