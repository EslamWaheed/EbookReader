package com.eslamwaheed.ebookreader.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.eslamwaheed.ebookreader.di.ActivityContext;
import com.eslamwaheed.ebookreader.ui.activity.main.MainPresenter;
import com.eslamwaheed.ebookreader.ui.activity.main.MainPresenterImp;
import com.eslamwaheed.ebookreader.ui.activity.main.MainView;
import com.eslamwaheed.ebookreader.ui.base.BasePresenter;
import com.eslamwaheed.ebookreader.ui.base.BasePresenterIMP;
import com.eslamwaheed.ebookreader.ui.base.BaseView;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule { // providing (Adapters, Presenters, LayoutManagers, Disposables)
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    BasePresenter<BaseView> provideBasePresenter(
            BasePresenterIMP<BaseView> presenter) {
        return presenter;
    }

    @Provides
    MainPresenter<MainView> provideMainPresenter(MainPresenterImp<MainView> mainPresenterImp) {
        return mainPresenterImp;
    }
}
