package com.eslamwaheed.ebookreader.ui.activity.main;

import android.os.AsyncTask;
import android.util.Log;

import com.eslamwaheed.ebookreader.data.DataManager;
import com.eslamwaheed.ebookreader.data.database.ReaderRepository;
import com.eslamwaheed.ebookreader.data.database.readpages.ReadPages;
import com.eslamwaheed.ebookreader.data.database.user.User;
import com.eslamwaheed.ebookreader.ui.base.BasePresenterIMP;
import com.eslamwaheed.ebookreader.util.CustomComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;

public class MainPresenterImp<T extends MainView> extends BasePresenterIMP<T> implements MainPresenter<T> {
    private static final String TAG = "MainPresenterImp";

    //members
    private List<User> userList;
    private List<ReadPages> readPagesList;

    @Inject
    MainPresenterImp(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void CalculateUserPagesNumber() {
        userList = new ArrayList<>();
        readPagesList = new ArrayList<>();
        final ReaderRepository readerRepository = new ReaderRepository(getBaseView().getContext());
        new AsyncTask<Void, Void, List<User>>() {

            @Override
            protected List<User> doInBackground(Void... voids) {
                userList = readerRepository.selectAllUsers();
                for (int i = 0; i < userList.size(); i++) {
                    readPagesList = readerRepository.selectReadPagesUser(userList.get(i).getId());
                    Set<Integer> userPagesSet = new TreeSet<>();
                    for (int j = 0; j < readPagesList.size(); j++) {
                        for (int k = readPagesList.get(j).getFrom(); k <= readPagesList.get(j).getTo(); k++) {
                            userPagesSet.add(k);
                        }
                        Log.d(TAG, "user set: >> " + userPagesSet);
                    }
                    userList.get(i).setNumberOfPages(userPagesSet.size());
                    readerRepository.updateUser(userList.get(i));
                    Log.d(TAG, "user name: >> " + userList.get(i).getName() +
                            ", user number >> " + userList.get(i).getNumberOfPages());
                }
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);
                Collections.sort(users, new CustomComparator());
                Log.d(TAG, "sorted Users: " + users);
                sendFirstUser(users.get(0));
                sendSecondUser(users.get(1));
                sendThirdUser(users.get(2));
                sendUsersList(users);
            }
        }.execute();
    }

    @Override
    public void sendFirstUser(User user) {
        getBaseView().setFirstUser(user);
    }

    @Override
    public void sendSecondUser(User user) {
        getBaseView().setSecondUser(user);
    }

    @Override
    public void sendThirdUser(User user) {
        getBaseView().setThirdUser(user);
    }

    @Override
    public void sendUsersList(List<User> userList) {
        getBaseView().setUserList(userList);
    }

    @Override
    public void setUsers() {
        final ReaderRepository readerRepository = new ReaderRepository(getBaseView().getContext());

        User user1 = new User();
        user1.setName("Eslam");

        User user2 = new User();
        user2.setName("Ahmed");

        User user3 = new User();
        user3.setName("Esraa");

        User user4 = new User();
        user4.setName("Mohamed");

        User user5 = new User();
        user5.setName("Ali");

        readerRepository.insertUser(user1);
        readerRepository.insertUser(user2);
        readerRepository.insertUser(user3);
        readerRepository.insertUser(user4);
        readerRepository.insertUser(user5);
    }

    @Override
    public void setReaderPages() {
        final ReaderRepository readerRepository = new ReaderRepository(getBaseView().getContext());

        ReadPages readPages1 = new ReadPages();
        readPages1.setUser_id(1);
        readPages1.setFrom(1);
        readPages1.setTo(10);

        ReadPages readPages2 = new ReadPages();
        readPages2.setUser_id(2);
        readPages2.setFrom(3);
        readPages2.setTo(6);

        ReadPages readPages3 = new ReadPages();
        readPages3.setUser_id(3);
        readPages3.setFrom(2);
        readPages3.setTo(10);

        ReadPages readPages4 = new ReadPages();
        readPages4.setUser_id(4);
        readPages4.setFrom(6);
        readPages4.setTo(10);

        ReadPages readPages5 = new ReadPages();
        readPages5.setUser_id(5);
        readPages5.setFrom(1);
        readPages5.setTo(10);

        ReadPages readPages6 = new ReadPages();
        readPages6.setUser_id(1);
        readPages6.setFrom(9);
        readPages6.setTo(15);

        ReadPages readPages7 = new ReadPages();
        readPages7.setUser_id(3);
        readPages7.setFrom(15);
        readPages7.setTo(20);

        readerRepository.insertReadPages(readPages1);
        readerRepository.insertReadPages(readPages2);
        readerRepository.insertReadPages(readPages3);
        readerRepository.insertReadPages(readPages4);
        readerRepository.insertReadPages(readPages5);
        readerRepository.insertReadPages(readPages6);
        readerRepository.insertReadPages(readPages7);
    }
}