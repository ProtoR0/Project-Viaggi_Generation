package projectwork.service;

import java.util.List;

import projectwork.model.Account;

public interface AccountService {

	void saveAccount(Account account);
	Account findByUsername(String username);
	List<Account> findAll();
} 
