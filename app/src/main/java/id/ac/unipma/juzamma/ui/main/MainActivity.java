package id.ac.unipma.juzamma.ui.main;

import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unipma.juzamma.R;
import id.ac.unipma.juzamma.ui.base.BaseActivity;
import id.ac.unipma.juzamma.ui.helper.CustomViewPager;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainMvpPresenter<MainView> mPresenter;

    @Inject
    MainPagerAdapter mPagerAdapter;

    @BindView(R.id.pager)
    CustomViewPager mViewPager;

    @BindView(R.id.bottom_navigation)
    AHBottomNavigation mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();

    }


    @Override
    protected void setUp() {
        initializedNavigation();

        mViewPager.setPagingEnabled(false);
        mViewPager.setAdapter(mPagerAdapter);
        mPagerAdapter.setCount(4);

    }

    @Override
    public void initializedNavigation() {
        AHBottomNavigationItem mBeranda = new AHBottomNavigationItem(
                R.string.beranda,
                R.drawable.ic_home,
                R.color.colorAccent);

        AHBottomNavigationItem mDaftarIsi = new AHBottomNavigationItem(
                R.string.menu_daftar_isi,
                R.drawable.ic_list,
                R.color.colorAccent);

        AHBottomNavigationItem mPetunjuk = new AHBottomNavigationItem(
                R.string.menu_petunjuk,
                R.drawable.ic_help,
                R.color.colorAccent);

        AHBottomNavigationItem mTentang = new AHBottomNavigationItem(
                R.string.menu_tentang,
                R.drawable.ic_info,
                R.color.colorAccent);

        mBottomNavigation.addItem(mBeranda);
        mBottomNavigation.addItem(mDaftarIsi);
        mBottomNavigation.addItem(mPetunjuk);
        mBottomNavigation.addItem(mTentang);
        mBottomNavigation.setBehaviorTranslationEnabled(false);

        mBottomNavigation.setAccentColor(R.color.white);
        mBottomNavigation.setInactiveColor(R.color.secondary_text);
        //mBottomNavigation.setForceTint(true);
        mBottomNavigation.setColored(true);


        mBottomNavigation.setOnTabSelectedListener((position, wasSelected) -> {

            mViewPager.setCurrentItem(position);
            return true;
        });

    }

    @Override
    public void showOrHideBottomNavigation(boolean show) {
        if (show) {
            mBottomNavigation.restoreBottomNavigation(true);
        } else {
            mBottomNavigation.hideBottomNavigation(true);
        }
    }

}
