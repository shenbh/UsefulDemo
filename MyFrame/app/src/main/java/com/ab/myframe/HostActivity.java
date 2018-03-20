package com.ab.myframe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ab.myframe.firsttab.FirstFragment;
import com.ab.myframe.fourthtab.FourthFragment;
import com.ab.myframe.secondtab.SecondFragment;
import com.ab.myframe.thirdtab.ThirdFragment;
import com.ab.myframe.util.BottomNavigationViewHelper;

public class HostActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        FirstFragment firstFragment = FirstFragment.getInstance("first");
        transaction.replace(R.id.fragment_container, firstFragment);

        transaction.commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //去掉不显示图片默认颜色
        bottomNavigationView.setItemIconTintList(null);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        resetToDefaultIcon();
        @StringRes int text = 0;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                text = R.string.title_home;

                item.setIcon(R.drawable.index_pressed);

                FirstFragment firstFragment = FirstFragment.getInstance(getResources().getString(text));
                transaction.replace(R.id.fragment_container, firstFragment);
                transaction.commit();
                break;
            case R.id.navigation_dashboard:
                text = R.string.title_dashboard;

                item.setIcon(R.drawable.names_pressed);

                SecondFragment secondFragment = SecondFragment.getInstance(getResources().getString(text));
                transaction.replace(R.id.fragment_container, secondFragment);
                transaction.commit();
                break;
            case R.id.navigation_notifications:
                text = R.string.title_notifications;

                item.setIcon(R.drawable.news_pressed);

                ThirdFragment thirdFragment = ThirdFragment.getInstance(getResources().getString(text));
                transaction.replace(R.id.fragment_container, thirdFragment);
                transaction.commit();
                break;
            case R.id.navigation_mine:
                text = R.string.title_mine;

                item.setIcon(R.drawable.mine_pressed);

                FourthFragment fourthFragment = FourthFragment.getInstance(getResources().getString(text));
                transaction.replace(R.id.fragment_container, fourthFragment);
                transaction.commit();
                break;
            default:
                return false;
        }
        return true;
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
