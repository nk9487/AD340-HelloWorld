package com.example.helloworld;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class WelcomeTest {

    @Rule
    public ActivityScenarioRule<Welcome> activityScenarioRule
            = new ActivityScenarioRule<>(Welcome.class);

    /*@Test
    public void hasTextOnScreen() {
        onView(withId(R.id.thank_you_user))
                .check(matches(withText(R.string.thanks_message + Constants.USER_NAME_KEY)));
    }*/
    @Test
    public void clickingOnBack() {
        onView(withId(R.id.welcome_button_back)).perform(click());

    }
}
