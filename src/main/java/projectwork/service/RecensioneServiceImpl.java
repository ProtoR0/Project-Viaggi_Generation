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

}
