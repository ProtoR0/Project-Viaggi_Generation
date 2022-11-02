package projectwork.dao;

import org.springframework.data.repository.CrudRepository;

import projectwork.model.Account;

public interface AccountDao extends CrudRepository<Account, Integer>{
	
	Account findByUsername(String username);
}
