package com.shoponthego.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	
	@RequestMapping("/accounts/{id}")
	public Account getOfferById(@PathVariable int id) {
		return accountService.getAccountById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/accounts")
	public void addAccount(@RequestBody Account newAccount) {
		for (Account account : accountService.getAllAccounts()) {
			if(account.getUsername().equalsIgnoreCase(newAccount.getUsername()) ) {
				// TODO: manage what to do if the username already exists
			}
			else {
				accountService.addAccount(newAccount);
			}
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/accounts/{id}")
	public void updateAccount(@RequestBody Account account, @PathVariable int id) {
		accountService.updateAccount(id, account);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/accounts/{id}")
	public void deleteAccount(@PathVariable int id) {
		accountService.deleteAccount(id);
	}
}
