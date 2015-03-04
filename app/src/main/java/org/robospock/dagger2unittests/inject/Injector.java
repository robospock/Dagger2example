package org.robospock.dagger2unittests.inject;

import android.content.Context;

public class Injector {

    static AppComponent component;

    public static void init(Context context){
        component = AppComponent.Initializer.init(context);
    }

    public static AppComponent get(){
        return component;
    }
}
