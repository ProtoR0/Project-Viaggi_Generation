package projectwork.service;

import java.util.List;

import projectwork.model.Account;
import projectwork.model.Recensione;

public interface RecensioneService {
	
	List<Recensione> findByDestinazione(String destinazione);
	List<Recensione> findByPubblicato(int pubblicato);
	void deleteRecensione(Recensione recensione);
	void saveRecensione(Recensione recensione);
	List<Recensione> findAll();
	List<Recensione> findByAccount(Account account);
	List<Recensione> findByAccountANDPubblicato(Account account, int pubblicato);
	List<Recensione> findByDestinazioneANDPubblicato(String locazione, int pubblicato);
	Recensione findRecensioneInListById(List<Recensione> lista, int id);
	Recensione findById(int id);
	int maxId();
	
}
