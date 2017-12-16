package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.AccountModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
    public void checkForNullValuesWhenAskingForAnAccount(){
        AccountModel defaultAccount = accountController.getAccountById("1");
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

        accountController.updateAccount("150", modifiedAccount);
        AccountModel updatedAccount = accountController.getAccountById("150");

        assertNotEquals(updatedAccount.getEmail(), account.getEmail());
        assertEquals(updatedAccount.getEmail(), modifiedAccount.getEmail());
    }

    @Test
    public void checkThatTheAccountGotDeleted() throws Exception {
        //Should return the account that was supposedly created.
        AccountModel defaultAccount = accountController.createAccount(account);
        assertEquals(defaultAccount.getAccountId(), "150");

        //Should
        accountController.deleteAccount("150");
        AccountModel deletedAccount = accountController.getAccountById("150");
        assertEquals(deletedAccount.getAccountId(), "-1");
    }

    @After
    public void tearDown() throws Exception {
        //TODO create a tearDown structure.
    }

}