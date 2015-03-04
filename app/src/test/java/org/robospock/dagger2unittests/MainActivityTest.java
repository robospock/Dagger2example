package org.robospock.dagger2unittests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Before
    public void setup() {
        ShadowToast.reset();
    }

    @Test
    public void shouldShowBurnedToast() {
        // given
        ActivityController<MainActivity> buildActivity = Robolectric.buildActivity(MainActivity.class);

        // when
        buildActivity.create();

        // then
        Assert.assertEquals("Burned", ShadowToast.getTextOfLatestToast());
    }
}
