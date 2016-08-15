package com.jonkoester.junkdrawer;

import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public AlwaysRunOnUIThreadRule uiThreadRule = new AlwaysRunOnUIThreadRule();

    private MainActivity testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new MainActivity();
    }

    @Test
    public void testMoveToRecyclerViewActivity() throws Exception {
        testObject.moveToRecyclerViewActivity();

        verify(testObject).startActivity(any(Intent.class));
    }
}