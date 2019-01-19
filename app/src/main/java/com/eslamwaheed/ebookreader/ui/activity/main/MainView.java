package com.eslamwaheed.ebookreader.ui.activity.main;

import android.content.Context;

import com.eslamwaheed.ebookreader.data.database.user.User;
import com.eslamwaheed.ebookreader.ui.base.BaseView;

import java.util.List;

public interface MainView extends BaseView {
    void setFirstUser(User firstUser);

    void setSecondUser(User secondUser);

    void setThirdUser(User thirdUser);

    void setUserList(List<User> userList);

    Context getContext();
}
