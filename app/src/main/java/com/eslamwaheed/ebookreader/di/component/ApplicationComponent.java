package com.eslamwaheed.ebookreader.di.component;

import android.app.Application;
import android.content.Context;

import com.eslamwaheed.ebookreader.App;
import com.eslamwaheed.ebookreader.data.DataManager;
import com.eslamwaheed.ebookreader.di.ApplicationContext;
import com.eslamwaheed.ebookreader.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    // inject into
    void inject(App app);

    // exposing these instances to dependent components
    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}