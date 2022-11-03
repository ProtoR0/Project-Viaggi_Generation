package projectwork.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectwork.dao.RecensioneDao;
import projectwork.model.Account;
import projectwork.model.Recensione;

@Service
public class RecensioneServiceImpl implements RecensioneService{
	
	@Autowired
	private RecensioneDao recensioneDao;

	@Override
	public List<Recensione> findByDestinazione(String destinazione) {
		List<Recensione> recensioni = new ArrayList<>();
		List<Recensione> query = (List<Recensione>) recensioneDao.findAll();
		
		for (Recensione recensione : query) {
			if(recensione.getDestinazione().equals(destinazione))
				recensioni.add(recensione);
		}
		
		return recensioni;
	}

	@Override
	public void deleteRecensione(Recensione recensione) {
		recensioneDao.delete(recensione);
		
	}

	@Override
	public void saveRecensione(Recensione recensione) {
		recensioneDao.save(recensione);
		
	}

	@Override
	public List<Recensione> findAll() {
		return (List<Recensione>) recensioneDao.findAll();
	}

	@Override
	public List<Recensione> findByPubblicato(boolean pubblicato) {
		return recensioneDao.findByPubblicato(pubblicato);
	}

	@Override
	public List<Recensione> findByAccount(Account account) {
		return recensioneDao.findByAccount(account);
	}

	@Override
	public List<Recensione> findByAccountANDPubblicato(Account account) {
		List<Recensione> recensioni = new ArrayList<>();
		
		for (Recensione recensione : recensioneDao.findByAccount(account)) {
			if(recensione.isPubblicato() == false || recensione.isPubblicato()) {
				recensioni.add(recensione);
			}
		}
		
		return recensioni;
		
	}

}
