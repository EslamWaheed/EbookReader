package com.eslamwaheed.ebookreader.di.module;

import android.app.Application;
import android.content.Context;

import com.eslamwaheed.ebookreader.data.DataManager;
import com.eslamwaheed.ebookreader.data.DataManagerIMP;
import com.eslamwaheed.ebookreader.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerIMP dataManagerIMP) {
        return dataManagerIMP;
    }
}