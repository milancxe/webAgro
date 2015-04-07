package webAgro.core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import webAgro.core.models.entities.Lager;
import webAgro.core.models.entities.Parcela;
import webAgro.core.repositories.LagerRepo;

@Repository
public class LagerRepoImpl implements LagerRepo {

	@PersistenceContext
	EntityManager em;

	@Override
	public Lager createLager(Lager lager) {

		em.persist(lager);

		return lager;
	}

	@Override
	public List<Lager> getAll(Long brojGazdinstva) {

		List<Lager> rezultati = em
				.createQuery(
						"FROM Lager l where l.poljoprivrednoGazdinstvo.id= :brojGazd")
				.setParameter("brojGazd", brojGazdinstva).getResultList();

		return rezultati;
	}

	@Override
	public boolean deleteLager(Long lagerId) {
		// TODO Auto-generated method stub

		Lager toDelete = em.find(Lager.class, lagerId);

		if (toDelete != null) {
			em.remove(toDelete);
		}

		return false;
	}

	@Override
	public Lager updateLager(Lager lager) {
		// TODO Auto-generated method stub
		Lager stari = em.find(Lager.class, lager.getId());
		stari.setGodina(lager.getGodina());
		stari.setKolicina(lager.getKolicina());
		stari.setKultura(lager.getKultura());
		em.persist(stari);
		return stari;
	}

}
