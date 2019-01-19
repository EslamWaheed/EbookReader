package com.eslamwaheed.ebookreader.ui.activity.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.eslamwaheed.ebookreader.R;
import com.eslamwaheed.ebookreader.data.database.user.User;
import com.eslamwaheed.ebookreader.di.component.ActivityComponent;
import com.eslamwaheed.ebookreader.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {
    private final static String TAG = "MainActivity";

    //member
    MainAdapter mainAdapter;

    //bind views
    @BindView(R.id.tv_second_user_name)
    TextView tv_second_user_name;
    @BindView(R.id.tv_second_user_page_number)
    TextView tv_second_user_page_number;
    @BindView(R.id.tv_first_user_name)
    TextView tv_first_user_name;
    @BindView(R.id.tv_first_user_page_number)
    TextView tv_first_user_page_number;
    @BindView(R.id.tv_third_user_name)
    TextView tv_third_user_name;
    @BindView(R.id.tv_third_user_page_number)
    TextView tv_third_user_page_number;
    @BindView(R.id.recycler_view_list_of_users)
    RecyclerView recycler_view_list_of_users;

    //injection
    @Inject
    MainPresenter<MainView> mainPresenter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this));
            mainPresenter.onAttach(this);
        }

        recycler_view_list_of_users.setLayoutManager(linearLayoutManager);
        mainAdapter = new MainAdapter(mainPresenter);
        recycler_view_list_of_users.setAdapter(mainAdapter);

        //set users to database
        mainPresenter.setUsers();

        //set readPages to database
        mainPresenter.setReaderPages();

        //calculate users pages number
        mainPresenter.CalculateUserPagesNumber();
    }

    @Override
    public void setFirstUser(User firstUser) {
        tv_first_user_name.setText(firstUser.getName());
        tv_first_user_page_number.setText(String.valueOf(firstUser.getNumberOfPages()));
    }

    @Override
    public void setSecondUser(User secondUser) {
        tv_second_user_name.setText(secondUser.getName());
        tv_second_user_page_number.setText(String.valueOf(secondUser.getNumberOfPages()));
    }

    @Override
    public void setThirdUser(User thirdUser) {
        tv_third_user_name.setText(thirdUser.getName());
        tv_third_user_page_number.setText(String.valueOf(thirdUser.getNumberOfPages()));
    }

    @Override
    public void setUserList(List<User> userList) {
        mainAdapter.refreshList(userList);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
