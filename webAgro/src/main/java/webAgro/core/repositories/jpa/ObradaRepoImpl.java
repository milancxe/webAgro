package webAgro.core.repositories.jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import webAgro.core.models.entities.Obrada;
import webAgro.core.models.entities.Zaposleni;
import webAgro.core.repositories.ObradaRepo;

@Repository
public class ObradaRepoImpl implements ObradaRepo{

	@PersistenceContext
	EntityManager em;

	@Override
	public Obrada createObrada(Obrada obrada) {
		em.persist(obrada);
		return obrada;
	}

	@Override
	public List<Obrada> getAll(Long gazdinstvoId) {
		
		List<Object[]> tuples = (List<Object[]>) em.createQuery("from Obrada o join o.zaposleni z where z.poljoprivrednoGazdinstvo.id= :brojGazd")
				.setParameter("brojGazd", gazdinstvoId)
				.getResultList();
		List<Obrada> sveObrade = new ArrayList<>();
		for(Object[] tuple : tuples) {
		    Obrada o = (Obrada) tuple[0];
		    sveObrade.add(o);
		    System.out.println(o.getVrstaObrade());
		}
			
		return sveObrade;
	}

	@Override
	public Obrada updateObrada(Obrada obrada) {
		
		Obrada stara = em.find(Obrada.class, obrada.getId());
		stara.setNapomena(obrada.getNapomena());
		stara.setDatum(obrada.getDatum());
		stara.setVrstaObrade(obrada.getVrstaObrade());
		stara.setNjive(obrada.getNjive());
		stara.setPrikljucneMasine(obrada.getPrikljucneMasine());
		stara.setZaposleni(obrada.getZaposleni());
		stara.setVozila(obrada.getVozila());
		em.persist(stara);
		return stara;
	}

	@Override
	public boolean deleteObrada(Long obradaId) {
		// TODO Auto-generated method stub
		Obrada toDelete = em.find(Obrada.class, obradaId);
		if(toDelete!=null){
			em.remove(toDelete);
			return true;
		}
		
		return false;
	}
	
	
	
}
