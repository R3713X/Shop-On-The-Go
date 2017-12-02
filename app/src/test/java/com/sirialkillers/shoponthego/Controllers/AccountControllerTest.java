package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.AccountModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Ioakeim James Theologou
 * @version 01/11/2017
 *
 */
public class AccountControllerTest {
    private AccountModel account;
    private AccountController accountController;

    @Before
    public void setUp() throws Exception {
        account = new AccountModel("150", "random", "secure",
                "brownies@sweet.com");
        accountController = new AccountController();
    }

    @Test
    public void checkForNullValuesWhenCreatingAccount(){
       AccountModel defaultAccount = accountController.createAccount(account);
       assertNotNull(defaultAccount);
    }

    @Test
    public void checkThatTheAccountGotCreated() throws Exception {
        AccountModel accountThatGotReturned = accountController.createAccount(account);
        assertEquals(accountThatGotReturned.getAccountId(), "150");
        assertEquals(accountThatGotReturned.getUsername(), "random");
        assertEquals(accountThatGotReturned.getPassword(), "secure");
        assertEquals(accountThatGotReturned.getEmail(), "brownies@sweet.com");
    }

    @Test
    public void checkThatTheAccountGotUpdated() throws Exception {
        AccountModel modifiedAccount = new AccountModel("150", "random", "secure",
                "jellybeans@sweet.com");

        //TODO: Create a getAccountById() method in the AccountController to test this.
        accountController.updateAccount("150", modifiedAccount);
    }

    @Test
    public void checkThatTheAccountGotDeleted() throws Exception {
        //Should return the default account instead of creating a new one.
        AccountModel defaultAccount = accountController.createAccount(account);
        assertEquals(defaultAccount.getAccountId(), "-1");
        accountController.deleteAccount("150");
        //Should return the account that was supposedly created.
        AccountModel accountCreated = accountController.createAccount(account);
        assertEquals(accountCreated.getAccountId(), "150");
    }

    @After
    public void tearDown() throws Exception {
        //TODO create a tearDown structure.
    }

}