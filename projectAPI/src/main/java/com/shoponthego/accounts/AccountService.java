package com.shoponthego.accounts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	private List<Account> accounts = new ArrayList<>();
	
	public List<Account> getAllAccounts() {
		return accounts;
	}

	public Account getAccountById(int id) {
		for (Account account : accounts) {
			if(account.getId()== id) {
				return account;
			}
		}
		return null;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public void updateAccount(int id, Account newAccount) {
		for(int i=0; i<accounts.size(); i++) {
			Account account = accounts.get(i);
			if(account.getId()==id) {
				accounts.set(i, newAccount);
				return;
			}
		}		
	}

	public void deleteAccount(int id) {
		for(int i=0; i<accounts.size(); i++) {
			Account account = accounts.get(i);
			if(account.getId()==id) {
				accounts.remove(account);
				return;
			}
		}		
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
}
