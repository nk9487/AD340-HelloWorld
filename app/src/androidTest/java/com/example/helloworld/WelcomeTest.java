package com.example.helloworld;

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
//        onView(withContentDescription("Open navigation drawer")).perform(click());
//        onView(withId(R.id.matches_menu_item)).perform(click());
//
//        onView(isRoot()).perform(HelpersViewMatcher.waitView(withText("Cool Guy Mike"), 5000));
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(0))
//                .check(matches(hasDescendant(withText("Cool Guy Mike"))));
   }
}

