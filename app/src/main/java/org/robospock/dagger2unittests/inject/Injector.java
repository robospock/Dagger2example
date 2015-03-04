package org.robospock.dagger2unittests.inject;

import android.content.Context;

public class Injector {

    static AppComponent component;

    // Normally the Andorid Application object uses this method for production run
    public static void init(Context context){
        component = AppComponent.Initializer.init(new ToasterModule(context));
    }

    // This is a window for unit tests to override modules
    public static void override(ToasterModule toasterModule){
        component = AppComponent.Initializer.init(toasterModule);
    }

    public static AppComponent get(){
        return component;
    }
}
