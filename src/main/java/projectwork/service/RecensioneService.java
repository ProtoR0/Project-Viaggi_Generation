package projectwork.service;

import java.util.List;

import projectwork.model.Recensione;

public interface RecensioneService {
	
	List<Recensione> findByDestinazione(String destinazione);
	List<Recensione> findByPubblicato(boolean pubblicato);
	void deleteRecensione(Recensione recensione);
	void saveRecensione(Recensione recensione);
	List<Recensione> findAll();
}
