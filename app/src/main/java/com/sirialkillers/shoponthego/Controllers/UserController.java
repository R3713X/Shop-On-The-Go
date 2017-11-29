package com.sirialkillers.shoponthego.Controllers;

import android.util.Log;

import com.sirialkillers.shoponthego.Models.UserModel;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 29/11/2017
 *
 */
public class UserController {
    /* Rest Template is a template that is given by Spring Framework */
    private RestTemplate restTemplate = new RestTemplate();

    /* params is a Hash Map used to set the parameters that are going to be used
     in the Rest Template */
    private Map<String, String> params = new HashMap<>();

    /* Default values. */
    private UserModel defaultUser;

    /**
     * Initializes the default values and the Rest template that adds a
     * Jackson message converter so it can parse
     * a JSON file.
     */
    public UserController() {
        defaultUser = new UserModel("-1");
        params = new HashMap<>();
        restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    /**
     * Fetches a list of users.
     * @return the list of users
     */
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();

        try{
            final String url = "http://83.212.106.80/users";

            users.addAll(restTemplate.getForObject(url, UserModel.class));
            return users;
        }catch(Exception e){
            Log.e("getUsers", e.getMessage(),e);
        }
        return users;
    }

    /**
     * Fetches a user.
     * @param userId the user Id to match.
     * @return a user.
     */
    public UserModel getUser(String userId){
        try {
            final String url = "http://83.212.106.80/users/{userId}";

            params.clear();
            params.put("userId", userId);

            UserModel user = restTemplate.getForObject(url, UserModel.class, params);
            return user;
        }catch (Exception e){
            Log.e("getUserById", e.getMessage(),e);
        }
        return defaultUser;
    }

    /**
     * Deletes a user.
     * @param userId the user Id that will get deleted.
     */
    public void deleteUser(String userId){
        try {
            final String url = "http://83.212.106.80/user/{userId}";

            params.clear();
            params.put("userId", userId);

            restTemplate.delete(url, params);
        }catch (Exception e){
            Log.e("deleteUser", e.getMessage(),e);
        }
    }

    /**
     * Adds a user.
     * @param user the user that will get added.
     * @return the user that was added.
     */
    public UserModel addUser(UserModel user){
        try {
            final String url = "http://83.212.106.80/users";
            UserModel userThatWasCreated = restTemplate.postForObject(url, user, UserModel.class);
            return userThatWasCreated;

        }catch (Exception e){
            Log.e("addUser", e.getMessage(),e);
        }
        return defaultUser;
    }

    /**
     * Updates an already existing user.
     * @param userId the user Id that will get updated.
     * @param user the user that will replace the old one.
     */
    public void updateUser(String userId, UserModel user){
        try {
            final String url = "http://83.212.106.80/users/{userId}";

            params.clear();
            params.put("userId", userId);

            restTemplate.put(url, user, params);
        }catch (Exception e) {
            Log.e("updateUser", e.getMessage(), e);
        }
    }
}
