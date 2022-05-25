
package com.example.helloworld;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class WelcomeTest {
    @Rule
    public ActivityScenarioRule<Welcome> welcomeScreenActivity =
            new ActivityScenarioRule<>(Welcome.class);


    @Test
    public void clickingOnMatchesDrawerItemDisplaysMatchesFragment() {
        /*onView(withContentDescription("open navigation drawer")).perform(click());
        onView(withId(R.id.matches_menu_item)).perform(click());

        onView(isRoot()).perform(HelpersViewMatcher.waitView(withText("Cool Guy Mike"), 5000));

        onView(withRecyclerView(R.id.recycler_view).atPosition(0))
                .check(matches(hasDescendant(withText("Cool Guy Mike"))));*/

    }

    /*Test for setting.
        @Test
    public void clickingOnSettingsDrawerItemDisplaysSettingsFragment() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.settings_menu_item)).perform(click());

        onView(withId(R.id.matches_reminder_time_label)).check(
                matches(withText("Pick your daily matches reminder time")));
    }

    * */
}