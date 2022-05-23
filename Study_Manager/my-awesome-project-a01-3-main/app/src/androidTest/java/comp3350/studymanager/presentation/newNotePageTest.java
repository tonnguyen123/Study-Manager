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
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.studymanager.Object.User;
import comp3350.studymanager.Persistence.userPersistence;
import comp3350.studymanager.R;
import comp3350.studymanager.logic.AccessServices;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class newNotePageTest {

    @Rule
    public ActivityTestRule<signInPage> mActivityTestRule = new ActivityTestRule<>(signInPage.class);
    @Before
    public void setupDatabase() {
        // clear user from user db
        userPersistence userdb = AccessServices.getRegisterInterface();
        User user = new User("Xuh123", "Xuh123");

        userdb.deleteUser(user);
    }

    @Test
    public void newNotePageTest() {
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
        appCompatEditText.perform(ViewActions.replaceText("Xuh123"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.registerPass),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        appCompatEditText2.perform(ViewActions.replaceText("Xuh123"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.retypePass),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        appCompatEditText3.perform(ViewActions.replaceText("Xuh123"), ViewActions.closeSoftKeyboard());

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
        appCompatEditText4.perform(ViewActions.replaceText("Xuh123"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.input_Password),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText5.perform(ViewActions.replaceText("Xuh123"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.signBtn), ViewMatchers.withText("sign_in"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        materialButton3.perform(ViewActions.click());

        ViewInteraction materialButton4 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.addBtn), ViewMatchers.withText("add"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        materialButton4.perform(ViewActions.click());

        ViewInteraction materialButton5 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.nextPagebtn), ViewMatchers.withText("go_to_next_page"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.spinnerSemselection),
                                        childAtPosition(
                                                ViewMatchers.withId(android.R.id.content),
                                                0)),
                                2),
                        ViewMatchers.isDisplayed()));
        materialButton5.perform(ViewActions.click());

        ViewInteraction button = Espresso.onView(
                Matchers.allOf(ViewMatchers.withText("4420\nAdvanced Design and Analysis of Algorithms"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.linearLayout),
                                        childAtPosition(
                                                ViewMatchers.withId(R.id.relativeLayout),
                                                0)),
                                0)));
        button.perform(ViewActions.scrollTo(), ViewActions.click());

        ViewInteraction actionMenuItemView = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.courselist), ViewMatchers.withContentDescription("courseList"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(androidx.appcompat.R.id.action_bar),
                                        1),
                                1),
                        ViewMatchers.isDisplayed()));
        actionMenuItemView.perform(ViewActions.click());

        ViewInteraction button2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withText("Analysis of Algorithms\nAvery Miller\nA01"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.relativeLayout),
                                        childAtPosition(
                                                ViewMatchers.withId(android.R.id.content),
                                                0)),
                                0),
                        ViewMatchers.isDisplayed()));
        button2.perform(ViewActions.click());

        ViewInteraction materialButton6 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button7), ViewMatchers.withText("Notes"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        materialButton6.perform(ViewActions.click());

        ViewInteraction appCompatImageView = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.add), ViewMatchers.withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatImageView.perform(ViewActions.click());

        ViewInteraction appCompatEditText6 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.note_content),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText6.perform(ViewActions.replaceText("111"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatImageView2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.note_save),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withClassName(Matchers.is("android.widget.LinearLayout")),
                                        4),
                                1),
                        ViewMatchers.isDisplayed()));
        appCompatImageView2.perform(ViewActions.click());
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
