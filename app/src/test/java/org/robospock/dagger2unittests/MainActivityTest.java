package org.robospock.dagger2unittests;

import android.content.Context;
import android.widget.Toast;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;
import org.robospock.dagger2unittests.inject.Injector;
import org.robospock.dagger2unittests.inject.ToasterModule;

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

    @Test
    public void showShowJuicyToast() {
        // given create mock toaster
        final Toaster mock = Mockito.mock(Toaster.class);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Toast.makeText(Robolectric.application, "Juicy", Toast.LENGTH_SHORT).show();
                return null;
            }
        }).when(mock).makeToast(true);

        // and, provide other toaster
        Injector.override(new ToasterModule(Robolectric.application) {
            @Override
            public Toaster provideToaster(Context context) {
                return mock;
            }
        });

        // and
        ActivityController<MainActivity> buildActivity = Robolectric.buildActivity(MainActivity.class);

        // when
        buildActivity.create();

        // then
        Assert.assertEquals("Juicy", ShadowToast.getTextOfLatestToast());
    }
}
