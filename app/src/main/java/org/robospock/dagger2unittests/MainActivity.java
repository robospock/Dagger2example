package org.robospock.dagger2unittests;

import android.app.Activity;
import android.os.Bundle;

import org.robospock.dagger2unittests.inject.Injector;

import javax.inject.Inject;


public class MainActivity extends Activity {

    @Inject
    Toaster toaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Injector.get().inject(this);

        toaster.makeToast(true);
    }
}
