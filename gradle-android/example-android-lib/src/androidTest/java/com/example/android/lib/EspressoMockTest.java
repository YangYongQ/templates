package com.example.android.lib;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

/**
 * Created by mrseasons on 2015/09/18.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoMockTest {

    @Rule
    public ActivityTestRule<CalculatorActivity> activityTestRule
            = new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void testAdd() {
        onView(ViewMatchers.withId(R.id.number1)).perform(typeText("2"));
        onView(ViewMatchers.withId(R.id.number2)).perform(typeText("20"));

        onView(ViewMatchers.withId(R.id.calc)).perform(click());

        onView(ViewMatchers.withId(R.id.result)).check(matches(ViewMatchers.withText("22")));
        
        Bean bean = Mockito.mock(Bean.class);
        Mockito.when(bean.getCount()).thenReturn(100);
        Assertions.assertThat(bean.getCount()).isEqualTo(100);


    }
}
