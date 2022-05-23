package comp3350.studymanager.presentation;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

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
public class CLASS_SCHEDULE_ACCEPTACE_TEST {

    @Rule
    public ActivityScenarioRule<signInPage> mActivityScenarioRule =
            new ActivityScenarioRule<>(signInPage.class);
    @Before
    public void setupDatabase() {
        // clear user from user db
        userPersistence userdb = AccessServices.getRegisterInterface();
        User user = new User("ton123", "ton123");
        userdb.deleteUser(user);
    }
    @Test
    public void classSchedule_AcceptanctTest() {
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
        appCompatEditText.perform(ViewActions.replaceText("ton123"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.registerPass),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        appCompatEditText2.perform(ViewActions.click());

        ViewInteraction appCompatEditText3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.registerPass),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        appCompatEditText3.perform(ViewActions.replaceText("ton123"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.retypePass),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        appCompatEditText4.perform(ViewActions.replaceText("ton123"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.registerAccountButton), ViewMatchers.withText("register_account"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                4),
                        ViewMatchers.isDisplayed()));
        materialButton2.perform(ViewActions.click());

        ViewInteraction appCompatEditText5 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.input_userName),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                1),
                        ViewMatchers.isDisplayed()));
        appCompatEditText5.perform(ViewActions.replaceText("ton123"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.input_Password),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText6.perform(ViewActions.replaceText("ton123"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.signBtn), ViewMatchers.withText("sign_in"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        materialButton3.perform(ViewActions.click());

        ViewInteraction appCompatEditText7 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.add_institution),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText7.perform(ViewActions.replaceText("UM"), ViewActions.closeSoftKeyboard());

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
                Matchers.allOf(ViewMatchers.withText("4190\nArtificial Intelligence"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.linearLayout),
                                        childAtPosition(
                                                ViewMatchers.withId(R.id.relativeLayout),
                                                0)),
                                3)));
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
                Matchers.allOf(ViewMatchers.withId(R.id.button6), ViewMatchers.withText("Calender"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        materialButton6.perform(ViewActions.click());

        ViewInteraction materialButton7 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.ButtonAdd), ViewMatchers.withText("Add info"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        materialButton7.perform(ViewActions.click());

        ViewInteraction materialTextView = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(android.R.id.title), ViewMatchers.withText("New Class/Exam"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        materialTextView.perform(ViewActions.click());

        ViewInteraction appCompatEditText8 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.MthSt),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                16),
                        ViewMatchers.isDisplayed()));
        appCompatEditText8.perform(ViewActions.replaceText("04"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.DaySt),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                17),
                        ViewMatchers.isDisplayed()));
        appCompatEditText9.perform(ViewActions.replaceText("20"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.YrSt),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                18),
                        ViewMatchers.isDisplayed()));
        appCompatEditText10.perform(ViewActions.replaceText("2022"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.MthEnd),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                19),
                        ViewMatchers.isDisplayed()));
        appCompatEditText11.perform(ViewActions.replaceText("05"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.DayEnd),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                20),
                        ViewMatchers.isDisplayed()));
        appCompatEditText12.perform(ViewActions.replaceText("20"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.YrEnd),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                21),
                        ViewMatchers.isDisplayed()));
        appCompatEditText13.perform(ViewActions.replaceText("2022"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.EditStartTime),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                5),
                        ViewMatchers.isDisplayed()));
        appCompatEditText14.perform(ViewActions.replaceText("1:30"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.EditEndTime),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                6),
                        ViewMatchers.isDisplayed()));
        appCompatEditText15.perform(ViewActions.replaceText("2:15"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialCheckBox = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.MonD), ViewMatchers.withText("mon"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                7),
                        ViewMatchers.isDisplayed()));
        materialCheckBox.perform(ViewActions.click());

        ViewInteraction materialCheckBox2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.WedD), ViewMatchers.withText("wed"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                9),
                        ViewMatchers.isDisplayed()));
        materialCheckBox2.perform(ViewActions.click());

        ViewInteraction materialCheckBox3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.FriD), ViewMatchers.withText("fri"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                11),
                        ViewMatchers.isDisplayed()));
        materialCheckBox3.perform(ViewActions.click());

        ViewInteraction materialButton8 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.Finalize), ViewMatchers.withText("Create Schedule"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                15),
                        ViewMatchers.isDisplayed()));
        materialButton8.perform(ViewActions.click());
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
