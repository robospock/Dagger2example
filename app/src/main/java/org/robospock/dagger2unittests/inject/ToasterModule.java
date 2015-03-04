package org.robospock.dagger2unittests.inject;

import android.content.Context;

import org.robospock.dagger2unittests.Toaster;

import dagger.Module;
import dagger.Provides;

@Module
public class ToasterModule {

    Context context;

    public ToasterModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    Toaster provideToaster(Context context){
        return new Toaster(context);
    }

}
