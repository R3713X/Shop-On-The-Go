package com.shoponthego.accounts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		accountRepository.findAll().forEach(accounts::add);;
		return accounts;
	}

	public Account getAccountById(int id) {
		return accountRepository.findOne(id);
	}

	public void addAccount(Account account) {
		accountRepository.save(account);
	}

	public void updateAccount(int id, Account newAccount) {
		accountRepository.save(newAccount);
	}

	public void deleteAccount(int id) {
		accountRepository.delete(id);
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
}
