package com.sirialkillers.shoponthego.Controllers;

import android.util.Log;

import com.sirialkillers.shoponthego.Models.AccountModel;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 28/11/2017
 *
 */
public class AccountController {
    /* Rest Template is a template that is given by Spring Framework */
    private RestTemplate restTemplate = new RestTemplate();

    /* params is a Hash Map used to set the parameters that are going to be used
     in the Rest Template */
    private Map<String, String> params = new HashMap<>();

    /* Default values. */
    private AccountModel defaultAccount;

    /**
     * Initializes the default values and the Rest template that adds a
     * Jackson message converter so it can parse
     * a JSON file.
     */
    public AccountController() {
        defaultAccount = new AccountModel("-1");
        params = new HashMap<>();
        restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    /**
     * Creates a new account for a user.
     * @param account the user account that will be created.
     * @return the account that was created if it was successfully
     * created or the default account that is set to define that
     * something did not go as well.
     */
    public AccountModel createAccount(AccountModel account){
            try {
                final String url = "http://83.212.106.80/accounts";

                AccountModel accountThatWasCreated = restTemplate.postForObject(url, account, AccountModel.class);
                return accountThatWasCreated;
            }catch (Exception e){
                Log.e("createAccount", e.getMessage(),e);
            }
            return defaultAccount;
    }

    /**
     * Will update an already existing account.
     * @param accountId the account Id that will get updated.
     * @param account the account that will replace the old one.
     */
    public void updateAccount(String accountId, AccountModel account){
        try {
            final String url = "http://83.212.106.80/accounts/{accountId}";

            params.clear();
            params.put("accountId", accountId);

            restTemplate.put(url, account, params);
        }catch (Exception e) {
            Log.e("updateAccount", e.getMessage(), e);
        }
    }

    /**
     * Will delete an already existing account.
     * @param accountId the account id that will get deleted.
     */
    public void deleteAccount(String accountId){
        try {
            final String url = "http://83.212.106.80/accounts/{accountId}";

            params.clear();
            params.put("accountId", accountId);

            restTemplate.delete(url, params);
        }catch (Exception e){
            Log.e("deleteAccount", e.getMessage(),e);
        }
    }
}
