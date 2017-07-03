package id.ac.unipma.juzamma.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import id.ac.unipma.juzamma.data.db.model.Surah;
import id.ac.unipma.juzamma.data.db.model.Verse;
import id.ac.unipma.juzamma.di.ActivityContext;
import id.ac.unipma.juzamma.di.PerActivity;
import id.ac.unipma.juzamma.ui.main.MainMvpPresenter;
import id.ac.unipma.juzamma.ui.main.MainPagerAdapter;
import id.ac.unipma.juzamma.ui.main.MainPresenter;
import id.ac.unipma.juzamma.ui.main.MainView;
import id.ac.unipma.juzamma.ui.main.about.AboutMvpPresenter;
import id.ac.unipma.juzamma.ui.main.about.AboutPresenter;
import id.ac.unipma.juzamma.ui.main.about.AboutView;
import id.ac.unipma.juzamma.ui.main.help.HelpMvpPresenter;
import id.ac.unipma.juzamma.ui.main.help.HelpPresenter;
import id.ac.unipma.juzamma.ui.main.help.HelpView;
import id.ac.unipma.juzamma.ui.main.home.HomeMvpPresenter;
import id.ac.unipma.juzamma.ui.main.home.HomePresenter;
import id.ac.unipma.juzamma.ui.main.home.HomeView;
import id.ac.unipma.juzamma.ui.main.list.SurahAdapter;
import id.ac.unipma.juzamma.ui.main.list.ListMvpPresenter;
import id.ac.unipma.juzamma.ui.main.list.ListPresenter;
import id.ac.unipma.juzamma.ui.main.list.ListView;
import id.ac.unipma.juzamma.ui.read.ReadMvpPresenter;
import id.ac.unipma.juzamma.ui.read.ReadPresenter;
import id.ac.unipma.juzamma.ui.read.ReadView;
import id.ac.unipma.juzamma.ui.read.VerseAdapter;
import id.ac.unipma.juzamma.ui.splash.SplashMvpPresenter;
import id.ac.unipma.juzamma.ui.splash.SplashPresenter;
import id.ac.unipma.juzamma.ui.splash.SplashView;
import id.ac.unipma.juzamma.utils.rx.AppSchedulerProvider;
import id.ac.unipma.juzamma.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashView> provideSplashPresenter(
            SplashPresenter<SplashView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainView> provideMainPresenter(
            MainPresenter<MainView> presenter) {
        return presenter;
    }

    @Provides
    MainPagerAdapter provideMainPagerAdapter(AppCompatActivity activity) {
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    HomeMvpPresenter<HomeView> provideHomePresenter(
            HomePresenter<HomeView> presenter) {
        return presenter;
    }

    @Provides
    ListMvpPresenter<ListView> provideListPresenter(
            ListPresenter<ListView> presenter) {
        return presenter;
    }

    @Provides
    HelpMvpPresenter<HelpView> provideHelpPresenter(
            HelpPresenter<HelpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutView> provideAboutPresenter(
            AboutPresenter<AboutView> presenter) {
        return presenter;
    }

    @Provides
    SurahAdapter provideListAdapter() {
        return new SurahAdapter(new ArrayList<Surah>());
    }


    @Provides
    @PerActivity
    ReadMvpPresenter<ReadView> provideReadPresenter(
            ReadPresenter<ReadView> presenter) {
        return presenter;
    }

    @Provides
    VerseAdapter provideAdapter() {
        return new VerseAdapter(new ArrayList<Verse>());
    }

}
