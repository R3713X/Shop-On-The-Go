package com.sirialkillers.shoponthego;

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

/**
 * Created by User on 05-Nov-17.
 */
@RunWith(AndroidJUnit4.class)
public class UiAutomatorTest {
    private UiDevice mDevice;

    @Before
    public void setUp() {
        mDevice=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();

        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);
    }

    @Test
    public void testApp() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject allAppsButton = mDevice.findObject(new UiSelector().descriptionContains("Apps List"));
        allAppsButton.clickAndWaitForNewWindow();

        UiObject toShopOnTheGoButton=mDevice.findObject(new UiSelector().text("Shop on the go"));
        toShopOnTheGoButton.clickAndWaitForNewWindow();

        UiObject emailEditText=mDevice.findObject(new UiSelector().text("Enter your Email"));
        emailEditText.setText("asdfsfga@yahoo.com");

        UiObject passwordEditText=mDevice.findObject(new UiSelector().text("Enter your Password"));
        passwordEditText.setText("asdfasf9");

        UiObject loginButton=mDevice.findObject(new UiSelector().text("LOGIN"));
        loginButton.clickAndWaitForNewWindow();

        UiObject menuButton=mDevice.findObject(new UiSelector().text("MENU"));
        menuButton.clickAndWaitForNewWindow();

        UiObject listOfNearbyShopsButton=mDevice.findObject(new UiSelector().text("GO TO LIST OF NEARBY SHOPS"));
        listOfNearbyShopsButton.clickAndWaitForNewWindow();

        UiObject searchButton=mDevice.findObject(new UiSelector().descriptionContains("search"));
        searchButton.click();

        UiObject searchEditText=mDevice.findObject(new UiSelector().resourceId("android:id/search_src_text"));
        searchEditText.setText("raf");

        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);

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
