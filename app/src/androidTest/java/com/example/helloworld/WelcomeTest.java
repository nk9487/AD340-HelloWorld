
package com.example.helloworld;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static com.example.helloworld.RecyclerViewMatcher.withRecyclerView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class WelcomeTest {
    @Rule
    public ActivityScenarioRule<Welcome> welcomeScreenActivity;

    {
        welcomeScreenActivity = new ActivityScenarioRule<>(Welcome.class);
    }

    @Test
    public void clickingOnMatchesDrawerItemDisplaysMatchesFragment() {
        onView(withContentDescription("open navigation drawer")).perform(click());
        onView(withId(R.id.matches_menu_item)).perform(click());


        onView(withRecyclerView(R.id.recycler_view).atPosition(0))
                .check(matches(hasDescendant(withText("Alex1"))));

    }
}