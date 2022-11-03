package projectwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectwork.dao.RecensioneDao;
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
	public List<Recensione> findByPubblicato(boolean pubblicato) {
		return recensioneDao.findByPubblicato(pubblicato);
	}

}