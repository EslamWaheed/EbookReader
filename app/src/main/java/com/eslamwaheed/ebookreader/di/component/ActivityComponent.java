package com.eslamwaheed.ebookreader.di.component;


import com.eslamwaheed.ebookreader.di.PerActivity;
import com.eslamwaheed.ebookreader.di.module.ActivityModule;
import com.eslamwaheed.ebookreader.ui.activity.main.MainActivity;
import com.eslamwaheed.ebookreader.ui.activity.main.MainPresenter;
import com.eslamwaheed.ebookreader.ui.base.BaseActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    // inject into  (Activities, fragments & dialogs)
    void inject(BaseActivity baseActivity);

    void inject(MainActivity mainActivity);
}
