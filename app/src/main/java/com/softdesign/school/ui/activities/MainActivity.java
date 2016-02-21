package com.softdesign.school.ui.activities;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    /**приватные переменные
     * mToolbar - кастомный ToolBar
     * mFragment - фрагмент
     */

    private Fragment mFragment;

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.navigation_drawer) DrawerLayout mNavigationDrawer;
    @Bind(R.id.navigation_view) NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupToolbar();
        setupDrawer();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, new ProfileFragment()).commit();

    }
/** Устанавливает Toolbar,
 *  иконку для кнопки Home*/
    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /** при нажатии кнопки Home появляется меню*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
/**Взаимодействие с пунктами меню.
 * Работа с фрагментами. */
    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();;
                        break;
                    case R.id.drawer_setting:
                        mFragment = new SettingFragment();
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        break;
                }
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(null).commit();
                }
                mNavigationDrawer.closeDrawers();
                return false;
            }
        });
    }
 /** Обрабатывает нажатие на клавишу Back */
    public void onBackPressed() {
        super.onBackPressed();
        mFragment = getSupportFragmentManager().findFragmentById(R.id.main_frame_container);
    }
}
