package com.sirialkillers.shoponthego;

/**
 * Created by User on 29-Oct-17.
 */

import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNull.notNullValue;
@MediumTest
@RunWith(AndroidJUnit4.class)
public class MenuActivityEspressoTest {

    @Rule
    public IntentsTestRule<MenuActivity> mActivityTestRule = new IntentsTestRule<>(MenuActivity.class);

    @Test
    public void triggerIntentTest() {
        // check that the button is there
        Espresso.onView(withId(R.id.buttonMap)).check(matches(notNullValue() ));
        Espresso.onView(withId(R.id.buttonMap)).perform(click());
        intended(hasComponent(MapsActivity.class.getName()));
    }
}
