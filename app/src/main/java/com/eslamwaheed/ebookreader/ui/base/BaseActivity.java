package com.eslamwaheed.ebookreader.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import com.eslamwaheed.ebookreader.App;
import com.eslamwaheed.ebookreader.di.component.ActivityComponent;
import com.eslamwaheed.ebookreader.di.component.DaggerActivityComponent;
import com.eslamwaheed.ebookreader.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.Unbinder;

public abstract class
BaseActivity extends AppCompatActivity implements BaseView {
    private static final String TAG = "BaseActivity";

    private ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;

    @Inject
    BasePresenter<BaseView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((App) getApplication()).getComponent()) // for exposing needed instances from parent component
                .build();
        mActivityComponent.inject(this);
    }

    private void setAppLocale(String appLanguage) {
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }


    public void hideKeyboard() {
    }


    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }


    @Override
    public void showFullLoading() {

    }

    @Override
    public void hideFullLoading() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showToastMessage(String message) {

    }

    @Override
    public void showToastMessage(@StringRes int resId) {
    }

    @Override
    public void showSnackMessage(String message) {
    }

    @Override
    public void showSnackMessage(int message) {

    }

    @Override
    public void showLoadingProgressDialog(String message) {

    }

    @Override
    public void hideLoadingProgressDialog() {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

}
