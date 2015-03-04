package org.robospock.dagger2unittests.inject;

import android.content.Context;

import org.robospock.dagger2unittests.MainActivity;
import org.robospock.dagger2unittests.Toaster;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ToasterModule.class})
public interface AppComponent {

    public final static class Initializer {

        public static AppComponent init(Context context) {
            return Dagger_AppComponent.builder()
                    .toasterModule(new ToasterModule(context))
                    .build();
        }
    }

    void inject(MainActivity mainActivity);

    void inject(Toaster toaster);
}
