package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_profile, null, false);
        getActivity().setTitle(getResources().getString(R.string.drawer_profile));
        CollapsingToolbarLayout toolbar = (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapse_toolbar);
        // Заголовок фрагмента
        toolbar.setTitle(getResources().getString(R.string.header_name));
        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        NavigationView mNavigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
        FloatingActionButton actionButton = (FloatingActionButton) getActivity().findViewById(R.id.float_action_button);
        AppBarLayout appBar = (AppBarLayout) getActivity().findViewById(R.id.appbar_layout);

        appBar.setExpanded(true);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) actionButton.getLayoutParams();
        /**Кнопка  FloatActionButton
         * положение и нужное изображение*/
        params.setAnchorId(R.id.appbar_layout);
        params.anchorGravity= Gravity.RIGHT| Gravity.BOTTOM;
        actionButton.setImageResource(R.drawable.ic_create_24dp);
        actionButton.show();
    }
}
