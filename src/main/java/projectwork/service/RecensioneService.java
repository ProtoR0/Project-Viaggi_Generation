package projectwork.service;

import java.util.List;

import projectwork.model.Recensione;

public interface RecensioneService {
	
	List<Recensione> findByDestinazione(String destinazione);
}
