package com.eslamwaheed.ebookreader;

import android.app.Application;

import com.eslamwaheed.ebookreader.data.DataManager;
import com.eslamwaheed.ebookreader.di.component.ApplicationComponent;
import com.eslamwaheed.ebookreader.di.component.DaggerApplicationComponent;
import com.eslamwaheed.ebookreader.di.module.ApplicationModule;

import javax.inject.Inject;

public class App extends Application {
    private static final String TAG = "App";

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
