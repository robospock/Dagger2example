package org.robospock.dagger2unittests;

import android.app.Application;
import android.content.Context;

import org.robospock.dagger2unittests.inject.AppComponent;

public class DaggerApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
    }

    public void buildComponentAndInject() {
        component = AppComponent.Initializer.init(this);
    }

    public static AppComponent component(Context context) {
        return ((DaggerApplication) context.getApplicationContext()).component;
    }
}