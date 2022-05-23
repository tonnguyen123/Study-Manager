package comp3350.studymanager.presentation;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.studymanager.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class signInPageTest2 {

    @Rule
    public ActivityTestRule<signInPage> mActivityTestRule = new ActivityTestRule<>(signInPage.class);

    @Test
    public void signInPageTest2() {
        ViewInteraction materialButton = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.registerBtn), ViewMatchers.withText("register"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                4),
                        ViewMatchers.isDisplayed()));
        materialButton.perform(ViewActions.click());

        ViewInteraction appCompatEditText = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.registerUsername),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText.perform(ViewActions.replaceText("Akash@5441"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.registerPass),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        appCompatEditText2.perform(ViewActions.replaceText("Akash@5441"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.retypePass),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        appCompatEditText3.perform(ViewActions.replaceText("Akash@5441"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.registerAccountButton), ViewMatchers.withText("register_account"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                4),
                        ViewMatchers.isDisplayed()));
        materialButton2.perform(ViewActions.click());

        ViewInteraction appCompatEditText4 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.input_userName),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                1),
                        ViewMatchers.isDisplayed()));
        appCompatEditText4.perform(ViewActions.replaceText("Akash@5441"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.input_Password),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText5.perform(ViewActions.replaceText("Akash@5441"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.signBtn), ViewMatchers.withText("sign_in"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        materialButton3.perform(ViewActions.click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
