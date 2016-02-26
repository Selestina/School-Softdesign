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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SettingFragment extends Fragment {

    /** appBar - AppBarLayout
     * actionButton FloatingActionButton
     * mNavigationView - боковое меню
     * toolbar - тулбар*/
    @Bind(R.id.appbar_layout) AppBarLayout appBar;
    @Bind(R.id.float_action_button) FloatingActionButton actionButton;
    @Bind(R.id.navigation_view) NavigationView mNavigationView;
    @Bind(R.id.collapse_toolbar)CollapsingToolbarLayout toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_setting, null, false);

        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, getActivity());

        // Заголовок фрагмента
        toolbar.setTitle(getResources().getString(R.string.drawer_setting));

        /**Выделяется данный пункт в меню */
        mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(true);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) actionButton.getLayoutParams();

        appBar.setExpanded(false);
    }
}
