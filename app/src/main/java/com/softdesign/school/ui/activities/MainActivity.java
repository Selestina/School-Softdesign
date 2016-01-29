package com.softdesign.school.ui.activities;

import android.os.Build;
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
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**приватные переменные
     * mCheckBox - Checkbox
     * mButtonBlue - кнопка, изменяющая цвет Toolbar и Statusbar на синий
     * mButtonGreen - кнопка, изменяющая цвет Toolbar и Statusbar на зелёный
     * mButtonRed - кнопка, изменяющая цвет Toolbar и Statusbar на красный
     * mToolbar - кастомный ToolBar
     * mColorId - переменная с id цвета, меняющегося в Toolbar и StatusBar
     */
    private CheckBox mCheckBox;
    private Button mButtonBlue;
    private Button mButtonGreen;
    private Button mButtonRed;
    private Toolbar mToolbar;
    private int mColorId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Hello ");
        Lg.e(this.getLocalClassName(), "on create");

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mButtonBlue = (Button) findViewById(R.id.btn_blue);
        mButtonBlue.setOnClickListener(this);

        mButtonGreen = (Button) findViewById(R.id.btn_green);
        mButtonGreen.setOnClickListener(this);

        mButtonRed = (Button) findViewById(R.id.btn_red);
        mButtonRed.setOnClickListener(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mColorId = R.color.colorPrimary;
        setupToolbar();

    }
/** Метод проверяет , есть ли поддержка ActionBar. Если есть устанавливает Toolbar,
 *  иконку для кнопки Home*/
    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
    }
/** Обработчик события OnClick
 * кнопки (btn_blue, btn_green, btn_red) меняют при нажатии цвет Toolbar и Statusbar.
 * В mColorId записывается id цвета.*/
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.checkBox:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_blue:
                mToolbar.setBackgroundColor(getResources().getColor(R.color.blue));
                changeStatusbarColor(getResources().getColor(R.color.blue_dark));
                mColorId = R.color.blue;
                break;
            case R.id.btn_green:
                mToolbar.setBackgroundColor(getResources().getColor(R.color.green));
                changeStatusbarColor(getResources().getColor(R.color.green_dark));
                mColorId = R.color.green;
                break;
            case R.id.btn_red:
                mToolbar.setBackgroundColor(getResources().getColor(R.color.red));
                changeStatusbarColor(getResources().getColor(R.color.red_dark));
                mColorId = R.color.red;
                break;
        }
    }
/** метод меняет цвет Statusbar на цвет из ColorId.
 * Проверяет, поддерживается ли данная замена
 * вызывает метод, изменяющий цвет.*/
    private void changeStatusbarColor(int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(colorId);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mColorId", mColorId);
        Lg.e(this.getLocalClassName(), "Save instance");
    }
    /**Метод считывает из Bundle целочисленную переменную colorId с ID цвета Toolbar.
     * Если в Bundle она не определена, то берётся id цвета по умолчанию.
     * Далее изменяется цвет ToolBar и StatusBar c помощью метода changeStatusbarColor(). */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mColorId = savedInstanceState.getInt("mColorId");
        mToolbar.setBackgroundColor(getResources().getColor(mColorId));
        switch (mColorId) {
            case R.color.red:
                changeStatusbarColor(getResources().getColor(R.color.red_dark));
                break;
            case R.color.green:
                changeStatusbarColor(getResources().getColor(R.color.green_dark));
                break;
            case R.color.blue:
                changeStatusbarColor(getResources().getColor(R.color.blue_dark));
                break;
        }
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "Restore instance");
    }

    /** выводит сообщение при нажатии кнопки Home*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            Toast.makeText(this,"Menu",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "on stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "on restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "on destroy");
    }
}
