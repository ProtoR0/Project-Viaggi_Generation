package projectwork.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import projectwork.model.Account;
import projectwork.model.Recensione;

public interface RecensioneDao extends CrudRepository<Recensione, Integer>{
	
	List<Recensione> findByDestinazione(String destinazione);
	List<Recensione> findByPubblicato(boolean pubblicato);
 	List<Recensione> findByAccount(Account account);
	
}
