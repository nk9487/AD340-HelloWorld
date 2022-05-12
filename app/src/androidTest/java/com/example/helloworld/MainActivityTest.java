package com.example.helloworld;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.helloworld.R.id;

import android.widget.DatePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void hasTextOnScreen() {
        onView(withId(id.intro))
                .check(matches(withText(R.string.Author_Info)));
    }


//    @Test
//    public void canGoThroughForm() {
//        onView(withId(id.full_name_field)).perform(replaceText("Namuna kassaye"));
//        onView(withId(id.email_field)).perform(replaceText("abcd@gmail.com"));
//        onView(withId(id.user_name_field)).perform(replaceText("Namuna"));
//        onView(withId(id.description_field)).perform(replaceText("I dont know"));
//        onView(withId(id.occupation_field)).perform(replaceText("AD Student"));
//
//        onView(withId(id.activity_date_picker)).perform(click());
//
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
//                .perform(PickerActions.setDate(2000, 2 + 1, 5));
//
//        onView(withId(android.R.id.button1)).perform(click());
//
//        onView(withId(id.submit_form)).perform(click());
//
//        onView(withId(id.user_name_field))
//                .check(matches(withText("Namuna")));
//    }

    @Test
    public void cannotGoThroughFormWithMissingName() {
        onView(withId(R.id.email_field)).perform(replaceText("abcd@gmail.com"));
        onView(withId(R.id.user_name_field)).perform(replaceText("Namuna"));
        onView(withId(R.id.description_field)).perform(replaceText("I am a cool person"));
        onView(withId(R.id.occupation_field)).perform(replaceText("AD Student"));

        onView(withId(R.id.activity_date_picker)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submit_form)).perform(click());

        onView(withText("Namuna Kassaye")).check(doesNotExist());
    }



    @Test
    public void cannotGoThroughFormWithMissingEmail() {
        onView(withId(R.id.full_name_field)).perform(replaceText("Namuna Kassaye"));
        onView(withId(R.id.user_name_field)).perform(replaceText("Namuna"));
        onView(withId(R.id.description_field)).perform(replaceText("I am a cool person"));
        onView(withId(R.id.occupation_field)).perform(replaceText("AD Student"));

        onView(withId(R.id.activity_date_picker)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submit_form)).perform(click());

        onView(withText("abcd@gmail.com")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingUsername() {
        onView(withId(R.id.full_name_field)).perform(replaceText("Namuna Kassaye"));
        onView(withId(R.id.email_field)).perform(replaceText("abcd@gmail.com"));
        onView(withId(R.id.description_field)).perform(replaceText("I am a cool person"));
        onView(withId(R.id.occupation_field)).perform(replaceText("AD Student"));

        onView(withId(R.id.activity_date_picker)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submit_form)).perform(click());

        onView(withText("Namuna")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingDescription() {
        onView(withId(R.id.full_name_field)).perform(replaceText("Namuna Kassaye"));
        onView(withId(R.id.email_field)).perform(replaceText("abcd@gmail.com"));
        onView(withId(R.id.user_name_field)).perform(replaceText("Namuna"));
        onView(withId(R.id.occupation_field)).perform(replaceText("AD Student"));

        onView(withId(R.id.activity_date_picker)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submit_form)).perform(click());

        onView(withText("I am a cool person")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingOccupation() {
        onView(withId(R.id.full_name_field)).perform(replaceText("Namuna Kassaye"));
        onView(withId(R.id.email_field)).perform(replaceText("abcd@gmail.com"));
        onView(withId(R.id.user_name_field)).perform(replaceText("Namuna"));
        onView(withId(R.id.description_field)).perform(replaceText("I am a cool person"));

        onView(withId(R.id.activity_date_picker)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submit_form)).perform(click());

        onView(withText("AD Student")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithBadEmail() {
        onView(withId(R.id.full_name_field)).perform(replaceText("Namuna Kassaye"));
        onView(withId(R.id.email_field)).perform(replaceText("foo@bar."));
        onView(withId(R.id.user_name_field)).perform(replaceText("Namuna"));
        onView(withId(R.id.description_field)).perform(replaceText("I am a cool person"));
        onView(withId(R.id.occupation_field)).perform(replaceText("AD Student"));

        onView(withId(R.id.activity_date_picker)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submit_form)).perform(click());

        onView(withText("abcd@gmail.com")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithYoungDob() {
        onView(withId(R.id.full_name_field)).perform(replaceText("Namuna Kassaye"));
        onView(withId(R.id.email_field)).perform(replaceText("abcd@gmail.com"));
        onView(withId(R.id.user_name_field)).perform(replaceText("Namuna"));
        onView(withId(R.id.description_field)).perform(replaceText("I am a cool person"));
        onView(withId(R.id.occupation_field)).perform(replaceText("AD Student"));

        onView(withId(R.id.activity_date_picker)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2021, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submit_form)).perform(click());

        onView(withText("3/5/2000")).check(doesNotExist());
    }

//    @Test
//    public void canGoBackFromWelcomeScreen() {
//        onView(withId(R.id.full_name_field)).perform(replaceText("Namuna Kassaye"));
//        onView(withId(R.id.email_field)).perform(replaceText("abcd@gmail.com"));
//        onView(withId(R.id.user_name_field)).perform(replaceText("Namuna"));
//        onView(withId(R.id.description_field)).perform(replaceText("I am a cool person"));
//        onView(withId(R.id.occupation_field)).perform(replaceText("AD Student"));
//
//        onView(withId(R.id.activity_date_picker)).perform(click());
//
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
//                .perform(PickerActions.setDate(2000, 2 + 1, 5));
//
//        onView(withId(android.R.id.button1)).perform(click());
//
//        onView(withId(R.id.submit_form)).perform(click());
//
//        onView(withId(id.full_name_field))
//                .check(matches(withText("Namuna Kassaye")));
//
//        onView(withId(id.welcome_button_back)).perform(click());
//
//        onView(withId(R.id.full_name_field)).check(matches(withText("")));
//    }

}