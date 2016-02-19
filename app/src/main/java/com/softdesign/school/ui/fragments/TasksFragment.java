package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;


public class TasksFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_tasks, null, false);
        getActivity().setTitle(getResources().getString(R.string.drawer_tasks));
        CollapsingToolbarLayout toolbar = (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapse_toolbar);
        // Заголовок фрагмента
        toolbar.setTitle(getResources().getString(R.string.drawer_tasks));
        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        NavigationView mNavigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        mNavigationView.getMenu().findItem(R.id.drawer_tasks).setChecked(true);

        FloatingActionButton actionButton = (FloatingActionButton) getActivity().findViewById(R.id.float_action_button);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) actionButton.getLayoutParams();

        AppBarLayout appBar = (AppBarLayout) getActivity().findViewById(R.id.appbar_layout);
        appBar.setExpanded(false);

    }
}
