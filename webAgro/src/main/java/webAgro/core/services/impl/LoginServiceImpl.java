package webAgro.core.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webAgro.core.models.entities.Zaposleni;
import webAgro.core.repositories.ZaposleniRepo;
import webAgro.core.services.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private ZaposleniRepo zaposleniRepo;
	@Override
	public Zaposleni loginKorisnika(Long brojGazdinstva, String sifra) {
		// TODO Auto-generated method stub
		Zaposleni korisnik=zaposleniRepo.findZaposleniLogin(brojGazdinstva, sifra);
		System.out.println(korisnik.getIme());
		System.out.println(korisnik.getSifra());
		System.out.println("obrade"+korisnik.getObrade());
		System.out.println("parcele"+korisnik.getParcele());
		System.out.println("poljoprivrednoGazdnistvo"+korisnik.getPoljoprivrednoGazdinstvo().getId());
		return korisnik;
	}
	

}
