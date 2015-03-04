package org.robospock.dagger2unittests;

import android.app.Application;

import org.robospock.dagger2unittests.inject.Injector;

public class DaggerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
    }

    public void buildComponentAndInject() {
        Injector.init(this);
    }

}