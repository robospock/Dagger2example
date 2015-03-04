package org.robospock.dagger2unittests;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import javax.inject.Inject;


public class MainActivity extends ActionBarActivity {

    @Inject
    Toaster toaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerApplication.component(this).inject(this);

        toaster.makeToast(true);
    }
}
