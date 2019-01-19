package com.eslamwaheed.ebookreader.ui.base;

import android.support.annotation.StringRes;

public interface BaseView {

    void showFullLoading();

    void hideFullLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showToastMessage(String message);

    void showToastMessage(@StringRes int resId);

    void showSnackMessage(String message);

    void showSnackMessage(@StringRes int resId);

    void showLoadingProgressDialog(String message);

    void hideLoadingProgressDialog();

    boolean isNetworkConnected();

    void hideKeyboard();

}
