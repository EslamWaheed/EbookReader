package com.eslamwaheed.ebookreader.ui.base;

public interface BasePresenter<V extends BaseView> {

    void onAttach(V view);

    void onDetach();

    void handleApiError(Throwable error);

    String getAppLanguage();

    void onLanguageSelected(String value);

    String getAppCurrency();

    void onCurrencySelected(String s);
}
