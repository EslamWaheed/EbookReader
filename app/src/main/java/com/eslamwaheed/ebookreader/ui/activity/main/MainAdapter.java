package com.eslamwaheed.ebookreader.ui.activity.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eslamwaheed.ebookreader.R;
import com.eslamwaheed.ebookreader.data.database.user.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private static final String TAG = "MainAdapter";

    private List<User> userList;
    private MainPresenter<MainView> mainPresenter;

    MainAdapter(MainPresenter<MainView> mainPresenter) {
        this.userList = new ArrayList<>();
        this.mainPresenter = mainPresenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        User user = userList.get(i);
        viewHolder.tv_user_list_item_number.setText(String.valueOf(i + 1));
        viewHolder.tv_user_list_item_name.setText(user.getName());
        viewHolder.tv_user_list_item_page_number.setText(String.valueOf(user.getNumberOfPages()) + " Pages");
    }

    @Override
    public int getItemCount() {
        if (userList != null) {
            return userList.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        @BindView(R.id.tv_user_list_item_number)
        TextView tv_user_list_item_number;
        @BindView(R.id.tv_user_list_item_name)
        TextView tv_user_list_item_name;
        @BindView(R.id.tv_user_list_item_page_number)
        TextView tv_user_list_item_page_number;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }
    }

    void refreshList(List<User> userList) {
        this.userList.addAll(userList);
        notifyDataSetChanged();
    }

    void clearList() {
        this.userList.clear();
        notifyDataSetChanged();
    }
}
