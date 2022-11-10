package projectwork.service;

import java.util.List;

import projectwork.model.Account;

public interface AccountService {

	void saveAccount(Account account);
	Account findByUsername(String username);
	Account findById(int id);
	List<Account> findAll();
	void removeAccount(Account account);
} 
