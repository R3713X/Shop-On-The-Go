package com.sirialkillers.shoponthego.Models;

/**
 * @author Ioakeim James Theologou
 * @version 28/10/2017
 *
 */
public class AccountModel {
    private String accountId;
    private String username;
    private String password;
    private String email;

    public AccountModel(String accountId, String username, String password, String email) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
