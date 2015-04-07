package webAgro.core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import webAgro.core.models.entities.PoljoprivrednoGazdinstvo;
import webAgro.core.repositories.PoljoprivrednoGazdinstvoRepo;
@Repository
public class PoljoprivrednoGazdinstvoRepoImpl implements PoljoprivrednoGazdinstvoRepo {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public PoljoprivrednoGazdinstvo findPoljoprivrednoGazdinstvo(Long id) {

		return em.find(PoljoprivrednoGazdinstvo.class, id);
	}

	@Override
	public PoljoprivrednoGazdinstvo createPoljoprivrednoGazdinstvo(
			PoljoprivrednoGazdinstvo data) {
		
        em.persist(data);
        return data;
	}

	@Override
	public PoljoprivrednoGazdinstvo updatePoljoprivrednoGazdinstvo(Long id,
			PoljoprivrednoGazdinstvo data) {
		// TODO Auto-generated method stub
		return null;
	}

}
