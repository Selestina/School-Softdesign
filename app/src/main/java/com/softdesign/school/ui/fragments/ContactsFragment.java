package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.adapters.UserAdapter;

import java.util.ArrayList;


public class ContactsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<User> mUsers = new ArrayList<User>();
    UserAdapter usersAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_contacts, null, false);
        getActivity().setTitle(getResources().getString(R.string.drawer_contacts));
        CollapsingToolbarLayout toolbar = (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapse_toolbar);
        // Заголовок фрагмента
        toolbar.setTitle(getResources().getString(R.string.drawer_contacts));
        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AppBarLayout appBar = (AppBarLayout) getActivity().findViewById(R.id.appbar_layout);
        NavigationView mNavigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
        FloatingActionButton actionButton = (FloatingActionButton) getActivity().findViewById(R.id.float_action_button);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) actionButton.getLayoutParams();
        generateData();
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new UserAdapter(mUsers);
        mRecyclerView.setAdapter(mAdapter);
/** Нет скроллинга тулбара */
        appBar.setExpanded(false);
        mRecyclerView.setNestedScrollingEnabled(false);

        params.setAnchorId(R.id.main_frame_container);
        params.anchorGravity= Gravity.RIGHT| Gravity.BOTTOM;
        actionButton.setImageResource(R.drawable.ic_email_24dp);
        actionButton.show();
    }

    private void generateData() {
        mUsers.add(new User("Арья", "Старк", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));

    }
}
