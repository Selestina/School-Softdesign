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

import butterknife.Bind;
import butterknife.ButterKnife;


public class ContactsFragment extends Fragment {


    /**mLayoutManager - LayoutManager, отвечающий за положение item элементов в RecyclerView
     * mAdapter - адаптер, вставляющий элементы из объектов User в item элементы
     * mRecyclerView - список элементов
     * mNavigationView - боковое меню
     * appBar
     * actionButton - FloatActionButton
     * collapseToolbar - тулбар*/

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<User> mUsers = new ArrayList<User>();

    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    @Bind(R.id.navigation_view) NavigationView mNavigationView;
    @Bind(R.id.appbar_layout) AppBarLayout appBar;
    @Bind(R.id.float_action_button) FloatingActionButton actionButton;
    @Bind(R.id.collapse_toolbar) CollapsingToolbarLayout toolbar;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_contacts, null, false);
        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, getActivity());

        /**Заголовок фрагмента*/
        toolbar.setTitle(getResources().getString(R.string.drawer_contacts));

        /**Выделяется данный пункт в меню */
        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) actionButton.getLayoutParams();
        /**Создание данных для mUser  */
        generateData();

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new UserAdapter(mUsers);
        mRecyclerView.setAdapter(mAdapter);
        /** Нет скроллинга тулбара */
        appBar.setExpanded(false);
        mRecyclerView.setNestedScrollingEnabled(false);

        /**FloatActionButton
         * ставиться в правый нижний угол
         * добавляется нужное изображение */
        params.setAnchorId(R.id.main_frame_container);
        params.anchorGravity= Gravity.RIGHT| Gravity.BOTTOM;
        actionButton.setImageResource(R.drawable.ic_email_24dp);
        actionButton.show();
    }

    /**Пользователи для контактов.
     * Вставляет в массив объекты User. */
    private void generateData() {
        mUsers.add(new User("Арья", "Старк", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));
        mUsers.add(new User("Джон", "Сноу", getResources().getDrawable(R.drawable.ic_account_circle_24dp)));

    }
}
