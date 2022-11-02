package projectwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectwork.dao.AccountDao;
import projectwork.model.Account;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account findByUsername(String username) {
		return accountDao.findByUsername(username);
	}

	@Override
	public void saveAccount(Account account) {
		accountDao.save(account);
		
	}

	@Override
	public List<Account> findAll() {
		return (List<Account>) accountDao.findAll();
	}
	
	
}
