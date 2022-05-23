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
public class GPA_ACCEPTANCE_TEST {

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
    public void gPA_ACCEPTANCE_TEST() {
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
        appCompatEditText2.perform(ViewActions.replaceText("ton123"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.retypePass),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        appCompatEditText3.perform(ViewActions.replaceText("ton123"), ViewActions.closeSoftKeyboard());

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
        appCompatEditText4.perform(ViewActions.replaceText("ton123"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.input_Password),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText5.perform(ViewActions.replaceText("ton123"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.signBtn), ViewMatchers.withText("sign_in"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        materialButton3.perform(ViewActions.click());

        ViewInteraction appCompatEditText6 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.add_institution),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText6.perform(ViewActions.replaceText("UM"), ViewActions.closeSoftKeyboard());

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
                Matchers.allOf(ViewMatchers.withText("2080\nAnalysis of Algorithms"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.linearLayout),
                                        childAtPosition(
                                                ViewMatchers.withId(R.id.relativeLayout),
                                                0)),
                                1)));
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
                Matchers.allOf(ViewMatchers.withId(R.id.button5), ViewMatchers.withText("GPA Calculator"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                1),
                        ViewMatchers.isDisplayed()));
        materialButton6.perform(ViewActions.click());

        ViewInteraction appCompatEditText7 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.course),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.gpa_firstpage),
                                        childAtPosition(
                                                ViewMatchers.withId(android.R.id.content),
                                                0)),
                                1),
                        ViewMatchers.isDisplayed()));
        appCompatEditText7.perform(ViewActions.replaceText("COMP3350"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton7 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.addButton), ViewMatchers.withText("Let's Go"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.gpa_firstpage),
                                        childAtPosition(
                                                ViewMatchers.withId(android.R.id.content),
                                                0)),
                                3),
                        ViewMatchers.isDisplayed()));
        materialButton7.perform(ViewActions.click());

        ViewInteraction appCompatEditText8 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.numGrade),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                3),
                        ViewMatchers.isDisplayed()));
        appCompatEditText8.perform(ViewActions.replaceText("3"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.GradeYouWant),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                4),
                        ViewMatchers.isDisplayed()));
        appCompatEditText9.perform(ViewActions.replaceText("80"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton8 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button), ViewMatchers.withText("Create GPA planner"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(android.R.id.content),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        materialButton8.perform(ViewActions.click());

        ViewInteraction editText = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.name_grade),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        editText.perform(ViewActions.replaceText("MIDTERM"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.name_grade),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        1),
                                0),
                        ViewMatchers.isDisplayed()));
        editText2.perform(ViewActions.click());

        ViewInteraction editText3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.name_grade),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        1),
                                0),
                        ViewMatchers.isDisplayed()));
        editText3.perform(ViewActions.replaceText("FINAL"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText4 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.name_grade),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        2),
                                0),
                        ViewMatchers.isDisplayed()));
        editText4.perform(ViewActions.replaceText("ASSIGNMENTS"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText5 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_earned),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        editText5.perform(ViewActions.replaceText("80"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText6 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_earned),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        1),
                                2),
                        ViewMatchers.isDisplayed()));
        editText6.perform(ViewActions.replaceText("70"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText7 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_contribution),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        0),
                                1),
                        ViewMatchers.isDisplayed()));
        editText7.perform(ViewActions.replaceText("40"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText8 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_contribution),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        1),
                                1),
                        ViewMatchers.isDisplayed()));
        editText8.perform(ViewActions.replaceText("30"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText9 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_contribution),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        2),
                                1),
                        ViewMatchers.isDisplayed()));
        editText9.perform(ViewActions.replaceText("30"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton9 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button5), ViewMatchers.withText("Get result"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.relativeLayout),
                                        childAtPosition(
                                                ViewMatchers.withClassName(Matchers.is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                5),
                        ViewMatchers.isDisplayed()));
        materialButton9.perform(ViewActions.click());

        ViewInteraction materialButton10 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(android.R.id.button1), ViewMatchers.withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton10.perform(ViewActions.scrollTo(), ViewActions.click());

        ViewInteraction materialButton11 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button5), ViewMatchers.withText("Get result"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.relativeLayout),
                                        childAtPosition(
                                                ViewMatchers.withClassName(Matchers.is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                5),
                        ViewMatchers.isDisplayed()));
        materialButton11.perform(ViewActions.click());

        ViewInteraction materialButton12 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(android.R.id.button2), ViewMatchers.withText("Reset and try again."),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                2)));
        materialButton12.perform(ViewActions.scrollTo(), ViewActions.click());

        ViewInteraction editText10 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.name_grade),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        editText10.perform(ViewActions.replaceText("MID"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText11 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.name_grade),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        1),
                                0),
                        ViewMatchers.isDisplayed()));
        editText11.perform(ViewActions.replaceText("FINAL"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText12 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.name_grade),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        2),
                                0),
                        ViewMatchers.isDisplayed()));
        editText12.perform(ViewActions.replaceText("ASSIGNMENT"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText13 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_earned),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        editText13.perform(ViewActions.click());

        ViewInteraction editText14 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_earned),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        0),
                                2),
                        ViewMatchers.isDisplayed()));
        editText14.perform(ViewActions.replaceText("80"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText15 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_earned),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        1),
                                2),
                        ViewMatchers.isDisplayed()));
        editText15.perform(ViewActions.replaceText("70"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText16 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_contribution),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        0),
                                1),
                        ViewMatchers.isDisplayed()));
        editText16.perform(ViewActions.replaceText("30"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText17 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_contribution),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        1),
                                1),
                        ViewMatchers.isDisplayed()));
        editText17.perform(ViewActions.replaceText("40"), ViewActions.closeSoftKeyboard());

        ViewInteraction editText18 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.grade_contribution),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.container2),
                                        2),
                                1),
                        ViewMatchers.isDisplayed()));
        editText18.perform(ViewActions.replaceText("30"), ViewActions.closeSoftKeyboard());

        ViewInteraction materialButton13 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button5), ViewMatchers.withText("Get result"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.relativeLayout),
                                        childAtPosition(
                                                ViewMatchers.withClassName(Matchers.is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                5),
                        ViewMatchers.isDisplayed()));
        materialButton13.perform(ViewActions.click());

        ViewInteraction materialButton14 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(android.R.id.button1), ViewMatchers.withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton14.perform(ViewActions.scrollTo(), ViewActions.click());

        ViewInteraction materialButton15 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.gradeSave), ViewMatchers.withText("Save Result"),
                        childAtPosition(
                                Matchers.allOf(ViewMatchers.withId(R.id.relativeLayout),
                                        childAtPosition(
                                                ViewMatchers.withClassName(Matchers.is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                6),
                        ViewMatchers.isDisplayed()));
        materialButton15.perform(ViewActions.click());

        ViewInteraction button3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.courseinfo), ViewMatchers.withText("Saved GPA Plan with 3 types of grade"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.courseGrades),
                                        0),
                                1),
                        ViewMatchers.isDisplayed()));
        button3.perform(ViewActions.click());

        ViewInteraction materialButton16 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(android.R.id.button1), ViewMatchers.withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton16.perform(ViewActions.scrollTo(), ViewActions.click());

        ViewInteraction button4 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.delete), ViewMatchers.withText("Delete GPA plan"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.courseGrades),
                                        0),
                                0),
                        ViewMatchers.isDisplayed()));
        button4.perform(ViewActions.click());
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
