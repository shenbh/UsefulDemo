package com.ab.myframe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ab.myframe.util.BottomNavigationViewHelper;

public class HostActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextFragment fragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new TextFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //去掉不显示图片默认颜色
        bottomNavigationView.setItemIconTintList(null);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        resetToDefaultIcon();
        @StringRes int text = 0;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                text = R.string.title_home;

                item.setIcon(R.drawable.index_pressed);
                break;
            case R.id.navigation_dashboard:
                text = R.string.title_dashboard;

                item.setIcon(R.drawable.names_pressed);
                break;
            case R.id.navigation_notifications:
                text = R.string.title_notifications;

                item.setIcon(R.drawable.news_pressed);
                break;
            case R.id.navigation_mine:
                text = R.string.title_mine;

                item.setIcon(R.drawable.mine_pressed);
                break;
            default:
                return false;
        }
        switchFragmentText(text);
        return true;
    }

    private void switchFragmentText(@StringRes int text) {
        fragment.setText(text);
    }

    private MenuItem home, names, news, mine;
    private void resetToDefaultIcon() {
        if (null == home) {
            home = bottomNavigationView.getMenu().findItem(R.id.navigation_home);
        }
        home.setIcon(R.drawable.index);
        if(null == names){
            names = bottomNavigationView.getMenu().findItem(R.id.navigation_dashboard);
        }
        names.setIcon(R.drawable.names);
        if(null == news){
            news = bottomNavigationView.getMenu().findItem(R.id.navigation_notifications);
        }
        news.setIcon(R.drawable.news);
        if (null == mine){
            mine = bottomNavigationView.getMenu().findItem(R.id.navigation_mine);
        }
        mine.setIcon(R.drawable.mine);
    }
}
