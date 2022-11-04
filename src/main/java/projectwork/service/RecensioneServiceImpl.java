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
		return recensioneDao.findByDestinazione(destinazione);
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
	public List<Recensione> findByPubblicato(int pubblicato) {
		return recensioneDao.findByPubblicato(pubblicato);
	}

	@Override
	public List<Recensione> findByAccount(Account account) {
		return recensioneDao.findByAccount(account);
	}

	@Override
	public List<Recensione> findByAccountANDPubblicato(Account account, int pubblicato) {
		List<Recensione> recensioni = new ArrayList<>();
		
		for (Recensione recensione : recensioneDao.findByAccount(account)) {
			if(recensione.getPubblicato() == pubblicato) {
				recensioni.add(recensione);
			}
		}
		
		return recensioni;
		
	}

	@Override
	public Recensione findRecensioneInListById(List<Recensione> lista, int id) {
		Recensione recensione = null;
		
		for (Recensione r: lista) {
			if(r.getId() == id) {
				recensione = r;
				break;
			}		
	}
		return recensione;

	}

	@Override
	public Recensione findById(int id) {
		return recensioneDao.findById(id).get();
	}
}
