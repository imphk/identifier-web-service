package app.identifier;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.*;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class IdentifierUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void test01() {

        onView(withId(R.id.input)).perform(typeText("abc"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.validateBtn)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Valid")));
    }

    @Test
    public void test02() {
        onView(withId(R.id.input)).perform(typeText(" abc"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.validateBtn)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Invalid")));
    }

    @Test
    public void test03() {
        onView(withId(R.id.input)).perform(typeText("0"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.validateBtn)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Invalid")));
    }

    @Test
    public void test04() {
        onView(withId(R.id.input)).perform(typeText("14ab"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.validateBtn)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Invalid")));
    }

    @Test
    public void test05() {
        onView(withId(R.id.label)).check(matches(isDisplayed()));
        onView(withId(R.id.input)).check(matches(isDisplayed()));
        onView(withId(R.id.output)).check(matches(isDisplayed()));
        onView(withId(R.id.validateBtn)).check(matches(isDisplayed()));
    }
}

