package com.eslamwaheed.ebookreader.ui.activity.main;

import com.eslamwaheed.ebookreader.data.database.user.User;
import com.eslamwaheed.ebookreader.ui.base.BasePresenter;

import java.util.List;

public interface MainPresenter<T extends MainView> extends BasePresenter<T> {
    void CalculateUserPagesNumber();

    void sendFirstUser(User user);

    void sendSecondUser(User user);

    void sendThirdUser(User user);

    void sendUsersList(List<User> userList);

    void setUsers();

    void setReaderPages();
}
