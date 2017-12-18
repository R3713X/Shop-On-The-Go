package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.UserModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ioakeim James Theologou
 * @version 02/11/2017
 *
 */
public class UserControllerTest {
    private MockMvc mockMvc;
    private UserModel user;
    private List<UserModel> users;
    private UserController userController;
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Before
    public void setUp() throws Exception {
        user = new UserModel("-1");
        userController = new UserController();
        users = Arrays.asList(
                new UserModel("50","John","Legend"),
                new UserModel("20","Taylor","Swift"));
    }

    @Test
    public void readOneUserAndCompareValues() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.userId", is(this.users.get(0).getUserId())))
                .andExpect(jsonPath("$.name", is(this.users.get(0).getName())))
                .andExpect(jsonPath("$.surname", is(this.users.get(0).getSurname())));
    }

    @Test
    public void readMultipleUsersAndCompareValues() throws Exception{
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$[0].userId", is(this.users.get(0).getUserId())))
                .andExpect(jsonPath("$[0].name", is(this.users.get(0).getName())))
                .andExpect(jsonPath("$[0].surname", is(this.users.get(0).getSurname())))
                .andExpect(jsonPath("$[1].userId", is(this.users.get(1).getUserId())))
                .andExpect(jsonPath("$[1].name", is(this.users.get(1).getName())))
                .andExpect(jsonPath("$[1].surname", is(this.users.get(1).getSurname())));
    }

    @Test
    public void checkThatTheRightUserGotReturned() throws Exception {
        userController.addUser(new UserModel("50","John","Legend"));
        UserModel userModel = userController.getUser("50");
        assertEquals(userModel.getUserId(), "50");
        assertEquals(userModel.getName(), "John");
        assertEquals(userModel.getSurname(), "Legend");
    }

    @Test
    public void deleteUser() throws Exception {
        userController.addUser(new UserModel("50","John","Legend"));
        userController.deleteUser("50");
        UserModel deletedUser = userController.getUser("50");
        //deleted user must contain the default user that defines something went wrong.
        assertEquals(deletedUser.getUserId(), "-1");
    }

    @Test
    public void checkThatUserGotAdded() throws Exception {
        userController.addUser(new UserModel("50","John","Legend"));
        UserModel newUser = userController.getUser("50");
        assertEquals(newUser.getUserId(), "50");
        assertEquals(newUser.getName(), "John");
        assertEquals(newUser.getSurname(), "Legend");
    }

    @Test
    public void checkThatUserGotUpdated() throws Exception {
        userController.addUser(new UserModel("50","John","Legend"));
        UserModel modifiedUser = new UserModel("50", "Havana", "Ulala");

        userController.updateUser("50", modifiedUser);
        UserModel fetchedUser = userController.getUser("50");

        assertEquals(fetchedUser.getUserId(),"50");
        assertEquals(fetchedUser.getName(), "Havana");
        assertEquals(fetchedUser.getSurname(), "Ulala");
    }

    @After
    public void tearDown() throws Exception {
        //TODO create a tearDown structure.
    }

}