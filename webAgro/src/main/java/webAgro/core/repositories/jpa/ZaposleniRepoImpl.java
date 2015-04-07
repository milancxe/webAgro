package webAgro.core.repositories.jpa;


import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import webAgro.core.models.entities.Zaposleni;
import webAgro.core.repositories.ZaposleniRepo;

@Repository
public class ZaposleniRepoImpl implements ZaposleniRepo{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Zaposleni findZaposleni(Long id) {
		// TODO Auto-generated method stub
		return em.find(Zaposleni.class,id);
	}

	@Override
	public Zaposleni createZaposleni(Zaposleni data) {
        em.persist(data);
        return data;
	}

	@Override
	public Zaposleni updateZaposleni(Zaposleni data) {
		// TODO Auto-generated method stub
		Zaposleni stari = em.find(Zaposleni.class, data.getId());
		stari.setIme(data.getIme());
		stari.setPrezime(data.getPrezime());
		stari.setSifra(data.getSifra());
		em.persist(stari);
		return stari;
	}

	
	@Override
	public Zaposleni findZaposleniLogin(Long brojGazdinstva, String sifra) {
		// TODO Auto-generated method stub
		System.out.println("trazim"+brojGazdinstva+sifra);
		List<Zaposleni> rezultati =  em.createQuery("FROM Zaposleni z where z.poljoprivrednoGazdinstvo.id= :brojGazd and z.sifra=:sifra")
		.setParameter("brojGazd", brojGazdinstva)
		.setParameter("sifra", sifra)
		.getResultList();
		Zaposleni zap;
		Iterator it = rezultati.iterator();
		if(it.hasNext()){

			zap= (Zaposleni) it.next();
			return zap;
		}
		System.out.println("vracam null");
		return null;
	}

	@Override
	public List<Zaposleni> getAll(Long gazdinstvoId) {
		
		List<Zaposleni> rezultati =  em.createQuery("FROM Zaposleni z where z.poljoprivrednoGazdinstvo.id= :brojGazd ")
				.setParameter("brojGazd", gazdinstvoId)
				.getResultList();
		
		
		return rezultati;
	}

	@Override
	public boolean deleteZaposleni(Long zapId) {
		
		Zaposleni toDelete = em.find(Zaposleni.class,zapId);
		
		if(toDelete!=null){
			em.remove(toDelete);
			return true;
		}
		
		return false;
	}

	
}
