package com.eslamwaheed.ebookreader.data;

import android.content.Context;

import com.eslamwaheed.ebookreader.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManagerIMP implements DataManager {
    private static final String TAG = "DataManagerIMP";

    private final Context mContext;

    @Inject
    DataManagerIMP(@ApplicationContext Context context) {
        mContext = context;
    }
}
