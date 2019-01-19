package com.eslamwaheed.ebookreader.ui.base;

import com.eslamwaheed.ebookreader.data.DataManager;

import javax.inject.Inject;

public class BasePresenterIMP<V extends BaseView> implements BasePresenter<V> {
    private static final String TAG = "BasePresenterIMP";

    private final DataManager mDataManager;
    private V mMvpView;

    @Inject
    public BasePresenterIMP(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    @Override
    public void handleApiError(Throwable error) {
    }


    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getBaseView() {
        return mMvpView;
    }


    public DataManager getDataManager() {
        return mDataManager;
    }

    @Override
    public String getAppLanguage() {
        return "";
    }

    @Override
    public void onLanguageSelected(String value) {
    }

    @Override
    public String getAppCurrency() {
        return "";
    }

    @Override
    public void onCurrencySelected(String s) {
    }
}
