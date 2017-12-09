package com.sirialkillers.shoponthego;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Giannis on 8/12/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AddShopUIAutomatorTest {
    private UiDevice mDevice;

    @Before
    public void setUp() {
        mDevice=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();

        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);


    }
    @Test
    public void checkIfEverythingWorksInAddShop() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();

        UiObject titleEditText=mDevice.findObject(new UiSelector().text("Title"));
        titleEditText.setText("Super Something");

        UiObject selectCategoryButton=mDevice.findObject(new UiSelector().text("Select the Shops Categories"));
        selectCategoryButton.clickAndWaitForNewWindow();

        UiObject selectCategoryA=mDevice.findObject(new UiSelector().text("Clothes"));
        selectCategoryA.click();

        UiObject selectCategoryB=mDevice.findObject(new UiSelector().text("Electronics"));
        selectCategoryB.click();

        UiObject selectOK=mDevice.findObject(new UiSelector().text("OK"));
        selectOK.clickAndWaitForNewWindow();

        UiObject selectAddressButton=mDevice.findObject(new UiSelector().text("Select the Shops Address"));
        selectAddressButton.clickAndWaitForNewWindow();

        UiObject selectLocationButton=mDevice.findObject(new UiSelector().text("Select this location"));
        selectLocationButton.click();

        UiObject selectLocationButtonB=mDevice.findObject(new UiSelector().text("SELECT"));
        selectLocationButtonB.clickAndWaitForNewWindow();

        UiObject addPhotoButton=mDevice.findObject(new UiSelector().text("ADD A PHOTO"));
        addPhotoButton.clickAndWaitForNewWindow();

        UiObject galleryButton=mDevice.findObject(new UiSelector().text("Gallery"));
        galleryButton.clickAndWaitForNewWindow();

        UiObject downloadFolderButton=mDevice.findObject(new UiSelector().text("Download"));
        downloadFolderButton.clickAndWaitForNewWindow();

        UiObject clickPicture=mDevice.findObject(new UiSelector().descriptionContains("Photo"));
        clickPicture.clickAndWaitForNewWindow();

        UiObject submitShopButton=mDevice.findObject(new UiSelector().text("SAVE"));
        submitShopButton.clickAndWaitForNewWindow();


    }


    @Test
    public void checkIfNoTitleStops() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();


        UiObject selectCategoryButton=mDevice.findObject(new UiSelector().text("Select the Shops Categories"));
        selectCategoryButton.clickAndWaitForNewWindow();

        UiObject selectCategoryA=mDevice.findObject(new UiSelector().text("Clothes"));
        selectCategoryA.click();

        UiObject selectCategoryB=mDevice.findObject(new UiSelector().text("Electronics"));
        selectCategoryB.click();

        UiObject selectOK=mDevice.findObject(new UiSelector().text("OK"));
        selectOK.clickAndWaitForNewWindow();

        UiObject selectAddressButton=mDevice.findObject(new UiSelector().text("Select the Shops Address"));
        selectAddressButton.clickAndWaitForNewWindow();

        UiObject selectLocationButton=mDevice.findObject(new UiSelector().text("Select this location"));
        selectLocationButton.click();

        UiObject selectLocationButtonB=mDevice.findObject(new UiSelector().text("SELECT"));
        selectLocationButtonB.clickAndWaitForNewWindow();

        UiObject addPhotoButton=mDevice.findObject(new UiSelector().text("ADD A PHOTO"));
        addPhotoButton.clickAndWaitForNewWindow();

        UiObject galleryButton=mDevice.findObject(new UiSelector().text("Gallery"));
        galleryButton.clickAndWaitForNewWindow();

        UiObject downloadFolderButton=mDevice.findObject(new UiSelector().text("Download"));
        downloadFolderButton.clickAndWaitForNewWindow();

        UiObject clickPicture=mDevice.findObject(new UiSelector().descriptionContains("Photo"));
        clickPicture.clickAndWaitForNewWindow();

        UiObject submitShopButton=mDevice.findObject(new UiSelector().text("SAVE"));
        submitShopButton.clickAndWaitForNewWindow();


    }

    @Test
    public void checkIfNoAddressStops() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();

        UiObject titleEditText=mDevice.findObject(new UiSelector().text("Title"));
        titleEditText.setText("Super Something");

        UiObject selectCategoryButton=mDevice.findObject(new UiSelector().text("Select the Shops Categories"));
        selectCategoryButton.clickAndWaitForNewWindow();

        UiObject selectCategoryA=mDevice.findObject(new UiSelector().text("Clothes"));
        selectCategoryA.click();

        UiObject selectCategoryB=mDevice.findObject(new UiSelector().text("Electronics"));
        selectCategoryB.click();

        UiObject selectOK=mDevice.findObject(new UiSelector().text("OK"));
        selectOK.clickAndWaitForNewWindow();


        UiObject addPhotoButton=mDevice.findObject(new UiSelector().text("ADD A PHOTO"));
        addPhotoButton.clickAndWaitForNewWindow();

        UiObject galleryButton=mDevice.findObject(new UiSelector().text("Gallery"));
        galleryButton.clickAndWaitForNewWindow();

        UiObject downloadFolderButton=mDevice.findObject(new UiSelector().text("Download"));
        downloadFolderButton.clickAndWaitForNewWindow();

        UiObject clickPicture=mDevice.findObject(new UiSelector().descriptionContains("Photo"));
        clickPicture.clickAndWaitForNewWindow();

        UiObject submitShopButton=mDevice.findObject(new UiSelector().text("SAVE"));
        submitShopButton.clickAndWaitForNewWindow();


    }
    @Test
    public void checkIfNoCategoriesStops() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();

        UiObject titleEditText=mDevice.findObject(new UiSelector().text("Title"));
        titleEditText.setText("Super Something");


        UiObject selectAddressButton=mDevice.findObject(new UiSelector().text("Select the Shops Address"));
        selectAddressButton.clickAndWaitForNewWindow();

        UiObject selectLocationButton=mDevice.findObject(new UiSelector().text("Select this location"));
        selectLocationButton.click();

        UiObject selectLocationButtonB=mDevice.findObject(new UiSelector().text("SELECT"));
        selectLocationButtonB.clickAndWaitForNewWindow();

        UiObject addPhotoButton=mDevice.findObject(new UiSelector().text("ADD A PHOTO"));
        addPhotoButton.clickAndWaitForNewWindow();

        UiObject galleryButton=mDevice.findObject(new UiSelector().text("Gallery"));
        galleryButton.clickAndWaitForNewWindow();

        UiObject downloadFolderButton=mDevice.findObject(new UiSelector().text("Download"));
        downloadFolderButton.clickAndWaitForNewWindow();

        UiObject clickPicture=mDevice.findObject(new UiSelector().descriptionContains("Photo"));
        clickPicture.clickAndWaitForNewWindow();

        UiObject submitShopButton=mDevice.findObject(new UiSelector().text("SAVE"));
        submitShopButton.clickAndWaitForNewWindow();


    }

    @Test
    public void checkIfPhotoIsOptional() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();

        UiObject titleEditText=mDevice.findObject(new UiSelector().text("Title"));
        titleEditText.setText("Super Something");

        UiObject selectCategoryButton=mDevice.findObject(new UiSelector().text("Select the Shops Categories"));
        selectCategoryButton.clickAndWaitForNewWindow();

        UiObject selectCategoryA=mDevice.findObject(new UiSelector().text("Clothes"));
        selectCategoryA.click();

        UiObject selectCategoryB=mDevice.findObject(new UiSelector().text("Electronics"));
        selectCategoryB.click();

        UiObject selectOK=mDevice.findObject(new UiSelector().text("OK"));
        selectOK.clickAndWaitForNewWindow();

        UiObject selectAddressButton=mDevice.findObject(new UiSelector().text("Select the Shops Address"));
        selectAddressButton.clickAndWaitForNewWindow();

        UiObject selectLocationButton=mDevice.findObject(new UiSelector().text("Select this location"));
        selectLocationButton.click();

        UiObject selectLocationButtonB=mDevice.findObject(new UiSelector().text("SELECT"));
        selectLocationButtonB.clickAndWaitForNewWindow();


        UiObject submitShopButton=mDevice.findObject(new UiSelector().text("SAVE"));
        submitShopButton.clickAndWaitForNewWindow();


    }

    @Test
    public void checkIfDismissAndClearButtonOnCategoriesWork() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();

        UiObject titleEditText=mDevice.findObject(new UiSelector().text("Title"));
        titleEditText.setText("Super Something");

        UiObject selectCategoryButton=mDevice.findObject(new UiSelector().text("Select the Shops Categories"));
        selectCategoryButton.clickAndWaitForNewWindow();

        UiObject selectCategoryA=mDevice.findObject(new UiSelector().text("Clothes"));
        selectCategoryA.click();

        UiObject selectCategoryB=mDevice.findObject(new UiSelector().text("Electronics"));
        selectCategoryB.click();

        UiObject selectOK=mDevice.findObject(new UiSelector().text("OK"));
        selectOK.clickAndWaitForNewWindow();

        UiObject selectCategoryButtonB=mDevice.findObject(new UiSelector().text("Select the Shops Categories"));
        selectCategoryButtonB.clickAndWaitForNewWindow();

        UiObject ClearButton=mDevice.findObject(new UiSelector().text("CLEAR ALL"));
        ClearButton.clickAndWaitForNewWindow();

        UiObject selectCategoryButtonC=mDevice.findObject(new UiSelector().text("Select the Shops Categories"));
        selectCategoryButtonC.clickAndWaitForNewWindow();

        UiObject dismissButton=mDevice.findObject(new UiSelector().text("DISMISS"));
        dismissButton.clickAndWaitForNewWindow();


    }
    @Test
    public void checkIfOnlyTitle() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();

        UiObject titleEditText=mDevice.findObject(new UiSelector().text("Title"));
        titleEditText.setText("Super Something");


        UiObject submitShopButton=mDevice.findObject(new UiSelector().text("SAVE"));
        submitShopButton.clickAndWaitForNewWindow();


    }

    @Test
    public void checkIfOnlyCategoriesStops() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();

        UiObject selectCategoryButton=mDevice.findObject(new UiSelector().text("Select the Shops Categories"));
        selectCategoryButton.clickAndWaitForNewWindow();

        UiObject selectCategoryA=mDevice.findObject(new UiSelector().text("Clothes"));
        selectCategoryA.click();

        UiObject selectCategoryB=mDevice.findObject(new UiSelector().text("Electronics"));
        selectCategoryB.click();

        UiObject selectOK=mDevice.findObject(new UiSelector().text("OK"));
        selectOK.clickAndWaitForNewWindow();


        UiObject submitShopButton=mDevice.findObject(new UiSelector().text("SAVE"));
        submitShopButton.clickAndWaitForNewWindow();


    }

    @Test
    public void checkIfOnlyAddressStops() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();



        UiObject selectAddressButton=mDevice.findObject(new UiSelector().text("Select the Shops Address"));
        selectAddressButton.clickAndWaitForNewWindow();

        UiObject selectLocationButton=mDevice.findObject(new UiSelector().text("Select this location"));
        selectLocationButton.click();

        UiObject selectLocationButtonB=mDevice.findObject(new UiSelector().text("SELECT"));
        selectLocationButtonB.clickAndWaitForNewWindow();


        UiObject submitShopButton=mDevice.findObject(new UiSelector().text("SAVE"));
        submitShopButton.clickAndWaitForNewWindow();


    }
    @Test
    public void checkIfInputingNothingStops() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asd@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("123123123");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().resourceIdMatches("com.sirialkillers.shoponthego:id/menuButton"));
        menuButton.clickAndWaitForNewWindow();

        UiObject addShopButton=mDevice.findObject(new UiSelector().text("ADD SHOP"));
        addShopButton.clickAndWaitForNewWindow();

        

        UiObject submitShopButton=mDevice.findObject(new UiSelector().text("SAVE"));
        submitShopButton.clickAndWaitForNewWindow();


    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}